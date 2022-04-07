package targetFactory;

import targets.SmallTarget;
import targets.Target;

import java.util.GregorianCalendar;

public class SmallTargetFactory {
    Target createTarget(String name, GregorianCalendar endData, int queue, int color) {
        return new SmallTarget(name, endData, queue, color);
    }
}