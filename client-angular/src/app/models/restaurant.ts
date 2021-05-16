import { Address } from "./address"
import { OperatingDaysTimes } from "./operatingDayTime";
import { Picture } from "./picture";

export class restaurant{
    id:string;
    picture:Picture;
    name:string;
    address:Address;
    operatingDaysTimes:OperatingDaysTimes;
    phoneNumber:string;
    website:string;
}