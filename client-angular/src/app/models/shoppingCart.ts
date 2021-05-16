import { Customer } from "./customer";
import { Item } from "./item";


export class ShoppingCart {
    id: string;
    item: Item[];
    customer: Customer;
    shoppingCartStatus: String;
}