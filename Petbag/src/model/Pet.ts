import { Owner } from "./Owner";

export abstract class Pet {
    
    owner: Owner;
    firstName: String;
    breed: String;
    age: number;
    isDog: boolean;
    weight: number;
    numOfDays: number;
    isGroomed: boolean;

    constructor(owner: Owner, firstName: String, breed: String, age: number, isDog: boolean, weight: number, numOfDays: number, isGroomed: boolean){
        
        this.owner = owner;
        this.firstName = firstName;
        this.breed = breed;
        this.age = age;
        this.isDog = isDog;
        this.weight = weight;
        this.numOfDays = numOfDays;
        this.isGroomed = isGroomed;
    }


    getOwner(): Owner {
        return this.owner;
    }

    setOwner(owner : Owner) {
        this.owner = owner;
    }

    getFirstName(): String {
        return this.firstName;
    }

    setFirstName(firstName: String) {
        this.firstName = firstName;
    }

    getBreed(): String {
        return this.breed;
    }

    setBreed(breed: String){
        this.breed = breed;
    }

    getAge(): number {
        return this.age;
    }

    setAge(age: number){
        this.age = age;
    }

    getNumOfDays(): number {
        return this.numOfDays;
    }

    setNumOfDays(numOfDays: number){
        this.numOfDays = numOfDays;
    }

    getIsDog(): boolean {
        return this.isDog;
    }

    setDog(isDog: boolean){
        this.isDog = isDog;
    }

    getIsGroomed(): boolean {
        return this.isGroomed;
    }

    setGroomed(isGroomed: boolean) {
        this.isGroomed = isGroomed;
    }

}