import { Component, OnInit } from '@angular/core';

import { Category } from 'src/app/MODELS/Category.model';
import { Equipment } from 'src/app/MODELS/Equipment.model';
import { EquipmentService } from 'src/app/SERVICES/Equipment.service';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Section } from 'src/app/MODELS/Section.model';

@Component({
  selector: 'app-admin-equipment-list',
  templateUrl: './admin-equipment-list.component.html',
  styleUrls: ['./admin-equipment-list.component.scss'],
})

export class AdminEquipmentListComponent implements OnInit {

  /** sections list, to sort equipments */
  sections: Section[] = [];
  /** categories list, to sort equipments */
  categories: Category[] = [];
  /** equipment */
  equipments: Equipment[] = [];

  sort = new FormControl('Aucun');
  constructor(private equipmentService: EquipmentService,private router: Router) {}

  ngOnInit(): void {
    this.equipmentService.getSections().subscribe((sect: Section[]) => {
      this.sections = sect;
      console.log(this.sections);
    });
  
    this.equipmentService.getCategories().subscribe((categories: Category[]) => {
      this.categories = categories;
      console.log(this.categories);

    });
    
    this.equipmentService.getEquipments().subscribe((equipments: Equipment[]) => {
      this.equipments = equipments;
      console.log(this.equipments);
    });

    
  }

  viewEquipment(equipmentId: number) {
    this.router.navigate(['/equipment', equipmentId]);
  }
  deleteEquipment(equipment: Equipment) {
    this.equipmentService.deleteEquipment(equipment).subscribe();
  }
  
  getEquipmentsBySection(sectionId: number): Equipment[] {
    const categoryIds = this.categories
      .filter((category) => category.sectionId == sectionId)
      .map((category) => category.category_id);
    return this.equipments.filter((equipment) =>
      categoryIds.includes(equipment.category_id)
    );
  }
  
  
  

  getEquipmentsByCategory(categoryId: number): Equipment[] {
    return this.equipments.filter(
      (equipment) => equipment.category_id == categoryId
    );
  }

  getAllEquipments(): Equipment[] {
    return this.equipments;
  }

  toggleSection(section: Section) {
    section.isCollapsed = !section.isCollapsed;
  }

  isSectionCollapsed(section: Section): boolean {
    return section.isCollapsed;
  }

  toggleCategory(category: Category) {
    category.isCollapsed = !category.isCollapsed;
  }

  isCategoryCollapsed(category: Category): boolean {
    return category.isCollapsed;
  }
}
