import { TestBed } from '@angular/core/testing';

import { InsuranceDetailService } from './insurance-detail.service';

describe('InsuranceDetailService', () => {
  let service: InsuranceDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsuranceDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
