import { TestBed } from '@angular/core/testing';

import { InsuranceTransactionService } from './insurance-transaction.service';

describe('InsuranceTransactionService', () => {
  let service: InsuranceTransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsuranceTransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
