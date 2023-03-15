import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderBisComponent } from './header-bis.component';

describe('HeaderBisComponent', () => {
  let component: HeaderBisComponent;
  let fixture: ComponentFixture<HeaderBisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderBisComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderBisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
