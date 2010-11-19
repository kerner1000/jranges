/**********************************************************************
Copyright (c) 2009-2010 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.jranges.range.impl;

import net.sf.jranges.range.IntegerRange;
import net.sf.jranges.range.RangeException;

/**
 * 
 * Most simple implementation for
 * {@link net.sf.jranges.range.IntegerRange IntegerRange}. Arguments and
 * operations are not checked for validity.
 * 
 * <p>
 * A {@code DummyRange} is mutable. Start and Stop may be set independently.
 * </p>
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-18
 * 
 */
public class DummyRange implements IntegerRange {
	
	// Field //

	/**
	 * start position.
	 */
	protected int start;
	
	/**
	 * stop position.s
	 */
	protected int stop;
	
	// Constructor //

	/**
	 * 
	 * Construct a new {@code DummyRange} with start and stop values initiated with {@code 0}.
	 *
	 */
	public DummyRange() {
		this.start = 0;
		this.stop = 0;
	}

	/**
	 * 
	 * Construct a new {@code DummyRange} with given start and stop values.
	 *
	 */
	public DummyRange(int start, int stop) {
		this.start = start;
		this.stop = stop;
	}
	
	// Public //

	/**
	 * 
	 * Set start position for this {@code DummyRange}.
	 *
	 * @param start new start position
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * 
	 * Set stop position for this {@code DummyRange}.
	 *
	 * @param stop new stop position
	 */
	public void setStop(int stop) {
		this.stop = stop;
	}
	
	// Override //
	
	@Override
	public String toString() {
		return getStart() + "-" + getStop();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + start;
		result = prime * result + stop;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IntegerRange))
			return false;
		IntegerRange other = (IntegerRange) obj;
		if (start != other.getStart())
			return false;
		if (stop != other.getStop())
			return false;
		return true;
	}
	
	// Implement //

	/**
	 * 
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 
	 */
	public int getStop() {
		return stop;
	}

	/**
	 * 
	 */
	public int getLength() {
		return stop - start + 1;
	}
	
	/**
	 * 
	 */
	public int getInterval() {
		return 1;
	}

	/**
	 * 
	 */
	public IntegerRange shift(int offset) {
		return new DummyRange(getStart() + offset, getStop() + offset);
	}

	/**
	 * 
	 */
	public IntegerRange expandRange(int offset) throws RangeException {
		return expandRange(offset, false);
	}

	/**
	 * 
	 */
	public IntegerRange expandRange(int offset, boolean stayWithinLimits)
			throws RangeException {
		int start = getStart() - offset;
		int stop = getStop() + offset;
		return new DummyRange(start, stop);
	}

	/**
	 * Compares this {@code IntegerRange} to given {@code IntegerRange} by {@link #getStart()}
	 * .
	 */
	public int compareTo(IntegerRange o) {
		return Integer.valueOf(getStart()).compareTo(
				Integer.valueOf(o.getStart()));
	}

	/**
	 * 
	 */
	public boolean includes(int position) {
		if (start <= position && stop >= position)
			return true;
		return false;
	}

	

}
