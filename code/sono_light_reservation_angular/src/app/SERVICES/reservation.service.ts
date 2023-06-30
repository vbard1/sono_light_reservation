import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Reservation } from '../MODELS/Reservation.model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  baseUrl = environment.api_url;

  constructor(private http: HttpClient) { }

  getReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.baseUrl}/reservation`);
  }

  getOneReservation(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.baseUrl}/reservation/${id}`);
  }

  updateReservation(id: number, updatedReservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(`${this.baseUrl}/reservation/${id}`, updatedReservation);
  }

  deleteReservation(id: number): Observable<string> {
    return this.http.delete<string>(`${this.baseUrl}/reservation/${id}`);
  }

  createReservation(newReservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.baseUrl}/reservation`, newReservation);
  }
}