package sono_light_reservation.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class SectionDto {
    private int section_id;
    @NotNull
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

    public void setSection_id(int sectionid) {
        this.section_id = sectionid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
