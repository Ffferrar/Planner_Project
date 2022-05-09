package targetFactory;

import data.DataAdmin;
import targets.SuperTarget;
import targets.Target;
import data.DataAdminSQLite;
import utils.TargetType;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class SuperTargetFactory {

    DataAdmin dataAdmin;

    public SuperTargetFactory() throws SQLException {
        this.dataAdmin = new DataAdminSQLite();
    }

    public Target createTarget(String name, GregorianCalendar endData, int queue, int color) throws SQLException {
        SuperTarget T = new SuperTarget(name, endData, queue, color);
        dataAdmin.createNote(T, TargetType.Super);
        return T;

    }
}
