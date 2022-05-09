package targetFactory;

import data.DataAdmin;
import data.DataAdminSQLite;
import targets.SmallTarget;
import targets.Target;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class SmallTargetFactory {

    DataAdmin dataAdmin;

    public SmallTargetFactory() throws SQLException {
        this.dataAdmin = new DataAdminSQLite();
    }

    public Target createTarget(String name, GregorianCalendar endData, int queue, int color) throws SQLException {
        SmallTarget T = new SmallTarget(name, endData, queue, color);
        dataAdmin.createNote(T);
        return T;
    }
}