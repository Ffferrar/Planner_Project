package targets;
import java.util.GregorianCalendar;

public abstract class Target {
    public Target(String name, GregorianCalendar endData, int queue, int color){
        this.name = name;
        this.startData = new GregorianCalendar();
        this.endData = endData;
        this.queue = queue;
        this.color = color;
    }
    String name;
    GregorianCalendar startData;
    GregorianCalendar endData;
    int queue;
    int color;
    private void isBlocked(boolean status){

    }
}
