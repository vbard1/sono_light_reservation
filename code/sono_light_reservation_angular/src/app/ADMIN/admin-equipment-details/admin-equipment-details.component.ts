import { Component, NgModule, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

import { CommonModule } from '@angular/common';

@Component({
  selector: 'admin-equipment-details',
  templateUrl: './admin-equipment-details.component.html',
  styleUrls: ['./admin-equipment-details.component.scss'],
})
export class AdminEquipmentDetailsComponent implements OnInit {
  /**html related attributes (styling classes, enum) */
  saveButtonColor: string = 'btn-save';
  cancelButtonColor: string = 'btn-cancel';
  equipmentForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.equipmentForm = this.formBuilder.group({
      equipement_id: ['', Validators.required],
      label: ['', Validators.required],
      model: ['', Validators.required],
      reference: ['', Validators.required],
      owner: ['', Validators.required],
      cable_size: ['', Validators.required],
      comment: ['', Validators.required],
      wear_rate_return: ['', Validators.required],
      date_buy: ['', Validators.required],
      dayly_price: ['', Validators.required],
      replacement_price: ['', Validators.required],
      category_id: ['', Validators.required],
    });
  }

  onSubmitForm() {
    // Traitement du formulaire lorsqu'il est soumis
  }

  doNothing() {
    // Fonction vide pour le bouton d'annulation
  }
}


@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  declarations: [
    AdminEquipmentDetailsComponent,
  ],
})
export class AdminEquipmentDetailsModule { }