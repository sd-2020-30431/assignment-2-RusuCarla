import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddgroceriesComponent } from './addgroceries.component';

describe('AddgroceriesComponent', () => {
  let component: AddgroceriesComponent;
  let fixture: ComponentFixture<AddgroceriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddgroceriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddgroceriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
