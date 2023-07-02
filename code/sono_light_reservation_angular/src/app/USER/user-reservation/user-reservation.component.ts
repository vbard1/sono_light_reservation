import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Reservation } from 'src/app/MODELS/Reservation.model';
import { EventDetails } from 'src/app/MODELS/event.model';
import { EventService } from 'src/app/SERVICES/event.service';

@Component({
  selector: 'app-user-reservation',
  templateUrl: './user-reservation.component.html',
  styleUrls: ['./user-reservation.component.scss']
})
export class UserReservationComponent implements OnInit {
   eventDetails: EventDetails = new EventDetails();

  range = new FormGroup({
    date_start: new FormControl<Date | null>(null),
    date_end: new FormControl<Date | null>(null),
  });

  constructor(
    private eventService: EventService,
    private router: Router,
) {
  }

   ngOnInit(): void {
    if (this.eventDetails.event_id) {
      console.log("On récupère le form");
    } else {
      console.log("nouveau form");
        this.eventDetails.reservation_list = [];
    }
  }

  save(){
    this.eventDetails.user_id = 1;
    this.eventService.createEvent(this.eventDetails).subscribe(
      (res) => {
        const eventId = res.event_id;
        console.log(eventId);
        this.router.navigate(['/CLIENT/reservation-details', eventId]);
      },
      (error) => {
        console.error('Erreur lors de la sauvegarde', error);
      }
    );
  }

  cancel(){

  }
}
