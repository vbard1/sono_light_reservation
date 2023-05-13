package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class UserDto {
    private Long user_id;
    private String firstname;
    private String name;
    private String email;

    private String phone;

    private String address;

    private Integer level;

    // TODO : liste des reservations a intégrer quand class créées

    public UserDto(Long user_id, String firstname, String name, String email, String phone, String address, Integer level) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.level = level;
    }

    public UserDto() {
    }
}
