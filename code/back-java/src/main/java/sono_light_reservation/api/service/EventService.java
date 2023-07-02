package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EventDto;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.entity.Event;
import sono_light_reservation.api.entity.User;
import sono_light_reservation.api.repository.EventRepository;
import sono_light_reservation.api.repository.UserRepository;
import sono_light_reservation.api.service.mapper.EventMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventMapper eventMapper;

    /**
     * Read the details of the event get by id
     * @param id
     * @return eventDto
     */
    public EventDto getEvent(int id) {
        Optional<Event> event = eventRepository.findById(id);
        return eventMapper.convertToDto(event);
    }

    public Event getEntityEvent(int id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        return eventOptional.orElse(null);
    }


    /**
     * List of all the events
     *
     * @return the list of the eventsDto
     */
    public List<EventDto> getEvents() {
        return ((List<Event>) eventRepository.findAll()).stream().map(event -> eventMapper.convertToDto(Optional.ofNullable(event))).collect(Collectors.toList());
    }

    public EventDto saveEvent(EventDto eventDto) {
        Optional<User> userOptional = userRepository.findById(eventDto.getUser_id());
        User user = userOptional.orElse(null);

        Event event = eventMapper.convertToEntity(eventDto, user);
        eventRepository.save(event);

        return eventMapper.convertToDto(Optional.of(event));
    }

    /**
     * Update the details of the event get by id
     * @param id
     * @param updatedEventDto
     * @return eventDto with modifications
     */
    public EventDto updateEvent(int id, EventDto updatedEventDto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id event invalide:" + id));

        if (updatedEventDto.getTitle() != null) {
            event.setTitle(updatedEventDto.getTitle());
        }
        if (updatedEventDto.getDescription() != null) {
            event.setDescription(updatedEventDto.getDescription());
        }
        if (updatedEventDto.getLocation() != null) {
            event.setLocation(updatedEventDto.getLocation());
        }
        if (updatedEventDto.getType() != null) {
            event.setType(updatedEventDto.getType());
        }
        if (updatedEventDto.getUser_comment() != null) {
            event.setUser_comment(updatedEventDto.getUser_comment());
        }
        if (updatedEventDto.getAdmin_comment() != null) {
            event.setAdmin_comment(updatedEventDto.getAdmin_comment());
        }
        if (updatedEventDto.getDate_start() != null) {
            event.setDate_start(updatedEventDto.getDate_start());
        }
        if (updatedEventDto.getDate_end() != null) {
            event.setDate_end(updatedEventDto.getDate_end());
        }
        if (updatedEventDto.getTechnician_asked() != null) {
            event.setTechnician_asked(updatedEventDto.getTechnician_asked());
        }
        //can't change user
        return eventMapper.convertToDto(Optional.of(eventRepository.save(event)));
    }

    /**
     * Delete existant event
     * @param id
     * @return String messsage : confirm of the suppression
     */
    public String deleteEvent(int id) {
        eventRepository.deleteById(id);
        if (eventRepository.findById(id).isEmpty()) {
            return "Evènement supprimé";
        } else {
            return "Erreur dans la suppression";
        }
    }
}
