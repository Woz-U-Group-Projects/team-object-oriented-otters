import { Address } from "cluster";
import { operatingDaysTimes } from "./operatingDayTime";
import { Picture } from "./picture";

export class restaurant{
    id:string;
    picture:Picture;
    name:string;
    address:Address;
    operatingDaysTimes:operatingDaysTimes;
    phoneNumber:string;
    website:string;
}