package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class SectionDto {
    private int section_id;
    private String label;

    public SectionDto(int section_id, String label) {
        this.section_id = section_id;
        this.label = label;
    }

    public SectionDto() {
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
