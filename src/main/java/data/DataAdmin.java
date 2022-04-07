package data;

import targets.Target;

public final class DataAdmin {
    private static DataAdmin instance;
    public String value; //TODO заменить потом этот тип на БД
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
