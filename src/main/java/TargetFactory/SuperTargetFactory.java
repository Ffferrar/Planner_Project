package TargetFactory;

import Targets.SuperTarget;
import Targets.Target;

public class SuperTargetFactory extends TargetMainFactory{
    Target createTarget() {
        return new SuperTarget();
    }

    @Override
    String getName() {
        return null;
    }

    @Override
    float getStartData() {
        return 0;
    }

    @Override
    float getEndData() {
        return 0;
    }
}
