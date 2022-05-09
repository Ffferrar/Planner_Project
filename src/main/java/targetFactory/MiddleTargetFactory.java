package targetFactory;

import data.DataAdmin;
import data.DataAdminSQLite;
import targets.MiddleTarget;
import targets.Target;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class MiddleTargetFactory {

    DataAdmin dataAdmin;

    public MiddleTargetFactory() throws SQLException {
        this.dataAdmin = new DataAdminSQLite();
    }

    public Target createTarget(String name, GregorianCalendar endData, int queue, int color) throws SQLException {
        MiddleTarget T = new MiddleTarget(name, endData, queue, color);
        dataAdmin.createNote(T);
        return T;
    }
}
