package net.sf.jranges.range;

import java.util.Collection;

import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.integer.IntegerRange;
import net.sf.kerner.utils.math.UtilMath;

public class RangeUtils {

    public interface DoubleRangeTask {
        void call(double d);
    }

    public interface IntegerRangeTask {
        void call(int i);
    }

    public static void doForAllInRange(final DoubleRange range, final DoubleRangeTask task) {
        for (double i = range.getStart(); UtilMath.round(i, 6) <= range.getStop(); i += range.getInterval()) {
            task.call(i);
        }
    }

    public static void doForAllInRange(final IntegerRange range, final IntegerRangeTask task) {
        for (int i = range.getStart(); i <= range.getStop(); i += range.getInterval()) {
            task.call(i);
        }
    }

    public static boolean includesAll(final IntegerRange range, final Collection<? extends Integer> positions) {
        for (final int i : positions) {
            if (range.includes(i)) {
                // ok
            } else {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static int startStayWithinLimit(final int value, final int limit) {
        if (value < limit)
            return limit;
        return value;
    }

    @Deprecated
    public static int stopStayWithinLimit(final int value, final int limit) {
        if (value > limit)
            return limit;
        return value;
    }

    private RangeUtils() {
    }
}
