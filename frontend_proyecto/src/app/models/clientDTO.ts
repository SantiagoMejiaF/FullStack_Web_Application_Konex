import { Locality } from "./locality";

/* The ClientDTO class represents a client with properties such as full name, ID number, address, phone
number, email, and locality. */
export class ClientDTO {
    fullName: string;
    idNumber: string;
    address: string;
    phoneNumber: string;
    email: string;
    locality: Locality;
}