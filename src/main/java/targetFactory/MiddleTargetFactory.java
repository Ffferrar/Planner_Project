package targetFactory;

import targets.MiddleTarget;
import targets.Target;

import java.util.GregorianCalendar;

public class MiddleTargetFactory {
    Target createTarget(String name, GregorianCalendar endData, int queue, int color) {
        return new MiddleTarget(name, endData, queue, color);
    }
}
