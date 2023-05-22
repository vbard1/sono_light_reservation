package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sono_light_reservation.api.dto.EventDto;
import sono_light_reservation.api.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    @Autowired
    private EventService eventService;

    /**
     * Read the details of the user get by id
     * @param id
     * @return eventDto
     */
    @GetMapping("/event/{id}")
    public Optional<EventDto> getOneEvent(@PathVariable Long id) {
        return Optional.ofNullable(eventService.getEvent(id));
    }

    /**
     * List of all the events
     * @return the list of the eventsDto
     */
    @GetMapping("/event")
    public List<EventDto> getEvents() {
        return eventService.getEvents();
    }

}
