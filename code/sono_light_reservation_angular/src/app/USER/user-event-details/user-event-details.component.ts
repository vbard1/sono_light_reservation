import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from 'src/app/MODELS/Reservation.model';
import { EventDetails } from 'src/app/MODELS/event.model';
import { EventService } from 'src/app/SERVICES/event.service';
import { ReservationService } from 'src/app/SERVICES/reservation.service';

@Component({
  selector: 'app-user-event-details',
  templateUrl: './user-event-details.component.html',
  styleUrls: ['./user-event-details.component.scss']
})
export class UserEventDetailsComponent implements OnInit {

  eventId!: number;
  eventDetails: EventDetails = new EventDetails();
  reservation: Reservation = new Reservation();
  range = new FormGroup({
    date_start: new FormControl<Date | null>(null),
    date_end: new FormControl<Date | null>(null),
  });

  constructor(
    private eventService: EventService,
    private reservationService: ReservationService,
    private route: ActivatedRoute,
  ){
  }

  ngOnInit(): void {
this.route.params.subscribe(params => {
      this.eventId = +params['event_id'];
      this.eventService.getOneEvent(this.eventId).subscribe(
        event => {
          this.eventDetails = event;
        },
        (error) => {
          console.error('Erreur lors de la récupération des détails de l\'événement', error);
        }
      );
    });
    }

}
