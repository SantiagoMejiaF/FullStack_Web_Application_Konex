import { Concessionaire } from "./concessionaire";

export class Locality {
    
    id: number;
    localityName: string;
    concessionaire: Concessionaire;

    constructor(id: number, localityName: string, concessionaire: Concessionaire) {
        this.id = id;
        this.localityName = localityName;
        this.concessionaire = concessionaire;
    }
}