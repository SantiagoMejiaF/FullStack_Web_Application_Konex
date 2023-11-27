import { Locality } from "./locality";

export class ClientDTO {
    fullName: string;
    idNumber: string;
    address: string;
    phoneNumber: string;
    email: string;
    locality: Locality;
}