package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column(name = "label", nullable = false, unique = true)
    private String label;

    @Column(name = "description", unique = true)
    private String desciption;

    @Column(name = "picture_link", unique = true)
    private String picture_link;

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDesciption() {
        return this.desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getPicture_link() {
        return this.picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }
}