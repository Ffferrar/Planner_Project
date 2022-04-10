package targets;
import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class Target {
    public Target(String name, GregorianCalendar endData, int queue, int color){
        this.id = UUID.randomUUID();
        this.name = name;
        this.startData = new GregorianCalendar();
        this.endData = endData;
        this.queue = queue;
        this.color = color;
        this.blocked = false;
    }

    public void isBlocked(boolean status){
        this.blocked = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;
    public String name;
    public GregorianCalendar startData;
    public GregorianCalendar endData;
    public int queue;
    public int color;
    public boolean blocked;

}
