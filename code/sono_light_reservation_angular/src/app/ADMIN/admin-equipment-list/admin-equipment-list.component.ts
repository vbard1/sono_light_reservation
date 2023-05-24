import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/UTILS/Category';
import { Section } from 'src/app/UTILS/Section';

@Component({
  selector: 'app-admin-equipment-list',
  templateUrl: './admin-equipment-list.component.html',
  styleUrls: ['./admin-equipment-list.component.scss']
})
export class AdminEquipmentListComponent implements OnInit {
  /** sections list, to sort equipments */
  sections: Section[] = [];
  /** categories list, to sort equipments */
  categories: Category[] = [];
  activeSection: Section | null = null;
  
  ngOnInit(): void {
    this.sections.push({ sectionId: "sono", label: "Sono", isCollapsed: true}, {sectionId: "light", label: "Light",isCollapsed: true},{ sectionId: "autres", label: "Autres",isCollapsed: true});
  }

  toggleSection(section: Section) {
    section.isCollapsed = !section.isCollapsed;
  }
  
  isSectionCollapsed(section: Section): boolean {
    return section.isCollapsed;
  }
}
