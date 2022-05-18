package settings;
import data.DataAdmin;
import targets.Target;
import data.DataAdminSQLite;
import utils.TargetsFieldsName;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class Settings {

    public Settings(Target input) throws SQLException {
        this.changingObject = input;
        this.dataAdmin = new DataAdminSQLite();
    }

    public void changeName(String name) throws SQLException {
        changingObject.name = name;
        dataAdmin.changeNote(changingObject, TargetsFieldsName.NAME);
    }

    public void changeEndData(GregorianCalendar input) throws SQLException {
        changingObject.endData = input;
        dataAdmin.changeNote(changingObject, TargetsFieldsName.END_DATA);
    }

    public void changeQueue(int input) throws SQLException {
        changingObject.queue = input;
        dataAdmin.changeNote(changingObject, TargetsFieldsName.QUEUE);
    }

    public void changeColor(int input) throws SQLException {
        changingObject.color = input;
        dataAdmin.changeNote(changingObject, TargetsFieldsName.COLOR);
    }

    public void changeBlocked(int input) throws SQLException {
        changingObject.isBlocked(input);
        dataAdmin.changeNote(changingObject, TargetsFieldsName.BLOCKED);
    }

    Target changingObject;
    DataAdmin dataAdmin;
}
