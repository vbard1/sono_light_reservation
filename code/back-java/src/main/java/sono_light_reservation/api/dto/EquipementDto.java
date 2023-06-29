package sono_light_reservation.api.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EquipementDto {
    private int equipementId;
    private String label;
    private String model;
    private String reference;
    private String owner;
    private Long cable_size;
    private String comment;
    private Boolean wear_rate_return;
    private LocalDate date_buy;
    private Long dayly_price;
    private Long replacement_price;
    private int category;

    public EquipementDto(int equipementId, String label, String model, String reference, String owner,
            Long cable_size, String comment, Boolean wear_rate_return, LocalDate date_buy, Long dayly_price,
            Long replacement_price, int category) {
        this.equipementId = equipementId;
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
        this.category = category;
    }

    public EquipementDto() {
    }

    public int getEquipementId() {
        return this.equipementId;
    }

    public void setEquipementId(int equipementId) {
        this.equipementId = equipementId;
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

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
