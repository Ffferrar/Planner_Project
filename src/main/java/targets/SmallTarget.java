package targets;

import utils.CaseName;

import java.util.GregorianCalendar;

public class SmallTarget extends Target{
    public SmallTarget(String name, GregorianCalendar endData, int queue, int color, String parentID){
        super(name, endData, queue, color);
        this.checkbox = false;
        this.status = CaseName.TODO_CASE;
        this.parentID = parentID;
    }
    boolean checkbox;
    CaseName status;
}
