import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceClientComponent } from './insurance-client.component';

describe('InsuranceClientComponent', () => {
  let component: InsuranceClientComponent;
  let fixture: ComponentFixture<InsuranceClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsuranceClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsuranceClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
