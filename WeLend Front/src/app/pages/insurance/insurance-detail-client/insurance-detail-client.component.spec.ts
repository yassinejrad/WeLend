import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceDetailClientComponent } from './insurance-detail-client.component';

describe('InsuranceDetailClientComponent', () => {
  let component: InsuranceDetailClientComponent;
  let fixture: ComponentFixture<InsuranceDetailClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsuranceDetailClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsuranceDetailClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
