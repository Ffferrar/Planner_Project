package settings;
import data.DataAdmin;
import targets.Target;
import data.DataAdminSQLite;
import utils.TargetsFieldsName;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class Settings {

    public Settings(Target input){
        this.changingObject = input;
    }

    public void changeName(String name) throws SQLException {
        changingObject.name = name;
        new DataAdminSQLite().changeNote(changingObject, TargetsFieldsName.NAME);
    }

    public void changeEndData(GregorianCalendar input) throws SQLException {
        changingObject.endData = input;
        new DataAdminSQLite().changeNote(changingObject, TargetsFieldsName.END_DATA);
    }

    public void changeQueue(int input) throws SQLException {
        changingObject.queue = input;
        new DataAdminSQLite().changeNote(changingObject, TargetsFieldsName.QUEUE);
    }

    void changeColor(int input) throws SQLException {
        changingObject.color = input;
        new DataAdminSQLite().changeNote(changingObject, TargetsFieldsName.COLOR);
    }

    void changeBlocked(boolean input) throws SQLException {
        changingObject.isBlocked(input);
        new DataAdminSQLite().changeNote(changingObject, TargetsFieldsName.BLOCKED);
    }

    Target changingObject;
}
