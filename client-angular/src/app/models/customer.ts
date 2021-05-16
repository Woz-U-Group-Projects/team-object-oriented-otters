import { customerAddress } from "./customerAddress";
import { Picture } from "./picture";

export class Customer{
    id:string;
    pictgureProfile:Picture;
    firstName:string;
    lastName:string;
    address: customerAddress;
    email:string;
    phoneNumber:string;

}