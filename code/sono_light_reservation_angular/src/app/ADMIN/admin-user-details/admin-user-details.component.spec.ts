import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AdminUserDetailsComponent } from './admin-user-details.component';


describe('AdminUserDetailsComponent', () => {
  let component: AdminUserDetailsComponent;
  let fixture: ComponentFixture<AdminUserDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminUserDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
