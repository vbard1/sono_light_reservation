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

    /**
     * List of all the reservations
     * @return the list of the reservationsDto
     */
    @GetMapping("/reservation")
    public List<ReservationDto> getReservations() {
        return reservationService.getReservations();
    }

    /**
     * Read the details of the reservation get by id
     * @param id
     * @return reservationDto
     */
    @GetMapping("/reservation/{id}")
    public Optional<ReservationDto> getOneReservation(@PathVariable int id) {
        return reservationService.getReservation(id);
    }

    /**
     * Update the details of the reservation get by id
     * @param id
     * @param updatedReservationDto
     * @return reservationDto with modifications
     */
    @PutMapping("/reservation/{id}")
    public ReservationDto updateReservation(@PathVariable int id, @RequestBody ReservationDto updatedReservationDto) {
        return reservationService.updateReservation(id, updatedReservationDto);
    }

    /**
     * Delete existant reservation
     * @param id
     * @return String messsage : confirm of the suppression
     */
    @DeleteMapping("/reservation/{id}")
    public String deleteReservation(@PathVariable int id) {
        return reservationService.deleteReservation(id);
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
