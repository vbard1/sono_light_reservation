package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EquipmentDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Equipment;

import java.util.Optional;

@Data
@Service
public class EquipmentMapper {
    /**
     * Convert section information to DTO , for equipmentController
     *
     * @param equipment
     * @return equipmentDto
     */
    public EquipmentDto convertToDto(Optional<Equipment> equipment) {
        int equipment_category_id = -1;

        if (equipment.get().getCategory() != null) {
            equipment_category_id = equipment.get().getCategory().getCategory_id();

        }
        final var equipmentCategoryId = equipment_category_id;
        return new EquipmentDto(
                equipment.get().getEquipement_id(),
                equipment.get().getLabel(),
                equipment.get().getModel(),
                equipment.get().getReference(),
                equipment.get().getOwner(),
                equipment.get().getCable_size(),
                equipment.get().getComment(),
                equipment.get().getWear_rate_return(),
                equipment.get().getDate_buy(),
                equipment.get().getDayly_price(),
                equipment.get().getReplacement_price(), equipment_category_id);
    }

    /**
     * Convert equipment information to entity , for equipmentRepository
     *
     * @param equipmentDto
     * @return equipment
     */
    public Equipment convertToEntity(EquipmentDto equipmentDto, Category category) {
        Equipment equipment = new Equipment();
        equipment.setLabel(equipmentDto.getLabel());
        equipment.setModel(equipmentDto.getModel());
        equipment.setReference(equipmentDto.getReference());
        equipment.setOwner(equipmentDto.getOwner());
        equipment.setCable_size(equipmentDto.getCable_size());
        equipment.setComment(equipmentDto.getComment());
        equipment.setWear_rate_return(equipmentDto.getWear_rate_return());
        equipment.setDate_buy(equipmentDto.getDate_buy());
        equipment.setDayly_price(equipmentDto.getDayly_price());
        equipment.setReplacement_price(equipmentDto.getReplacement_price());

        equipment.setCategory(category);
        return equipment;
    }
}
