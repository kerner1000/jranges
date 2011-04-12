package net.sf.jranges.range.longrange.impl;

import net.sf.jranges.range.RangeException;
import net.sf.jranges.range.longrange.LongRange;

public class DummyLongRange extends VeryAbstractLongRange implements LongRange {
	
	// Constructor //

	/**
	 * 
	 * Construct a new {@code DummyLongRange} with start and stop values initiated with {@code 0}.
	 *
	 */
	public DummyLongRange() {
		this.start = 0;
		this.stop = 0;
	}

	/**
	 * 
	 * Construct a new {@code DummyLongRange} with given start and stop values.
	 *
	 */
	public DummyLongRange(long start, long stop) {
		this.start = start;
		this.stop = stop;
	}
	
	// Public //

	/**
	 * 
	 * Set start position for this {@code DummyLongRange}.
	 *
	 * @param start new start position
	 */
	public void setStart(long start) {
		this.start = start;
	}

	/**
	 * 
	 * Set stop position for this {@code DummyLongRange}.
	 *
	 * @param stop new stop position
	 */
	public void setStop(long stop) {
		this.stop = stop;
	}

	// Implement //

	/**
	 * 
	 */
	public LongRange shift(long offset) {
		return new DummyLongRange(getStart() + offset, getStop() + offset);
	}

	/**
	 * 
	 */
	public LongRange expandRange(long offset) throws RangeException {
		return expandRange(offset, false);
	}

	/**
	 * 
	 */
	public LongRange expandRange(long offset, boolean stayWithinLimits)
			throws RangeException {
		long start = getStart() - offset;
		long stop = getStop() + offset;
		return new DummyLongRange(start, stop);
	}

}
