import { Concessionaire } from "./concessionaire";

/* The Locality class represents a locality with a name and a concessionaire. */
export class Locality {
    id?: number;
    localityName: string;
    concessionaire: Concessionaire;
}