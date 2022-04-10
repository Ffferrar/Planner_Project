package data;

import settings.Settings;
import targets.Target;
import utils.TargetsFieldsName;

public interface DataAdmin {

    public void createNote(Target object);
    public void changeNote(Target object, TargetsFieldsName field);
    public void deleteNote(Target object);
}
