import {Observer} from './Observer';
import {ConcreteSubject} from './ConcreteSubject';

export class ConcreteObserver implements Observer {
  excess = 0;
  public update(subject: ConcreteSubject): void {
    if (subject.state > 0) {
      console.log('observed excess');
      this.excess = 1;
    }
    else{
      console.log('did not observe excess');
      this.excess = 0;
    }
  }
}
