import {Picture} from "./picture";
import { Item } from "./item";
export class Beverage implements Item{
    id: string;
    picture: Picture;
    name: string;
    description: string;
    unitType: string;
    beverageType: string;
    price: number;
}