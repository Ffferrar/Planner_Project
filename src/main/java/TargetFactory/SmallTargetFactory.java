package TargetFactory;

import Targets.SmallTarget;
import Targets.Target;

public class SmallTargetFactory {
    Target createTarget() {
        return new SmallTarget();
    }
}