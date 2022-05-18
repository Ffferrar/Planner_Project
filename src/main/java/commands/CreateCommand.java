package commands;

import targetFactory.MiddleTargetFactory;
import targetFactory.SmallTargetFactory;
import targetFactory.SuperTargetFactory;
import targets.SmallTarget;
import utils.TargetType;

import java.sql.SQLException;
import java.util.GregorianCalendar;

public class CreateCommand extends Command{


    public CreateCommand(TargetType targetType, String stringField, int intField, GregorianCalendar calendarField, String parentID){
        this.targetType = targetType;
        this.stringField = stringField;
        this.intField = intField;
        this.calendarField = calendarField;
        this.parentID = parentID;
    }

    public void execute() throws SQLException {
        switch (targetType){
            case Small:
                new SmallTargetFactory().createTarget(stringField, calendarField, intField, 5, parentID);
                break;
            case Middle:
                new MiddleTargetFactory().createTarget(stringField, calendarField, intField, 6, parentID);
                break;
            case Super:
                new SuperTargetFactory().createTarget(stringField, calendarField, intField, 7);
                break;
        }
    }
}
