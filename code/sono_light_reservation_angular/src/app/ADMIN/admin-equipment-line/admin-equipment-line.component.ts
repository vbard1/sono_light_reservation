import { Component, Input } from '@angular/core';
import { Equipment } from 'src/app/MODELS/Equipment';

@Component({
  selector: 'app-admin-equipment-line',
  templateUrl: './admin-equipment-line.component.html',
  styleUrls: ['./admin-equipment-line.component.scss']
})

export class AdminEquipmentLineComponent {
  @Input()
  equipment!: Equipment;

  viewEquipment(equipment:Equipment): any{

  }

  deleteEquipment(equipment:Equipment): any{
    
  }
}
