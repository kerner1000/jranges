package net.sf.jranges.range.longrange.impl;

import net.sf.jranges.range.longrange.LongRange;

public abstract class VeryAbstractLongRange implements LongRange {

	private volatile int hashCode;

	/**
	 * start position.
	 */
	protected long start;

	/**
	 * stop position.
	 */
	protected long stop;

	// Override //

	@Override
	public String toString() {
		return getStart() + "-" + getStop();
	}

	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			final int prime = 31;
			result = 1;
			result = prime * result + (int) (start ^ (start >>> 32));
			result = prime * result + (int) (stop ^ (stop >>> 32));
			hashCode = result;
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeryAbstractLongRange other = (VeryAbstractLongRange) obj;
		if (start != other.start)
			return false;
		if (stop != other.stop)
			return false;
		return true;
	}

	// Implement //

	/**
	 * Compares this {@code LongRange} to given {@code LongRange} by
	 * {@link #getStart()} .
	 */
	public int compareTo(LongRange o) {
		return Long.valueOf(getStart()).compareTo(Long.valueOf(o.getStart()));
	}

	public long getStart() {
		return start;
	}

	public long getStop() {
		return stop;
	}

	/**
	 * 
	 */
	public long getLength() {
		return getStop() - getStart() + 1;
	}

	/**
	 * 
	 */
	public long getInterval() {
		return 1;
	}

	/**
	 * 
	 */
	public boolean includes(long position) {
		if (getStart() <= position && getStop() >= position)
			return true;
		return false;
	}

}
