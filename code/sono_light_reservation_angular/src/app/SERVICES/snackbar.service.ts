import { Injectable } from "@angular/core"
import { MatSnackBar } from "@angular/material/snack-bar"

@Injectable({
    providedIn: 'root'
  })
  export class snackBarService {
    constructor(
        public snackBar: MatSnackBar) {}
//TODO Extract snackbar from client
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
}