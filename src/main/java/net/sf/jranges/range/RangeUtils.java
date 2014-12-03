/*******************************************************************************
 * Copyright (c) 2010-2014 Alexander Kerner. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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
        for (double i = range.getStart(); UtilMath.round(i, 6) <= range.getStop(); i += range
                .getInterval()) {
            task.call(i);
        }
    }

    public static void doForAllInRange(final IntegerRange range, final IntegerRangeTask task) {
        if (range == null || task == null) {
            throw new NullPointerException();
        }
        for (int i = range.getStart(); i <= range.getStop(); i += range.getInterval()) {
            task.call(i);
        }
    }

    public static boolean includesAll(final IntegerRange range,
            final Collection<? extends Integer> positions) {
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
