package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EventDto;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.Event;
import sono_light_reservation.api.entity.User;
import sono_light_reservation.api.repository.EventRepository;
import sono_light_reservation.api.repository.UserRepository;
import sono_light_reservation.api.service.ReservationService;
import sono_light_reservation.api.service.UserService;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class EventMapper {

    @Autowired
    private final EventRepository eventRepository;

    public EventMapper(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Convert event information to DTO , for  eventController
     * @param event
     * @return eventDto
     */
    public EventDto convertToDto(Optional<Event> event) {
        int event_user_id = -1;
        if (event.get().getUser() != null) {
            event_user_id = event.get().getUser().getUser_id();
        }

        return new EventDto(event.get().getEvent_id(), event.get().getTitle(), event.get().getDescription(), event.get().getLocation(),
                event.get().getType(), event.get().getUser_comment(), event.get().getAdmin_comment(), event.get().getDate_start(),
                event.get().getDate_end(), event.get().getTechnician_asked(), event_user_id);
    }

    /**
     * Convert event information to entity , for eventRepository
     * @param eventDto
     * @return event
     */
    public Event convertToEntity(EventDto eventDto, User user) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setLocation(eventDto.getLocation());
        event.setType(eventDto.getType());
        event.setUser_comment(eventDto.getUser_comment());
        event.setAdmin_comment(eventDto.getAdmin_comment());
        event.setDate_start(eventDto.getDate_start());
        event.setDate_end(eventDto.getDate_end());
        event.setTechnician_asked(eventDto.getTechnician_asked());
        event.setUser(user);
        return event;
    }
}
