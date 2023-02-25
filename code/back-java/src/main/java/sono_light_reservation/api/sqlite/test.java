package sono_light_reservation.api.sqlite;

import org.hibernate.dialect.Dialect;

import java.sql.Types;

public class test {
    public SQLDialect2() {
        registerColumnType(Types.BIT, "integer");

    }
}