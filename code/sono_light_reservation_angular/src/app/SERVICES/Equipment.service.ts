import { Category } from '../MODELS/Category.model';
import { Equipment } from '../MODELS/Equipment.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Section } from '../MODELS/Section.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EquipmentService {
  updateEquipment(currentEquipmentId: number, formValues: any) {
    const url = `${environment.api_url}equipment/${currentEquipmentId}`;
    var equipment!: Equipment;
    equipment = {
      equipmentId: currentEquipmentId,
      label: formValues.label,
      model: formValues.model,
      reference: formValues.reference,
      owner: formValues.owner,
      cable_size: formValues.cable_size,
      comment: formValues.comment,
      wear_rate_return: formValues.wear_rate_return,
      date_buy: formValues.date_buy,
      dayly_price: formValues.dayly_price,
      replacement_price: formValues.replacement_price,
      category_id: formValues.category_id,
    };
    console.log(equipment);
    return this.http.put(url, equipment);
  }
  saveEquipment(formData: any): Observable<any> {
    const url = `${environment.api_url}equipment`;

    var equipment!: Equipment;
    equipment = {
      equipmentId: formData.equipmentId,
      label: formData.label,
      model: formData.model,
      reference: formData.reference,
      owner: formData.owner,
      cable_size: formData.cable_size,
      comment: formData.comment,
      wear_rate_return: formData.wear_rate_return,
      date_buy: formData.date_buy,
      dayly_price: formData.dayly_price,
      replacement_price: formData.replacement_price,
      category_id: formData.category_id,
    };
    console.log('on envoie ' + equipment.equipmentId);
    return this.http.post(url, equipment);
  }

  constructor(private http: HttpClient) {}

  getSections(): Observable<Section[]> {
    const url = `${environment.api_url}section`;
    return this.http.get<Section[]>(url);
  }

  getCategories(): Observable<Category[]> {
    const url = `${environment.api_url}category`;
    return this.http.get<Category[]>(url);
  }

  getEquipments(): Observable<Equipment[]> {
    const url = `${environment.api_url}equipment`;
    return this.http.get<Equipment[]>(url);
  }
  getEquipment(id: number): Observable<Equipment> {
    const url = `${environment.api_url}equipment/${id}`;
    return this.http.get<Equipment>(url);
  }
}
