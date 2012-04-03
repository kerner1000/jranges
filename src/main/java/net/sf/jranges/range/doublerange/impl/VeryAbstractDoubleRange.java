/**********************************************************************
Copyright (c) 2011 Alexander Kerner. All rights reserved.
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

package net.sf.jranges.range.doublerange.impl;

import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.integer.IntegerRange;

/**
 * 
 * Most abstract prototype implementation for {@link IntegerRange}.
 * 
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-02-23
 *
 */
public abstract class VeryAbstractDoubleRange implements DoubleRange {

	private volatile int hashCode;
	
	/**
	 * start position.
	 */
	protected double start;
	
	/**
	 * stop position.s
	 */
	protected double stop;

	// Override //

	@Override
	public String toString() {
		return getStart() + "->" + getStop();
	}

	@Override
	public int hashCode() {
		double result = hashCode;
		if (result == 0) {
			final int prime = 31;
			result = 1;
			result = prime * result + getStart();
			result = prime * result + getStop();
			hashCode = (int) result;
		}
		return (int) result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DoubleRange))
			return false;
		DoubleRange other = (DoubleRange) obj;
		if (getStart() != other.getStart())
			return false;
		if (getStop() != other.getStop())
			return false;
		return true;
	}
	
	// Implement //
	
	/**
	 * 
	 */
	public double getStart() {
		return start;
	}
	
	/**
	 * 
	 */
	public double getStop() {
		return stop;
	}
	
	/**
	 * 
	 */
	public double getInterval() {
		return 1;
	}
	
	public int getLength() {
		return (int) ((getStop() - getStart()) / getInterval()); 
	}
	
	/**
	 * Compares this {@code DoubleRange} to given {@code DoubleRange} by {@link #getStart()}
	 * .
	 */
	public int compareTo(DoubleRange o) {
		return Double.valueOf(getStart()).compareTo(
				Double.valueOf(o.getStart()));
	}

	/**
	 * 
	 */
	public boolean includes(double position) {
		if (getStart() <= position && getStop() >= position)
			return true;
		return false;
	}

}
