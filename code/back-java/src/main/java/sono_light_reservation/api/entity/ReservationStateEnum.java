package sono_light_reservation.api.entity;

public enum ReservationStateEnum {
    //reservation_state : 1=enAttente, 2=validée, 3=enCours, 4=terminée
    EN_ATTENTE(1),
    VALIDEE(2),
    EN_COURS(3),
    TERMINEE(4);

    private int value;
    ReservationStateEnum(int value) {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

