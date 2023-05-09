package sono_light_reservation.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class SectionDto {
    private int id;
    @NotNull
    private String label;

    public SectionDto(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public SectionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
