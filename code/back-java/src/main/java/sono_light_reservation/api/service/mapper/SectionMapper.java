package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.SectionDto;
import sono_light_reservation.api.entity.Section;

import java.util.Optional;

@Data
@Service
public class SectionMapper {
    public SectionDto convertToDto(Optional<Section> section) {
        return new SectionDto(section.get().getId(), section.get().getLabel());
    }

    public Section convertToEntity(SectionDto sectionDto) {
        Section section = new Section();
        section.setLabel(sectionDto.getLabel());
        return section;
    }

}
