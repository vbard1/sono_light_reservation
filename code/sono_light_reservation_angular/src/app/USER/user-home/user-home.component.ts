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
  passedEvents: EventDetails[] = [];

  constructor(
    private eventService: EventService,
    public snackBar: MatSnackBar) {}

  ngOnInit(): void {
    this.eventService.getEvents().subscribe(
      res => {
        this.events = res.filter(event => new Date(event.date_end) > new Date());
        this.passedEvents = res.filter(event => new Date(event.date_end) < new Date());
      },
      error => {
        console.error('Erreur lors de la récupération des événements:', error);
      }
    )
  }

  deleteEvent(id:number){
    this.eventService.deleteEvent(id).subscribe()
  }
}

