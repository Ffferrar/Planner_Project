package Data;

import Targets.Target;

public final class DataAdmin {
    private static DataAdmin instance;
    public String value; //TODO заменить на БД
    public static DataAdmin getInstance(String value){
        if (instance == null){
            instance = new DataAdmin();
        }
        return instance;
    }

    public String createNote(Target object){ //TODO поменять на CSV обьект
        return "FirstTry";
    }
}
