import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AdminEquipmentListComponent } from './admin-equipment-list.component';


describe('AdminEquipmentListComponent', () => {
  let component: AdminEquipmentListComponent;
  let fixture: ComponentFixture<AdminEquipmentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEquipmentListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEquipmentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
