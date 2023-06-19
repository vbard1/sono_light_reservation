import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Reservation } from 'src/app/MODELS/reservation.model';


export enum State {
  DENIED = 'Refusée',
  VALIDATED = 'Validée',
  PENDING = 'En attente',
  FINISHED = 'Terminée'
}
@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.scss'],

})
export class UserHomeComponent implements OnInit {
  reservations: Reservation[] = [
    {
      reservationId: 1,
      reservationLabel: 'Reservation 1',
      reservationState: State.DENIED,
      eventDetails: {
        eventId: 1,
        title: 'Event 1',
        description: 'Description of Event 1',
        location: 'Location 1',
        type: 1,
        userComment: 'User Comment 1',
        adminComment: 'Admin Comment 1',
        dateStart: new Date('2023-05-11T10:30:00Z'),
        dateEnd: new Date('2023-05-11T12:30:00Z'),
        wearRateReturn: 'Wear Rate Return 1',
        technicianAsked: true
      }
    },
    {
      reservationId: 2,
      reservationLabel: 'Reservation 2',
      reservationState: State.PENDING,
      eventDetails: {
        eventId: 2,
        title: 'Event 2',
        description: 'Description of Event 2',
        location: 'Location 2',
        type: 2,
        userComment: 'User Comment 2',
        adminComment: 'Admin Comment 2',
        dateStart: new Date('2023-05-12T14:30:00Z'),
        dateEnd: new Date('2023-05-12T16:30:00Z'),
        wearRateReturn: 'Wear Rate Return 2',
        technicianAsked: false
      }
    },
    {
      reservationId: 3,
      reservationLabel: 'Reservation 3',
      reservationState: State.VALIDATED,
      eventDetails: {
        eventId: 3,
        title: 'Event 3',
        description: 'Description of Event 3',
        location: 'Location 3',
        type: 3,
        userComment: 'User Comment 3',
        adminComment: 'Admin Comment 3',
        dateStart: new Date('2023-05-13T18:30:00Z'),
        dateEnd: new Date('2023-05-13T20:30:00Z'),
        wearRateReturn: 'Wear Rate Return 3',
        technicianAsked: true
      }
    }
  ];

  test = 'validé'
  public stateEnum = State;

  constructor(public snackBar: MatSnackBar) {}

  ngOnInit(): void {

  }

  testSuccessSnack() {
    this.openSnackBar("La réservation a bien été enregistrée", 'success-snackbar')
  }

  testFailSnack() {
    this.openSnackBar("Un problème est servenu", 'fail-snackbar')
  }
  // Fonction à utiliser après save, onsuccess/onerror
  openSnackBar(message: string, type?: string) {
    this.snackBar.open(message, "X", {
      verticalPosition: 'top',
      panelClass: type //type = nom de classe css
    })
  }

  public getColor(etat: string): any {
    let styles = [{ etat: this.stateEnum.DENIED, style: "red" }, { etat: this.stateEnum.PENDING, style: "orange" }, 
                { etat: this.stateEnum.VALIDATED, style: "green" }]
                return styles.filter(s => s.etat === etat)[0].style 
              }

}
