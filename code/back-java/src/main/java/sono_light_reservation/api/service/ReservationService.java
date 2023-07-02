package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.*;
import sono_light_reservation.api.repository.*;
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
    @Autowired
    private EventService eventService;
    @Autowired
    private final EquipmentRepository equipmentRepository;
    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    public ReservationService(ReservationRepository reservationRepository,
                              EquipmentRepository equipmentRepository,
                              CategoryRepository categoryRepository) {
        this.reservationRepository = reservationRepository;
        this.equipmentRepository = equipmentRepository;
        this.categoryRepository = categoryRepository;
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

    /**
     * List of all the reservations by EVENT id
     * @return the list of the reservationsDto
     */
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
            reservationDto.setReservation_state(ReservationStateEnum.EN_ATTENTE); //reservation_state : 0=enAttente, 1=validée, 2=enCours, 3=terminée
        }

        Reservation reservation = reservationMapper.convertToEntity(reservationDto, eventService.getEntityEvent(reservationDto.getEvent_id()), equipmentService.getEntityEquipment(reservationDto.getEquipment_id()), categoryService.getEntityCategory(reservationDto.getCategory_id()));
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
        reservation.setEquipment(equipmentService.getEntityEquipment(updatedReservationDto.getEquipment_id()));
        reservation.setCategory(categoryService.getEntityCategory(updatedReservationDto.getCategory_id()));
        reservation.setEvent(eventService.getEntityEvent(updatedReservationDto.getEvent_id()));

        return reservationMapper.convertToDto(Optional.of(reservationRepository.save(reservation)));
    }
}
