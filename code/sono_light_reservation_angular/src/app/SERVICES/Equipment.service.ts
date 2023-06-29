import { Category } from "../MODELS/Category.model";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Section } from "../MODELS/Section.model";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})

export class EquipmentService {

    constructor(private http: HttpClient) { }

    getSections(): Observable<Section[]> {
        const url = `${environment.api_url}section`;
        return this.http.get<Section[]>(url);
    }

    getCategories(): Observable<Category[]> {
        const url = `${environment.api_url}category`;
        return this.http.get<Category[]>(url);
    }
}