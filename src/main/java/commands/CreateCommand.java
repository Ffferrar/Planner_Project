package commands;

import targetFactory.MiddleTargetFactory;
import targetFactory.SmallTargetFactory;
import targetFactory.SuperTargetFactory;
import targets.SmallTarget;
import utils.TargetType;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class CreateCommand extends Command{
    public String stringField;
    public int intField;
    public GregorianCalendar calendarField;
    public TargetType targetType;

    public CreateCommand(TargetType targetType, String stringField, int intField, GregorianCalendar calendarField){
        this.targetType = targetType;
        this.stringField = stringField;
        this.intField = intField;
        this.calendarField = calendarField;
    }

    @Override
    public void execute() throws SQLException {
        switch (targetType){
            case Small:
                new SmallTargetFactory().createTarget(stringField, calendarField, intField, 5, "0");
            case Middle:
                new MiddleTargetFactory().createTarget(stringField, calendarField, intField, 6, "0");
            case Super:
                new SuperTargetFactory().createTarget(stringField, calendarField, intField, 7);
        }
    }
}
