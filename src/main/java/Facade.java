import Settings.Settings;
import TargetFactory.TargetMainFactory;

public abstract class Facade { //TODO пока что оставлю абстракцией, пока не разберусь, что тут делвть
    char userCommand(){
        return 'a';
    }
    abstract TargetMainFactory createObjectCommand(char command_name);
    abstract Settings changeObjectCommand(char command_name);
}
