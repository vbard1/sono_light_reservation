package sono_light_reservation.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import sono_light_reservation.api.dto.CategoryDto;
import sono_light_reservation.api.dto.EquipementDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Equipement;
import sono_light_reservation.api.entity.Section;
import sono_light_reservation.api.repository.CategoryRepository;
import sono_light_reservation.api.repository.EquipementRepository;
import sono_light_reservation.api.service.mapper.EquipementMapper;

@Data
@Service
public class EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;
    @Autowired
    private EquipementMapper equipementMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Read the details of the equipement get by id
     *
     * @param id
     * @return equipement
     */
    public Optional<EquipementDto> getEquipement(final int id) {
        Optional<Equipement> equipement = equipementRepository.findById(id);
        EquipementDto equipementDto = equipementMapper.convertToDto(equipement);
        return Optional.ofNullable(equipementDto);
    }

    /**
     * List of all the equipements
     *
     * @return the list of the equipements
     */
    public List<EquipementDto> getEquipements() {
        return ((List<Equipement>) equipementRepository.findAll()).stream()
                .map(equipement -> equipementMapper.convertToDto(Optional.ofNullable(equipement)))
                .collect(Collectors.toList());
    }

    /**
     * Save equipement
     *
     * @param equipementDto: Save
     */
    public EquipementDto saveEquipement(EquipementDto equipementDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(equipementDto.getCategory());
        Category category = categoryOptional.orElse(null);

        Equipement equipement = equipementMapper.convertToEntity(equipementDto, category);
        equipementRepository.save(equipement);
        return equipementMapper.convertToDto(Optional.of(equipement));
    }

    /**
     * Delete existant equipement
     *
     * @param id
     * @return String: confirm of the suppression
     */
    public String deleteEquipement(final int id) {
        equipementRepository.deleteById(id);
        if (equipementRepository.findById(id).isEmpty()) {
            return "equipement deleted";
        } else {
            return "Error in the deletion";
        }
    }

    /**
     * Update the details of the equipement get by id
     *
     * @param id
     * @param updatedEquipement
     * @return equipement with modifications
     */
    public EquipementDto updateEquipement(int id, EquipementDto updatedEquipement) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id equipement invalide:" + id));
        if (updatedEquipement.getLabel() != null) {
            equipement.setLabel(updatedEquipement.getLabel());
        }
        if (updatedEquipement.getModel() != null) {
            equipement.setModel(updatedEquipement.getModel());
        }
        if (updatedEquipement.getReference() != null) {
            equipement.setReference(updatedEquipement.getReference());
        }
        if (updatedEquipement.getOwner() != null) {
            equipement.setOwner(updatedEquipement.getOwner());
        }
        if (updatedEquipement.getCableSize() != null) {
            equipement.setCableSize(updatedEquipement.getCable_size());
        }
        if (updatedEquipement.getComment() != null) {
            equipement.setComment(updatedEquipement.getComment());
        }
        if (updatedEquipement.getWearRateReturn() != null) {
            equipement.setWearRateReturn(updatedEquipement.getWearRateReturn());
        }
        if (updatedEquipement.getDate_buy() != null) {
            equipement.setDateBuy(updatedEquipement.getDate_buy());
        }
        if (updatedEquipement.getDaylyPrice() != null) {
            equipement.setDaylyPrice(updatedEquipement.getDayly_price());
        }
        if (updatedEquipement.getReplacementPrice() != null) {
            equipement.setReplacementPrice(updatedEquipement.getReplacement_price());
        }

        Optional<Category> categoryOptional = categoryRepository.findById(updatedEquipement.getCategory());
        Category category = categoryOptional.orElse(null);
        equipement.setCategory(category);

        return equipementMapper.convertToDto(Optional.of(equipementRepository.save(equipement)));
    }

}