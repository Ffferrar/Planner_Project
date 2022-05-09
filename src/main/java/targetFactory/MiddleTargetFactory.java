package targetFactory;

import data.DataAdmin;
import data.DataAdminSQLite;
import targets.MiddleTarget;
import targets.Target;
import utils.TargetType;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class MiddleTargetFactory {

    DataAdmin dataAdmin;

    public MiddleTargetFactory() throws SQLException {
        this.dataAdmin = new DataAdminSQLite();
    }

    public Target createTarget(String name, GregorianCalendar endData, int queue, int color, String parentID) throws SQLException {
        MiddleTarget T = new MiddleTarget(name, endData, queue, color, parentID);
        dataAdmin.createNote(T, TargetType.Middle);
        return T;
    }
}
