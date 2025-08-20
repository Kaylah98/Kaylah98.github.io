import { Owner } from "./Owner";
import { Pet } from "./Pet";

export class Cat extends Pet {
    setId(id: string) {
      this.id = id;
    }
    
    id: string | undefined;
    
    constructor(owner: Owner, firstName: String, breed: String, age: number, isDog: boolean, weight: number, numOfDays: number, isGroomed: boolean){
            super(owner, firstName, breed, age, isDog, weight, numOfDays, isGroomed);
            
    }
    
}