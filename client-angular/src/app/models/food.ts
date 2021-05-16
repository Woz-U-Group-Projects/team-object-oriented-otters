import { Picture } from "./picture";
import { Item } from "./item";

export class food implements Item{
    id:string;
    picture:Picture;
    name:string;
    description:string;
    unitType:string;
    ingredients:string[];
    price:number;
}