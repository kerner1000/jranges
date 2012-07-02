package net.sf.jranges.range.doublerange.impl;

import net.sf.jranges.range.RangeException;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.kerner.utils.math.MathUtils;

public abstract class AbstractDoubleRange extends VeryAbstractDoubleRange implements DoubleRange {

	public static final int ACCURACY = 6;

	/**
	 * This {@code AbstractDoubleRange's} lower limit, which is the smallest
	 * possible position that is valid for {@code start}.
	 */
	protected final double limit1;

	/**
	 * This {@code AbstractDoubleRange's} upper limit, which is the biggest
	 * possible position that is valid for {@code stop}.
	 */
	protected final double limit2;

	/**
	 * This {@code AbstractDoubleRange's} interval.
	 */
	protected final double interval;

	// Constructor //

	/**
	 * 
	 * 
	 * Construct a new {@code AbstractDoubleRange}.
	 * <p>
	 * For every {@code AbstractDoubleRange} following is true: <br>
	 * {@code limit1 <= start <= stop <= limit2}
	 * </p>
	 * 
	 * @param start
	 *            start point of this {@code AbstractDoubleRange}
	 * @param stop
	 *            stop point of this {@code AbstractDoubleRange}
	 * @param limit1
	 *            minimum value that is valid for this
	 *            {@code AbstractDoubleRange's} start point
	 * @param limit2
	 *            maximum value that is valid for this
	 *            {@code AbstractDoubleRange's} stop point
	 * @throws RangeException
	 *             if {@code limit1 > start || limit2 < stop || start > stop}
	 */
	public AbstractDoubleRange(double start, double stop, double limit1, double limit2) throws RangeException {
		if (limit1 > start || limit2 < stop || start > stop)
			throw new RangeException("invalid range" + " start=" + start + " stop=" + stop + " limit1=" + limit1
					+ " limit2=" + limit2);
		this.interval = 1;
		this.limit1 = limit1;
		this.limit2 = limit2;
		this.stop = stop;
		this.start = start;
	}

	/**
	 * 
	 * 
	 * Construct a new {@code AbstractDoubleRange}.
	 * <p>
	 * For every {@code AbstractDoubleRange} following is true: <br>
	 * {@code limit1 <= start <= stop <= limit2}
	 * </p>
	 * 
	 * @param start
	 *            start point of this {@code AbstractDoubleRange}
	 * @param stop
	 *            stop point of this {@code AbstractDoubleRange}
	 * @param limit1
	 *            minimum value that is valid for this
	 *            {@code AbstractDoubleRange's} start point
	 * @param limit2
	 *            maximum value that is valid for this
	 *            {@code AbstractDoubleRange's} stop point
	 * @param interval
	 *            interval of this {@code AbstractDoubleRange}
	 * @throws RangeException
	 *             if
	 *             {@code limit1 > start || limit2 < stop || start > stop || (((stop - start) % interval) != 0)}
	 */
	public AbstractDoubleRange(double start, double stop, double limit1, double limit2, double interval)
			throws RangeException {
		if (limit1 > start || limit2 < stop || start > stop || (inValid(start, stop, interval)))
			throw new RangeException("invalid range" + " start=" + start + " stop=" + stop + " limit1=" + limit1
					+ " limit2=" + limit2 + "interval=" + interval);
		this.limit1 = limit1;
		this.limit2 = limit2;
		this.interval = interval;
		this.stop = stop;
		this.start = start;
	}

	protected static boolean inValid(double start, double stop, double interval) {
		// System.out.println("diff:" + MathUtils.round(stop - start,
		// ACCURACY));
		// System.out.println("mod:" + MathUtils.round((MathUtils.round(stop -
		// start, ACCURACY)) % interval, ACCURACY));
		// System.out.println("return:" + (MathUtils.round((MathUtils.round(stop
		// - start, ACCURACY)) % interval, ACCURACY) == 0));
		return (MathUtils.round((MathUtils.round(stop - start, ACCURACY)) % interval, ACCURACY) != 0

		// double accuracy workaround
		&& MathUtils.round((MathUtils.round(stop - start, ACCURACY)) % interval, ACCURACY) != interval);
	}

	// Public //

	/**
	 * 
	 * Retrieve this {@code AbstractDoubleRange's} lower limit. This is the
	 * smallest possible value for {@code start}.
	 * 
	 * @return lower limit for this {@code AbstractDoubleRange}
	 */
	public double getLimit1() {
		return limit1;
	}

	/**
	 * 
	 * Retrieve this {@code AbstractDoubleRange's} upper limit. This is the
	 * greatest possible value for {@code stop}.
	 * 
	 * @return upper limit for this {@code AbstractDoubleRange}
	 */
	public double getLimit2() {
		return limit2;
	}

	// Override //

	@Override
	public double getInterval() {
		return interval;
	}

	@Override
	public boolean includes(double position) {
		if (interval == 1)
			return super.includes(position);
		if (position == getStart() || position == getStop())
			return true;
		return ((MathUtils.round(MathUtils.round(position - start, ACCURACY) % interval, ACCURACY) == 0) || (MathUtils
				.round(MathUtils.round(position - start, ACCURACY) % interval, ACCURACY) == interval))
				&& position <= stop;
	}

	// Implement //

	public DoubleRange shift(double offset) throws RangeException {
		return newInstange(getStart() + offset, getStop() + offset, getLimit1(), getLimit2());
	}

	public DoubleRange expandRange(double offset) throws RangeException {
		return expandRange(offset, false);
	}

	public DoubleRange expandRange(double offset, boolean stayWithinLimits) throws RangeException {
		double start = this.start;
		double stop = this.stop;
		if (stayWithinLimits) {
			start = getStart() - offset;
			stop = getStop() + offset;

			if (start < limit1) {
				start = limit1;
			}
			if (stop > limit2) {
				stop = limit2;
			}
			return newInstange(start, stop, getLimit1(), getLimit2());
		} else {
			start = getStart() - offset;
			stop = getStop() + offset;
			return newInstange(start, stop, getLimit1(), getLimit2());
		}
	}

	// Abstract //

	/**
	 * 
	 * 
	 * Retrieve a new {@code AbstractDoubleRange} instance based on the given
	 * parameter.
	 * 
	 * @param start
	 *            start point for new {@code AbstractDoubleRange}
	 * @param stop
	 *            stop point for new {@code AbstractDoubleRange}
	 * @param limit1
	 *            limit1 point for new {@code AbstractDoubleRange}
	 * @param limit2
	 *            limit2 point for new {@code AbstractDoubleRange}
	 * @return the new {@code AbstractDoubleRange} instance
	 * @throws RangeException
	 */
	protected abstract AbstractDoubleRange newInstange(double start, double stop, double limit1, double limit2)
			throws RangeException;
}
