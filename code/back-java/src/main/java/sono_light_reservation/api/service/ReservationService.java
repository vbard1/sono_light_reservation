package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.entity.Event;
import sono_light_reservation.api.entity.Reservation;
import sono_light_reservation.api.entity.User;
import sono_light_reservation.api.repository.EventRepository;
import sono_light_reservation.api.repository.ReservationRepository;
import sono_light_reservation.api.repository.UserRepository;
import sono_light_reservation.api.service.mapper.ReservationMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDto> getReservations() {
        return ((List<Reservation>) reservationRepository.findAll()).stream()
                .map(reservation -> reservationMapper.convertToDto(Optional.ofNullable(reservation))).collect(Collectors.toList());
    }

    public ReservationDto saveReservation(ReservationDto reservationDto) {
        if (reservationDto.getReservation_state() == null) {
            reservationDto.setReservation_state(1); // 1=enAttente, 2=validée, 3=enCours, 4=terminée
        }
        Optional<Event> eventOptional = eventRepository.findById(reservationDto.getEvent_id());
        Event event = eventOptional.orElse(null);

        //TODO: waiting Equipement and category class creation

        Reservation reservation = reservationMapper.convertToEntity(reservationDto, event);
        reservationRepository.save(reservation);
        return reservationMapper.convertToDto(Optional.of(reservation));
    }
}
