import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindProductsComponent } from './find-products.component';

describe('FindProductsComponent', () => {
  let component: FindProductsComponent;
  let fixture: ComponentFixture<FindProductsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindProductsComponent]
    });
    fixture = TestBed.createComponent(FindProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
