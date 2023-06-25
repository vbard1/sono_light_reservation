import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEquipmentDetailsComponent } from './admin-equipment-details.component';

describe('AdminEquipmentDetailsComponent', () => {
  let component: AdminEquipmentDetailsComponent;
  let fixture: ComponentFixture<AdminEquipmentDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEquipmentDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEquipmentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
