package commands;

import utils.TargetType;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public abstract class Command {
    public String stringField;
    public int intField;
    public GregorianCalendar calendarField;
    public TargetType targetType;
    public String parentID;


}
