import { LoginInfo } from "./LoginInfo";

export class User {

    id: number;
    firstName: String;
    lastName: String;
    loginInfo: LoginInfo;


    constructor(id: number, firstName: String, lastName: String, loginInfo: LoginInfo){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginInfo = loginInfo;
    }

    getId(): number {
        return this.id;
    }

    setId(id: number){
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

    getLoginInfo(): LoginInfo {
        return this.loginInfo;
    }

    setLoginInfo(loginInfo: LoginInfo){
        this.loginInfo = loginInfo;
    }
}