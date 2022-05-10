package targets;
import utils.CaseName;

import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class Target {
    public Target(String name, GregorianCalendar endData, int queue, int color){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.parentID = "0";
        this.startData = new GregorianCalendar();
        this.endData = endData;
        this.queue = queue;
        this.color = color;
        this.blocked = 0; // not boolean because of DB
    }

    public void isBlocked(int status){
        this.blocked = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    public String name;
    public String parentID;
    public GregorianCalendar startData;
    public GregorianCalendar endData;
    public int queue;
    public int color;
    public int blocked;
    public CaseName status;

}
