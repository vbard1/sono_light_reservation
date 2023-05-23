package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name= "event")
@Getter
@Setter
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    //1=Assos INSA, 2=interne KLS, 3=autre-particulier
//    @Column(name = "type", nullable=false)
    @Column(name = "type")
    private Integer type;

    @Column(name = "user_comment")
    private String user_comment;

    @Column(name = "admin_comment")
    private String admin_comment;

    @Column(name = "date_start")
    private Date date_start;

    @Column(name = "date_end")
    private Date date_end;

    @Column(name = "technician_asked")
    private Boolean technician_asked;

    @ManyToOne(optional = true)
//    @JoinColumn(name = "fk_id_user", nullable = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Event(int event_id, String title, String description, String location, Integer type, String user_comment, String admin_comment, Date date_start, Date date_end, Boolean technician_asked, User user) {
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

    public Event() {

    }

    public void setUser(User user) {
        this.user = user;
    }
}
