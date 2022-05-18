package targetFactory;

import data.DataAdmin;
import data.DataAdminSQLite;
import targets.SmallTarget;
import targets.Target;
import utils.TargetType;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class SmallTargetFactory {

    DataAdmin dataAdmin;

    public SmallTargetFactory() throws SQLException {
        this.dataAdmin = new DataAdminSQLite();
    }

    public Target createTarget(String name, GregorianCalendar endData, int queue, int color, String parentID) throws SQLException {
        SmallTarget T = new SmallTarget(name, endData, queue, color, parentID);
        dataAdmin.createNote(T, TargetType.Small);
        return T;
    }
}