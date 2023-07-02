import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EventDetails } from 'src/app/MODELS/event.model';
import { EventService } from 'src/app/SERVICES/event.service';

 @Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.scss']
})
export class UserHomeComponent implements OnInit {
  events: EventDetails[] = [];

  constructor(
    private eventService: EventService,
    public snackBar: MatSnackBar) {}

  ngOnInit(): void {
    this.eventService.getEvents().subscribe(
      events => {
        console.log("events", events)
        this.events = events;
      },
      error => {
        console.error('Erreur lors de la récupération des événements:', error);
      }
    )
  }



  // public getColor(etat: string): any {
  //   let styles = [{ etat: this.stateEnum.DENIED, style: "red" }, { etat: this.stateEnum.PENDING, style: "orange" }, 
  //               { etat: this.stateEnum.VALIDATED, style: "green" }]
  //               return styles.filter(s => s.etat === etat)[0].style 
  //             }

}

