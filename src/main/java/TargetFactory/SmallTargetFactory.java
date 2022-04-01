package TargetFactory;

import Targets.SmallTarget;
import Targets.Target;

public class SmallTargetFactory extends TargetMainFactory{
    Target createTarget() {
        return new SmallTarget();
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