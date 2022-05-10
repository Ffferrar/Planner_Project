package commands;

import settings.Settings;
import targets.Target;
import utils.TargetsFieldsName;

import java.sql.SQLException;
import java.util.GregorianCalendar;

//TODO реализация в следующей итерации
public class ChangeCommand extends Command{

    public Settings settings;
    public Target obj;
    public TargetsFieldsName targetsFieldsName;

    public ChangeCommand(Target obj, TargetsFieldsName targetsFieldsName, String stringField) throws SQLException {
        this.settings = new Settings(obj);
        this.obj = obj;
        this.targetsFieldsName = targetsFieldsName;
        this.stringField = stringField;
    }

    public ChangeCommand(Target obj, TargetsFieldsName targetsFieldsName, int intField) throws SQLException {
        this.settings = new Settings(obj);
        this.obj = obj;
        this.targetsFieldsName = targetsFieldsName;
        this.intField = intField;
    }

    public ChangeCommand(Target obj, TargetsFieldsName targetsFieldsName, GregorianCalendar calendarField) throws SQLException {
        this.settings = new Settings(obj);
        this.obj = obj;
        this.targetsFieldsName = targetsFieldsName;
        this.calendarField = calendarField;
    }

    public void execute() throws SQLException {
        switch(this.targetsFieldsName){
            case NAME:
                settings.changeName(stringField);
                break;
            case END_DATA:
                settings.changeEndData(calendarField);
                break;
            case QUEUE:
                settings.changeQueue(intField);
                break;
            case COLOR:
                settings.changeColor(intField);
                break;
            case BLOCKED:
                settings.changeBlocked(intField);
                break;
        }
    }
}
