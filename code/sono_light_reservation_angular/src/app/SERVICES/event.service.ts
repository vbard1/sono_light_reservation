import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { EventDetails } from "../MODELS/event.model";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class EventService {
    baseUrl = environment.api_url;

    constructor(private http: HttpClient) { }

    getOneEvent(id: number): Observable<EventDetails> {
        return this.http.get<EventDetails>(`${this.baseUrl}event/${id}`);
    }
    
    getEvents(): Observable<EventDetails[]> {
        return this.http.get<EventDetails[]>(`${this.baseUrl}event`);
    }
    
    createEvent(event: EventDetails): Observable<EventDetails> {
        return this.http.post<EventDetails>(`${this.baseUrl}event`, event);
    }
    
    updateEvent(id: number, event: EventDetails): Observable<EventDetails> {
        return this.http.put<EventDetails>(`${this.baseUrl}event/${id}`, event);
    }
    
    deleteEvent(id: number): Observable<string> {
        return this.http.delete<string>(`${this.baseUrl}event/${id}`);
    }
  }