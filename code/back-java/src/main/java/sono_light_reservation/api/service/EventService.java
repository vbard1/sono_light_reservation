package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EventDto;
import sono_light_reservation.api.entity.Event;
import sono_light_reservation.api.repository.EventRepository;
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
    private EventMapper eventMapper;

    /**
     * Read the details of the event get by id
     * @param id
     * @return eventDto
     */
    public EventDto getEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        EventDto eventDto = eventMapper.convertToDto(event);
        return eventDto;
    }

    /**
     * List of all the events
     *
     * @return the list of the eventsDto
     */
    public List<EventDto> getEvents() {
        return ((List<Event>) eventRepository.findAll()).stream().map(event -> eventMapper.convertToDto(Optional.ofNullable(event))).collect(Collectors.toList());
    }
}
