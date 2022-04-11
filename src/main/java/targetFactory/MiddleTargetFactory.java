package targetFactory;

import data.DataAdminSQLite;
import targets.MiddleTarget;
import targets.Target;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class MiddleTargetFactory {
    Target createTarget(String name, GregorianCalendar endData, int queue, int color) throws SQLException {
        MiddleTarget T = new MiddleTarget(name, endData, queue, color);
        new DataAdminSQLite().createNote(T);
        return T;
    }
}
