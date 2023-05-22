package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sono_light_reservation.api.entity.User;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
public class EventDto {

    private int event_id;

//    @NotNull
    private String title;

    private String description;

    private String location;

    //1=Assos INSA, 2=interne KLS, 3=autre-particuler
    private Integer type;

    private String user_comment;

    private String admin_comment;

    private Date date_start;

    private Date date_end;

    private Boolean technician_asked;

    private User user;

    public EventDto(int event_id, String title, String description, String location, Integer type, String user_comment, String admin_comment, Date date_start, Date date_end, Boolean technician_asked, User user) {
        this.event_id = event_id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.user_comment = user_comment;
        this.admin_comment = admin_comment;
        this.date_start = date_start;
        this.date_end = date_end;
        this.technician_asked = technician_asked;
        this.user = user;
    }
}
