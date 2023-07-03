import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UserEventComponent } from './user-event.component';


describe('UserEventComponent', () => {
  let component: UserEventComponent;
  let fixture: ComponentFixture<UserEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserEventComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
