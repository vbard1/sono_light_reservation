import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';

import { Category } from 'src/app/MODELS/Category.model';
import { Equipment } from 'src/app/MODELS/Equipment.model';
import { EquipmentService } from 'src/app/SERVICES/Equipment.service';
import { Section } from 'src/app/MODELS/Section.model';

@Component({
  selector: 'app-admin-equipment-list',
  templateUrl: './admin-equipment-list.component.html',
  styleUrls: ['./admin-equipment-list.component.scss'],
})
export class AdminEquipmentListComponent implements OnInit {
  viewEquipment(_t57: Equipment) {
    throw new Error('Method not implemented.');
  }
  deleteEquipment(_t57: Equipment) {
    throw new Error('Method not implemented.');
  }
  /** sections list, to sort equipments */
  sections: Section[] = [];
  /** categories list, to sort equipments */
  categories: Category[] = [];
  /** equipment */
  equipments: Equipment[] = [];

  sort = new FormControl('Aucun');
  constructor(private equipmentService: EquipmentService) {}

  ngOnInit(): void {
    this.equipmentService.getSections().subscribe((sections: Section[]) => {
      this.sections = sections;
    });
  
    this.equipmentService.getCategories().subscribe((categories: Category[]) => {
      this.categories = categories;
      this.initializeEquipments(); 
    });
  }
  

  initializeEquipments(): void {
    this.equipments.push(
      {
        equipment_id: 1,
        label: 'Equipement 1',
        model: 'Modèle 1',
        reference: 'Référence 1',
        owner: 'Propriétaire 1',
        cable_size: 'Taille du câble 1',
        comment: 'Commentaire 1',
        wear_rate_return: 0.5,
        date_buy: new Date(),
        daily_price: 10.0,
        replacement_price: 100.0,
        category_id: this.categories[0].categoryId,
      },
      {
        equipment_id: 2,
        label: 'Equipement 2',
        model: 'Modèle 2',
        reference: 'Référence 2',
        owner: 'Propriétaire 2',
        cable_size: 'Taille du câble 2',
        comment: 'Commentaire 2',
        wear_rate_return: 0.8,
        date_buy: new Date(),
        daily_price: 15.0,
        replacement_price: 150.0,
        category_id: this.categories[0].categoryId,
      }
    );
  }

  getEquipmentsBySection(sectionId: number): Equipment[] {
    const categoryIds = this.categories
      .filter((category) => category.section_id == sectionId)
      .map((category) => category.categoryId);
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
