import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from '../models/reservation.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  baseUrl = environment.api_url;

  constructor(private http: HttpClient) { }

  getReservationsByClient(clientId: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.url}/${clientId}`);
  }

  getReservationById(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.url}/${id}`);
  }

  addReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(this.url, reservation);
  }

  updateReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(this.url, reservation);
  }

  deleteReservation(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}