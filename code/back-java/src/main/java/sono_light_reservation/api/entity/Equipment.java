package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "equipment")
@ToString
@RequiredArgsConstructor
public class Equipment {
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
    private EquipmentOwnerEnum owner;

    @Column(name = "cable_size")
    private Long cable_size;

    @Column(name = "comment")
    private String comment;

    @Column(name = "wear_rate_return")
    private int wear_rate_return;

    @Column(name = "date_buy")
    private LocalDate date_buy;

    @Column(name = "dayly_price")
    private Long dayly_price;

    @Column(name = "replacement_price")
    private Long replacement_price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public int getEquipment_id() {
        return equipement_id;
    }

    public void setEquipment_id(int equipement_id) {
        this.equipement_id = equipement_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public EquipmentOwnerEnum getOwner() {
        return owner;
    }

    public void setOwner(EquipmentOwnerEnum owner) {
        this.owner = owner;
    }

    public Long getCable_size() {
        return cable_size;
    }

    public void setCable_size(Long cable_size) {
        this.cable_size = cable_size;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getWear_rate_return() {
        return wear_rate_return;
    }

    public void setWear_rate_return(int wear_rate_return) {
        this.wear_rate_return = wear_rate_return;
    }

    public LocalDate getDate_buy() {
        return date_buy;
    }

    public void setDate_buy(LocalDate date_buy) {
        this.date_buy = date_buy;
    }

    public Long getDayly_price() {
        return dayly_price;
    }

    public void setDayly_price(Long dayly_price) {
        this.dayly_price = dayly_price;
    }

    public Long getReplacement_price() {
        return replacement_price;
    }

    public void setReplacement_price(Long replacement_price) {
        this.replacement_price = replacement_price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
