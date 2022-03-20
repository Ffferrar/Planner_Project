package TargetFactory;

import Targets.Target;

public abstract class TargetMainFactory {
    abstract Target createTarget();
    abstract String getName();
    abstract float getStartData();
    abstract float getEndData();

}
