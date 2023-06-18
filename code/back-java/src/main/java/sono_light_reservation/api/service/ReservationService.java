package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.Event;
import sono_light_reservation.api.entity.Reservation;
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

    /**
     * Read the details of the reservation get by id
     * @param id
     * @return reservationDto
     */
    public Optional<ReservationDto> getReservation(int id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return Optional.of(reservationMapper.convertToDto(reservation));
    }

    public List<ReservationDto> getReservationsByEventId(int event_id) {
        return (reservationRepository.findReservationByEventId(event_id)).stream()
                .map(reservation -> reservationMapper.convertToDto(Optional.ofNullable(reservation))).collect(Collectors.toList());
    }

    /**
     * List of all the reservations
     * @return the list of the reservationsDto
     */
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

    /**
     * Delete existant reservation
     *
     * @param id
     * @return String messsage : confirm of the suppression
     */
    public String deleteReservation(final int id) {
        reservationRepository.deleteById(id);
        if (reservationRepository.findById(id).isEmpty()) {
            return "Reservation supprimée";
        } else {
            return "Erreur dans la suppression";
        }
    }

    /**
     * Update the details of the reservation get by id
     * @param id
     * @param updatedReservationDto
     * @return reservationDto with modifications
     */
    public ReservationDto updateReservation(int id, ReservationDto updatedReservationDto) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id reservation invalide:" + id));

        if (updatedReservationDto.getReservation_label() != null) {
            reservation.setReservation_label(updatedReservationDto.getReservation_label());
        }
        if (updatedReservationDto.getReservation_state() != null) {
            reservation.setReservation_state(updatedReservationDto.getReservation_state());
        }
        //TODO: waiting Equipement class creation
        if (updatedReservationDto.getEquipment_id() != -1) {
            Optional<Event> eventOptional = eventRepository.findById(updatedReservationDto.getEquipment_id());
            Event event = eventOptional.orElse(null);
            reservation.setEquipment(event);
        }
        //can't change category
        //can't change event
        return reservationMapper.convertToDto(Optional.of(reservationRepository.save(reservation)));
    }
}
