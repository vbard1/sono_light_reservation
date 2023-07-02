import { ActivatedRoute, Router } from '@angular/router';
import { Component, NgModule, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { CommonModule } from '@angular/common';
import { Equipment } from 'src/app/MODELS/Equipment.model';
import { EquipmentService } from 'src/app/SERVICES/Equipment.service';

@Component({
  selector: 'admin-equipment-details',
  templateUrl: './admin-equipment-details.component.html',
  styleUrls: ['./admin-equipment-details.component.scss'],
})
export class AdminEquipmentDetailsComponent implements OnInit {
  /**html related attributes (styling classes, enum) */
  saveButtonColor: string = 'btn-save';
  cancelButtonColor: string = 'btn-cancel';
  currentEquipmentId?: number; 
  equipmentForm!: FormGroup;
  
  constructor(
    private formBuilder: FormBuilder,
    private equipmentService: EquipmentService,
    private route: ActivatedRoute,
    private router : Router
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const equipmentId = params.get('equipmentId');
      this.equipmentForm = this.formBuilder.group({
        equipement_id: [''],
        label: [''],
        model: [''],
        reference: [''],
        owner: [''],
        cable_size: [''],
        comment: [''],
        wear_rate_return: [''],
        date_buy: [''],
        dayly_price: [''],
        replacement_price: [''],
        category_id: [''],
      });
      if (equipmentId) {
        this.currentEquipmentId = parseInt(equipmentId);  
        this.editEquipment(this.currentEquipmentId);
      }
    });
  }
  // Modifier un équipement existant
  editEquipment(id: number) {
    this.equipmentService.getEquipment(id).subscribe((equipment: Equipment) => {
      this.equipmentForm.patchValue({
        equipmentId: equipment.equipmentId,
        label: equipment.label,
        model: equipment.model,
        reference: equipment.reference,
        owner: equipment.owner,
        cable_size: equipment.cable_size,
        comment: equipment.comment,
        wear_rate_return: equipment.wear_rate_return,
        date_buy: equipment.date_buy,
        dayly_price: equipment.dayly_price,
        replacement_price: equipment.replacement_price,
        category_id: equipment.category_id,
      });
    });
  }
  


  onSubmitForm() {
    const formValues = this.equipmentForm.value;
    if(this.currentEquipmentId) {
      console.log("update");
      this.equipmentService.updateEquipment(this.currentEquipmentId, formValues);  // <-- Update existing equipment
    } else {
      console.log("sauvegarde");
      this.equipmentService.saveEquipment(formValues).subscribe();  // <-- Add new equipment
    }
  }

  doNothing() {
    this.router.navigate(['/ADMIN/admin-accueil']);
  }
}

@NgModule({
  imports: [CommonModule, ReactiveFormsModule],
  declarations: [AdminEquipmentDetailsComponent],
})
export class AdminEquipmentDetailsModule {}
