import { Item } from "./item";
import { Picture } from "./picture";

export class Meal implements Item{
    id:string;
    picture:Picture;
    name:string;
    description:string;
    unitType:string;
    items: any[];
    price:number;

}