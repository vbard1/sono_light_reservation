import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEquipmentLineComponent } from './admin-equipment-line.component';

describe('AdminEquipmentLineComponent', () => {
  let component: AdminEquipmentLineComponent;
  let fixture: ComponentFixture<AdminEquipmentLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEquipmentLineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEquipmentLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
