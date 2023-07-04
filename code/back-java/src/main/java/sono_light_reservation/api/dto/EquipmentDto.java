package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.ToString;
import sono_light_reservation.api.entity.EquipmentOwnerEnum;

import java.time.LocalDate;

@Data
@ToString
public class EquipmentDto {
    private int equipement_id;
    private String label;
    private String model;
    private String reference;
    private EquipmentOwnerEnum owner;
    private Long cable_size;
    private String comment;
    private int wear_rate_return;
    private LocalDate date_buy;
    private Long dayly_price;
    private Long replacement_price;
    private int category_id;

    public EquipmentDto(int equipement_id, String label, String model, String reference, EquipmentOwnerEnum owner, Long cable_size, String comment, int wear_rate_return, LocalDate date_buy, Long dayly_price, Long replacement_price, int category_id) {
        this.equipement_id = equipement_id;
        this.label = label;
        this.model = model;
        this.reference = reference;
        this.owner = owner;
        this.cable_size = cable_size;
        this.comment = comment;
        this.wear_rate_return = wear_rate_return;
        this.date_buy = date_buy;
        this.dayly_price = dayly_price;
        this.replacement_price = replacement_price;
        this.category_id = category_id;
    }

    public int getEquipmentId() {
        return equipement_id;
    }

    public void setEquipementId(int equipementId) {
        this.equipement_id = equipementId;
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

    public int getCategory() {
        return category_id;
    }

    public void setCategory(int category) {
        this.category_id = category;
    }
}
