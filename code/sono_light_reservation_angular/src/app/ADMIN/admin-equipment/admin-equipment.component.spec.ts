import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AdminEquipmentComponent } from './admin-equipment.component';


describe('AdminEquipmentComponent', () => {
  let component: AdminEquipmentComponent;
  let fixture: ComponentFixture<AdminEquipmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEquipmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEquipmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
