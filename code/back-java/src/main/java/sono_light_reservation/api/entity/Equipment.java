package sono_light_reservation.api.entity;

import jakarta.persistence.*;

import java.util.Date;

public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipement_id;

    @Column(name="label")
    private String label;

    @Column(name="model")
    private String model;

    @Column(name="reference")
    private String reference;

    @Column(name="owner")
    private String owner;

    @Column(name="cable_size")
    private String cable_size;

    @Column(name="comment")
    private String comment;

    @Column(name="wear_rate_return")
    private int wear_rate_return;

    @Column(name = "date_buy")
    private Date date_buy;

    @Column(name="daily_price")
    private float daily_price;

    @Column(name="replacement_price")
    private float replacement_price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
