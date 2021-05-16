import { Item } from "./item";
import { Picture } from "./picture";

export class side implements Item{
    id:string;
    picture:Picture;
    name:string;
    description:string;
    unitType:string;
    size:number;
    price:number;
}