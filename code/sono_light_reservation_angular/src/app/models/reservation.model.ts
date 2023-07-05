export class Reservation {
    reservation_id?: number;
    reservation_label?: string;
    reservation_state?: ReservationStateEnum;
    equipment_id?: number;
    category_id?: number;
    event_id?: number;
  }
  
  export enum ReservationStateEnum {
    EN_ATTENTE = 0,
    VALIDEE = 1,
    EN_COURS = 2,
    TERMINEE = 3
  }