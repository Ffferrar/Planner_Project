package targets;

import utils.CaseName;

import java.util.GregorianCalendar;

public class SmallTarget extends Target{
    public SmallTarget(String name, GregorianCalendar endData, int queue, int color){
        super(name, endData, queue, color);
        this.checkbox = false;
        this.status = CaseName.TODO_CASE;
    }
    boolean checkbox;
    CaseName status;
}
