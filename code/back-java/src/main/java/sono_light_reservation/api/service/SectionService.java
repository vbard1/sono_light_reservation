package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.SectionDto;
import sono_light_reservation.api.entity.Section;
import sono_light_reservation.api.repository.SectionRepository;
import sono_light_reservation.api.service.mapper.SectionMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public
class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionMapper sectionMapper;

    /**
     * Read the details of the section get by id
     * @param id
     * @return section
     */
    public Optional<SectionDto> getSection(final int id) {
        Optional<Section> section = sectionRepository.findById(id);
        SectionDto sectionDto = sectionMapper.convertToDto(section);
        return Optional.ofNullable(sectionDto);
    }

    /**
     * List of all the sections
     * @return the list of the sections
     */
    public List<SectionDto> getSections() {
        return ((List<Section>) sectionRepository.findAll()).stream().map(section -> sectionMapper.convertToDto(Optional.ofNullable(section))).collect(Collectors.toList());
    }

    public SectionDto saveSection(SectionDto sectionDto) {
        Section section = sectionMapper.convertToEntity(sectionDto);
        sectionRepository.save(section);
        return sectionMapper.convertToDto(Optional.of(section));
    }

    /**
     * Delete existant section
     * @param id
     * @return String: confirm of the suppression
     */
    public String deleteSection(final int id) {
        sectionRepository.deleteById(id);
        if (sectionRepository.findById(id).isEmpty()) {
            return "section deleted";
        } else {
            return "Error in the deletion";
        }
    }

    /**
     * Update the details of the section get by id
     * @param id
     * @param updatedSection
     * @return section with modifications
     */
    public SectionDto updateSection(int id, SectionDto updatedSection) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id section invalide:" + id));
        if (updatedSection.getLabel() != null) {
            section.setLabel(updatedSection.getLabel());
        }
        return sectionMapper.convertToDto(Optional.of(sectionRepository.save(section)));
    }
}