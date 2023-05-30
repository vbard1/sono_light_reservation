import { HttpClient } from "@angular/common/http";
import { Section } from "../MODELS/Section";
import { Observable } from "rxjs";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})

export class EquipmentService {

    private baseUrl = 'http://localhost:9000';
    constructor(private http: HttpClient) { }

    getSections(): Observable<Section[]> {
        const url = `${this.baseUrl}/section`;
        return this.http.get<Section[]>(url);
    }
}