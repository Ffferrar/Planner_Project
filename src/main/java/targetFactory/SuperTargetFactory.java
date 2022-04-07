package targetFactory;

import targets.SuperTarget;
import targets.Target;

import java.util.GregorianCalendar;

public class SuperTargetFactory {
    Target createTarget(String name, GregorianCalendar endData, int queue, int color) {
        return new SuperTarget(name, endData, queue, color);
    }
}
