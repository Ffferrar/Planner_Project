package TargetFactory;

import Targets.SuperTarget;
import Targets.Target;

public class SuperTargetFactory {
    Target createTarget() {
        return new SuperTarget();
    }
}
