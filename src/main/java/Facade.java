import Settings.Settings;
import TargetFactory.TargetMainFactory;

public abstract class Facade { //TODO убрать абстракцию
    char userCommand(){
        return 'a';
    }
    abstract TargetMainFactory createObjectCommand(char command_name);
    abstract Settings changeObjectCommand(char command_name);
}
