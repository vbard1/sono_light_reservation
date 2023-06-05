package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.Reservation;
import sono_light_reservation.api.entity.User;
import sono_light_reservation.api.repository.ReservationRepository;
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

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDto> getReservations() {
        return ((List<Reservation>) reservationRepository.findAll()).stream()
                .map(reservation -> reservationMapper.convertToDto(Optional.ofNullable(reservation))).collect(Collectors.toList());
    }
}
