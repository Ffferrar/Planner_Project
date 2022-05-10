package data;

import settings.Settings;
import targets.Target;
import utils.TargetType;
import utils.TargetsFieldsName;

import java.util.List;

public interface DataAdmin {

    public void createNote(Target object, TargetType targetType);

    public void changeNote(Target object, TargetsFieldsName field);

    public void deleteNote(Target object);

    public List<Target> getAllObjects(String parentID);

    public Target getById(String id);
}

