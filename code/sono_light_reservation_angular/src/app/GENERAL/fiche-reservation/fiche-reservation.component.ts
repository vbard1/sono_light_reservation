import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-fiche-reservation',
  templateUrl: './fiche-reservation.component.html',
  styleUrls: ['./fiche-reservation.component.scss']
})
export class FicheReservationComponent {
  range = new FormGroup({
    start: new FormControl<Date | null>(null),
    end: new FormControl<Date | null>(null),
  });
}
