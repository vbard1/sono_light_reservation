package sono_light_reservation.api.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "equipement")
@ToString
@RequiredArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipement_id;

    @Column(name = "label", nullable = false, unique = true)
    private String label;

    @Column(name = "model")
    private String model;

    @Column(name = "reference")
    private String reference;

    @Column(name = "owner")
    private String owner;

    @Column(name = "cable_size")
    private Long cable_size;

    @Column(name = "comment")
    private String comment;

    @Column(name = "wear_rate_return")
    private Boolean wear_rate_return;

    @Column(name = "date_buy")
    private LocalDate date_buy;

    @Column(name = "dayly_price")
    private Long dayly_price;

    @Column(name = "replacement_price")
    private Long replacement_price;

    @Column(name = "category_id")
    private Category category;

    public int getEquipementId() {
        return this.equipement_id;
    }

    public void setEquipementId(int equipement_id) {
        this.equipement_id = equipement_id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReference() {
        return this.label;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getCableSize() {
        return this.cable_size;
    }

    public void setCableSize(Long cable_size) {
        this.cable_size = cable_size;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getWearRateReturn() {
        return this.wear_rate_return;
    }

    public void setWearRateReturn(Boolean weare_rate_return) {
        this.wear_rate_return = weare_rate_return;
    }

    public LocalDate getDate_buy() {
        return this.date_buy;
    }

    public void setDateBuy(LocalDate date_buy) {
        this.date_buy = date_buy;
    }

    public Long getDaylyPrice() {
        return this.dayly_price;
    }

    public void setDaylyPrice(Long dayly_price) {
        this.dayly_price = dayly_price;
    }

    public Long getReplacementPrice() {
        return this.replacement_price;
    }

    public void setReplacementPrice(Long replacement_price) {
        this.replacement_price = replacement_price;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
