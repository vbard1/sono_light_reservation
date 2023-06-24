import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { Category } from 'src/app/MODELS/Category';
import { Equipment } from 'src/app/MODELS/Equipment';
import { EquipmentService } from 'src/app/SERVICES/Equipment.service';
import { FormControl } from '@angular/forms';
import { Section } from 'src/app/MODELS/Section';

@Component({
  selector: 'app-admin-equipment-list',
  templateUrl: './admin-equipment-list.component.html',
  styleUrls: ['./admin-equipment-list.component.scss']
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
  constructor(private equipmentService: EquipmentService) {
  }
  

  ngOnInit(): void {
    // Récupération des sections à partir de l'URL
    this.equipmentService.getSections()
    .subscribe((sections: Section[]) => {
      this.sections = sections;
      console.log(sections);
      console.log(this.sections);
    });
    this.categories.push(
      { category_id: 1, label: "Enceintes de laurent", description: "musique", picture_link: "link", section_id:13, isCollapsed: false },
      { category_id: 2, label: "Câbles", description: "cables", picture_link: "link", section_id:14, isCollapsed: false },
      { category_id: 3, label: "Lumières", description: "lights", picture_link: "link", section_id:15, isCollapsed: false },
    );
    this.equipments.push({
      equipment_id: 1,
      label: "Equipement 1",
      model: "Modèle 1",
      reference: "Référence 1",
      owner: "Propriétaire 1",
      cable_size: "Taille du câble 1",
      comment: "Commentaire 1",
      wear_rate_return: 0.5,
      date_buy: new Date(),
      daily_price: 10.0,
      replacement_price: 100.0,
      category_id: 1
    }, {
      equipment_id: 2,
      label: "Equipement 2",
      model: "Modèle 2",
      reference: "Référence 2",
      owner: "Propriétaire 2",
      cable_size: "Taille du câble 2",
      comment: "Commentaire 2",
      wear_rate_return: 0.8,
      date_buy: new Date(),
      daily_price: 15.0,
      replacement_price: 150.0,
      category_id: 2
    });

  }
  

  
  //TODO ajouter la logique d'ajout et supression d'équipment,
  // et les vérifications d'engaement en réservation §!§

  getEquipmentsBySection(sectionId: number): Equipment[] {
    const categoryIds = this.categories
      .filter(category => category.section_id === sectionId)
      .map(category => category.category_id);
  
    return this.equipments.filter(equipment => categoryIds.includes(equipment.category_id));
  }
  
  getEquipmentsByCategory(categoryId: number): Equipment[] {
    return this.equipments.filter(equipment => equipment.category_id === categoryId);
  }

  getAllEquipments(): Equipment[]{
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
