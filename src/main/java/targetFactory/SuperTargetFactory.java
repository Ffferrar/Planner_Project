package targetFactory;

import targets.SuperTarget;
import targets.Target;
import data.DataAdminSQLite;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class SuperTargetFactory {
    public Target createTarget(String name, GregorianCalendar endData, int queue, int color) throws SQLException {
        SuperTarget T = new SuperTarget(name, endData, queue, color);
        new DataAdminSQLite().createNote(T);
        return T;

    }
}
