package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.EventDto;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    @Autowired
    private EventService eventService;

    /**
     * Read the details of the event get by id
     * @param id
     * @return eventDto
     */
    @GetMapping("/event/{id}")
    public Optional<EventDto> getOneEvent(@PathVariable int id) {
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

    /**
     * Create a new event
     * @param newEventDto
     * @return the details of the new userDto
     */
    @PostMapping("/event")
    public EventDto createEvent(@RequestBody EventDto newEventDto) {
        return eventService.saveEvent(newEventDto);
    }

    /**
     * Update the details of the event get by id
     * @param id
     * @param updatedEventDto
     * @return eventDto with modifications
     */
    @PutMapping("/event/{id}")
    public EventDto updateEvent(@PathVariable int id, @RequestBody EventDto updatedEventDto) {
        return eventService.updateEvent(id, updatedEventDto);
    }

    /**
     * Delete existant event
     * @param id
     * @return String messsage : confirm of the suppression
     */
    @DeleteMapping("/event/{id}")
    public String deleteEvent(@PathVariable int id) {
        return eventService.deleteEvent(id);
    }
}

