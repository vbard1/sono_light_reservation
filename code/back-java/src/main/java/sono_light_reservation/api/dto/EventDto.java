package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sono_light_reservation.api.entity.EventTypeEnum;

import java.util.Date;
import java.util.List;

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

    //0=Assos INSA, 1=interne KLS, 2=autre-particulier
    private EventTypeEnum type;

    private String user_comment;

    private String admin_comment;

    private Date date_start;

    private Date date_end;

    private Boolean technician_asked;

    private int user_id;

    private List<ReservationDto> reservations_list;


    public EventDto(int event_id, String title, String description, String location, EventTypeEnum type, String user_comment, String admin_comment, Date date_start, Date date_end, Boolean technician_asked, int user_id) {
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
        this.user_id = user_id;
        this.reservations_list = reservations_list;
    }
    
}
