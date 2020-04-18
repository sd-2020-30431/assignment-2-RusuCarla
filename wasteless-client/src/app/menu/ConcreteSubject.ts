import {Observer} from './Observer';
import {Subject} from './Subject';
import {GroceriesModel} from '../addgroceries/addgroceries.model';
import {LoginModel} from '../login/login.model';

export class ConcreteSubject implements Subject {

  public state: number;

  private observers: Observer[] = [];
  public sum: number;

  public attach(observer: Observer): void {
    const isExist = this.observers.includes(observer);
    if (isExist) {
      return console.log('Subject: Observer has been attached already.');
    }

    console.log('Subject: Attached an observer.');
    this.observers.push(observer);
  }

  public detach(observer: Observer): void {
    const observerIndex = this.observers.indexOf(observer);
    if (observerIndex === -1) {
      return console.log('Subject: Nonexistent observer.');
    }

    this.observers.splice(observerIndex, 1);
    console.log('Subject: Detached an observer.');
  }


  public notify(): void {
    console.log('Subject: Notifying observers...');
    for (const observer of this.observers) {
      observer.update(this);
    }
  }

  public computeSum(groceries: GroceriesModel[], loginModel: LoginModel): void {
    this.sum = 0;
    for (const g of groceries) {
      if (g.consumptionDate === null) {
        this.sum += g.rate;
      }
    }
    if (this.sum > loginModel.goal){
      console.log('EXCESS');
      this.state = 1;
    }else{
      this.state = 0;
    }
    this.notify();
  }
}
