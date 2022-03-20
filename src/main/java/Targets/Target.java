package Targets;

public abstract class Target {
    String name;
    float startDate; //TODO позже поменяю тип этих обьектов на LocalData
    float endDate;
    int queue;
    int color;
    private boolean isBlocked(boolean status){
        return status;
    }
}
