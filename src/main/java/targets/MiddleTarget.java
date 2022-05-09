package targets;

import java.util.GregorianCalendar;

public class MiddleTarget extends Target {
    public MiddleTarget(String name, GregorianCalendar endData, int queue, int color, String parentID){
        super(name, endData, queue, color);
        this.parentID = parentID;
    }
}
