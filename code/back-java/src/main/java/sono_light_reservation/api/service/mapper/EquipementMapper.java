package sono_light_reservation.api.service.mapper;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import sono_light_reservation.api.dto.EquipementDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Equipement;

@Data
@Service
public class EquipementMapper {

    /**
     * Convert section information to DTO , for equipementController
     *
     * @param equipement
     * @return equipementDto
     */
    public EquipementDto convertToDto(Optional<Equipement> equipement) {
        int equipement_category_id = -1;

        if (equipement.get().getCategory() != null) {
            equipement_category_id = equipement.get().getCategory().getCategory_id();
        }
        return new EquipementDto(
                equipement.get().getEquipement_id(),
                equipement.get().getLabel(),
                equipement.get().getModel(),
                equipement.get().getReference(),
                equipement.get().getOwner(),
                equipement.get().getCableSize(),
                equipement.get().getComment(),
                equipement.get().getWearRateReturn(),
                equipement.get().getDate_buy(),
                equipement.get().getDaylyPrice(),
                equipement.get().getReplacementPrice(),
                equipement_category_id);
    }

    /**
     * Convert equipement information to entity , for equipementRepository
     *
     * @param equipementDto
     * @return equipement
     */
    public Equipement convertToEntity(EquipementDto equipementDto, Category category) {
        Equipement equipement = new Equipement();
        equipement.setLabel(equipementDto.getLabel());
        equipement.setModel(equipementDto.getModel());
        equipement.setReference(equipementDto.getReference());
        equipement.setOwner(equipementDto.getOwner());
        equipement.setCableSize(equipementDto.getCable_size());
        equipement.setComment(equipementDto.getComment());
        equipement.setWearRateReturn(equipementDto.getWearRateReturn());
        equipement.setDateBuy(equipementDto.getDate_buy());
        equipement.setDaylyPrice(equipementDto.getDayly_price());
        equipement.setReplacementPrice(equipementDto.getReplacement_price());

        equipement.setCategory(category);
        return equipement;
    }

}
