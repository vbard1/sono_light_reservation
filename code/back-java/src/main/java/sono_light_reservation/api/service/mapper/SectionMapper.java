package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.SectionDto;
import sono_light_reservation.api.entity.Section;

import java.util.Optional;

@Data
@Service
public class SectionMapper {
    /**
     * Convert section information to DTO , for  sectionController
     * @param section
     * @return sectionDto
     */
    public SectionDto convertToDto(Optional<Section> section) {
        return new SectionDto(section.get().getSection_id(), section.get().getLabel());
    }

    /**
     * Convert section information to entity , for sectionRepository
     * @param sectionDto
     * @return section
     */
    public Section convertToEntity(SectionDto sectionDto) {
        Section section = new Section();
        section.setLabel(sectionDto.getLabel());
        return section;
    }

}
