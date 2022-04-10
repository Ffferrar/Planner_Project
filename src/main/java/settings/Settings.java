package settings;
import targets.Target;

import java.util.GregorianCalendar;

public class Settings {

    public Settings(Target input){
        this.changingObject = input;
    }
    Target changingObject;
    public void changeName(String name){
        changingObject.name = name;
    }
    public void changeEndData(GregorianCalendar input){
        changingObject.endData = input;
    }
    public void changeQueue(int input){
        changingObject.queue = input;
    }
    void changeColor(int input){
        changingObject.color = input;
    }
    void changeBlocked(boolean input){
        changingObject.isBlocked(input);
    }
}

//TODO после реализации БД в каждом методе вызываем DataAdmin и кидаем туда объект