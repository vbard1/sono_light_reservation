package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "user")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

//    @Column(name = "firstname", nullable=false)
    @Column(name = "firstname")
    private String firstname;

//    @Column(name = "name", nullable=false)
    @Column(name = "name")
    private String name;

//    @Column(name = "email",nullable=false, unique=true)
    @Column(name = "email")
    private String email;

//    @Column(name = "phone", unique=true, nullable=false)
    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email_validation")
    private Boolean email_validation;

    @Column(name = "password")
    private String password;

    //level : 1=superAdmin, 2=admin, 3=user
//    @Column(name = "level", nullable=false)
    @Column(name = "level")
    private Integer level;

    public User(int user_id, String firstname, String name, String email, String phone, String address, Integer niveau) {
    }

    public User() {

    }
}
