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

    @Column(name = "firstname", nullable=false)
    private String firstname;

    @Column(name = "name", nullable=false)
    private String name;

    @Column(name = "email", unique=true, nullable=false)
    private String email;

    @Column(name = "phone", unique=true, nullable=false)
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email_validation")
    private Boolean email_validation;

    @Column(name = "password")
    private String password;

    //level : 0=superAdmin, 1=admin, 2=user
    @Column(name = "level")
    @Enumerated(EnumType.ORDINAL)
    private UserLevelEnum level;

    public User(int user_id, String firstname, String name, String email, String phone, String address, Boolean email_validation, String password, UserLevelEnum level) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.email_validation = email_validation;
        this.password = password;
        this.level = level;
    }

    public User() {

    }
}
