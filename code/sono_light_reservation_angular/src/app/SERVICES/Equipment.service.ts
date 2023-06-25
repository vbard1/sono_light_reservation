import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Section } from "../MODELS/Section.model";

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