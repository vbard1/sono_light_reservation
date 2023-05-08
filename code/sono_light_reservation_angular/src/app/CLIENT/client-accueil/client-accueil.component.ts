import { Component } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Reservation } from 'src/app/models/reservation.model';


export enum State {
  REFUS = 'Refusée',
  VALIDE = 'Validée',
  EN_ATTENTE = 'En attente',
  TERMINE = 'Terminée'
}
@Component({
  selector: 'app-client-accueil',
  templateUrl: './client-accueil.component.html',
  styleUrls: ['./client-accueil.component.scss'],

})
export class CLIENTAccueilComponent {
  reservations: Reservation[] = [
    { id: 1, dateReservation: '2023-01-01', montant: 100.05, etat: State.EN_ATTENTE },
    { id: 2, dateReservation: '2022-05-11', montant: 325.00, etat: State.VALIDE },
    { id: 3, dateReservation: '2022-12-12', montant: 208.55, etat: State.REFUS },
  ];
  test = 'validé'
  public stateEnum = State;

  constructor(public snackBar: MatSnackBar) {
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
    let styles = [{ etat: this.stateEnum.REFUS, style: "red" }, { etat: this.stateEnum.EN_ATTENTE, style: "orange" }, 
                { etat: this.stateEnum.VALIDE, style: "green" }]
                return styles.filter(s => s.etat === etat)[0].style 
              }

}
