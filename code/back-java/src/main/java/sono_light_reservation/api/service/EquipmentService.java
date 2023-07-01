package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EquipmentDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Equipment;
import sono_light_reservation.api.repository.CategoryRepository;
import sono_light_reservation.api.repository.EquipmentRepository;
import sono_light_reservation.api.service.mapper.EquipmentMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Read the details of the equipment get by id
     *
     * @param id
     * @return equipment
     */
    public Optional<EquipmentDto> getEquipment(final int id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        EquipmentDto equipmentDto = equipmentMapper.convertToDto(equipment);
        return Optional.ofNullable(equipmentDto);
    }

    /**
     * List of all the equipments
     *
     * @return the list of the equipments
     */
    public List<EquipmentDto> getEquipments() {
        return ((List<Equipment>) equipmentRepository.findAll()).stream()
                .map(equipment -> equipmentMapper.convertToDto(Optional.ofNullable(equipment)))
                .collect(Collectors.toList());
    }

    /**
     * Save equipment
     *
     * @param equipmentDto: Save
     */
    public EquipmentDto saveEquipment(EquipmentDto equipmentDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(equipmentDto.getCategory());
        Category category = categoryOptional.orElse(null);

        Equipment equipment = equipmentMapper.convertToEntity(equipmentDto, category);
        equipmentRepository.save(equipment);
        return equipmentMapper.convertToDto(Optional.of(equipment));
    }

    /**
     * Delete existant equipment
     *
     * @param id
     * @return String: confirm of the suppression
     */
    public String deleteEquipment(final int id) {
        equipmentRepository.deleteById(id);
        if (equipmentRepository.findById(id).isEmpty()) {
            return "equipment deleted";
        } else {
            return "Error in the deletion";
        }
    }

    /**
     * Update the details of the equipment get by id
     *
     * @param id
     * @param updatedEquipment
     * @return equipment with modifications
     */
    public EquipmentDto updateEquipment(int id, EquipmentDto updatedEquipment) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id equipment invalide:" + id));
        if (updatedEquipment.getLabel() != null) {
            equipment.setLabel(updatedEquipment.getLabel());
        }
        if (updatedEquipment.getModel() != null) {
            equipment.setModel(updatedEquipment.getModel());
        }
        if (updatedEquipment.getReference() != null) {
            equipment.setReference(updatedEquipment.getReference());
        }
        if (updatedEquipment.getOwner() != null) {
            equipment.setOwner(updatedEquipment.getOwner());
        }
        if (updatedEquipment.getCable_size() != null) {
            equipment.setCable_size(updatedEquipment.getCable_size());
        }
        if (updatedEquipment.getComment() != null) {
            equipment.setComment(updatedEquipment.getComment());
        }

        equipment.setWear_rate_return(updatedEquipment.getWear_rate_return());

        if (updatedEquipment.getDate_buy() != null) {
            equipment.setDate_buy(updatedEquipment.getDate_buy());
        }
        if (updatedEquipment.getDayly_price() != null) {
            equipment.setDayly_price(updatedEquipment.getDayly_price());
        }
        if (updatedEquipment.getReplacement_price() != null) {
            equipment.setReplacement_price(updatedEquipment.getReplacement_price());
        }

        Optional<Category> categoryOptional = categoryRepository.findById(updatedEquipment.getCategory());
        Category category = categoryOptional.orElse(null);
        equipment.setCategory(category);

        return equipmentMapper.convertToDto(Optional.of(equipmentRepository.save(equipment)));
    }

}
