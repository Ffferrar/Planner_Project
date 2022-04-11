package targetFactory;

import data.DataAdminSQLite;
import targets.SmallTarget;
import targets.Target;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class SmallTargetFactory {
    public Target createTarget(String name, GregorianCalendar endData, int queue, int color) throws SQLException {
        SmallTarget T = new SmallTarget(name, endData, queue, color);
        new DataAdminSQLite().createNote(T);
        return T;
    }
}