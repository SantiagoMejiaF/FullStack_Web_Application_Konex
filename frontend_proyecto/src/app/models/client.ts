import { Locality } from "./locality";

/* The Client class represents a client with properties such as id, fullName, idNumber, address,
phoneNumber, email, and locality. */
export class Client {
    id: number;
    fullName: string;
    idNumber: string;
    address: string;
    phoneNumber: string;
    email: string;
    locality: Locality;
}