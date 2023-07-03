import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { EventDetails } from 'src/app/MODELS/event.model';
import { EventService } from 'src/app/SERVICES/event.service';

@Component({
  selector: 'app-user-event',
  templateUrl: './user-event.component.html',
  styleUrls: ['./user-event.component.scss']
})
export class UserEventComponent implements OnInit {
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
      // update du formulaire
    } else {
        this.eventDetails.reservation_list = [];
    }
  }

  save(){
    console.log('date_start',this.eventDetails.date_start);
    console.log('date_end',this.eventDetails.date_end);

    this.eventDetails.user_id = 1;
    this.eventService.createEvent(this.eventDetails).subscribe(
      (res) => {
        const eventId = res.event_id;
        this.router.navigate(['/CLIENT/reservation-details', eventId]);
      },
      (error) => {
        console.error('Erreur lors de la sauvegarde', error);
      }
    );
  }

  cancel(){
    this.router.navigate(['/CLIENT/client-accueil']);
  }
}
