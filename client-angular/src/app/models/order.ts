import { Customer } from "./customer";

export class order {
    id:string;
    orderNumber:string;
    customer:Customer;
    //paymentMethod:paymentMethod;
    //items:item;
    subtotal:number;
    tax:number;
    total:number;
}