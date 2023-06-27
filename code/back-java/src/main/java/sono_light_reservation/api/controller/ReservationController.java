package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.dto.UserDto;
import sono_light_reservation.api.service.ReservationService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public List<ReservationDto> getReservations() {
        return reservationService.getReservations();
    }

    /**
     * Create a new reservation
     * @param newReservationDto
     * @return the details of the new reservationDto
     */
    @PostMapping("/reservation")
    public ReservationDto createReservation(@RequestBody ReservationDto newReservationDto) {
        return reservationService.saveReservation(newReservationDto);
    }

}
