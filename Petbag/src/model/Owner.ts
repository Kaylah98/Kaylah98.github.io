import { Pet } from "./Pet";

export class Owner{

    id!: string;
    firstName: String;
    lastName: String;
    hasPaid: boolean;
    hasCheckedIn: boolean;
    pets: Pet[];
    

    constructor(firstName: String, lastName: String, hasPaid: boolean, hasCheckedIn: boolean){
        this.pets = [];
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasPaid = hasPaid;
        this.hasCheckedIn = hasCheckedIn;
        
    }

    getId(): string {
        return this.id;
    }

    setId(id: string){
        this.id = id;
    }

    getFirstName(): String {
        return this.firstName;
    }

    setFirstName(firstName: String) {
        this.firstName = firstName;
    }

    getLastName(): String {
        return this.lastName;
    }

    setLastName(lastName: String) {
        this.lastName = lastName;
    }

    getHasPaid(): boolean {
        return this.hasPaid;
    }

    setHasPaid(hasPaid: boolean){
        this.hasPaid = hasPaid;
    }

    getHasCheckedIn(): boolean{
        return this.hasCheckedIn;
    }

    setHasCheckedIn(hasCheckedIn: boolean){
        this.hasCheckedIn = hasCheckedIn;
    }

    getPets(): Pet[]{
        return this.pets;
    }

    setPets(pets: Pet[]){
        this.pets = pets;
    }
}