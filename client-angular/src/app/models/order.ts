import { Customer } from "./customer";
import { Item } from "./item";
import { Meal } from "./meal";

export class order {
    id:string;
    orderNumber:string;
    customer:Customer;
    paymentMethod: string;
    items: any[];
    subtotal:number;
    tax:number;
    total:number;

}