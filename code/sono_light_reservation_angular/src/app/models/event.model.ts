import { Reservation } from "./Reservation.model";

export class EventDetails {
    event_id!: number;
    title?: string;
    description?: string;
    location?: string;
    type?: number;
    user_comment?: string;
    admin_comment?: string;
    date_start!: Date;
    date_end!: Date;
    user_id?: number;
    technician_asked?: boolean;
    reservation_list?: Reservation[];
 } 