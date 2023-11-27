import { City } from "./city";

export class Concessionaire {
    
    id: number;
    concessionaireName: string;
    city: City;

    constructor(id: number, concessionaireName: string, city: City) {
        this.id = id;
        this.concessionaireName = concessionaireName;
        this.city = city;
    }
}