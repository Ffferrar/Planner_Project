package TargetFactory;

import Targets.MiddleTarget;
import Targets.Target;

public class MiddleTargetFactory extends TargetMainFactory{
    Target createTarget() {
        return new MiddleTarget();
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
