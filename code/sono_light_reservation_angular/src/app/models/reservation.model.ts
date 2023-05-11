import { EventDetails } from "./event.model";

export interface Reservation {
    reservationId: number;
    reservationLabel: string;
    reservationState: string;
    //equipment: Equipment;
    //category: Category;
    eventDetails: EventDetails;
 } 