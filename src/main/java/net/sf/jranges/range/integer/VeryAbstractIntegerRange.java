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

package net.sf.jranges.range.integer;

/**
 * 
 * Most abstract prototype implementation for {@link IntegerRange}.
 * 
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-08
 *
 */
public abstract class VeryAbstractIntegerRange implements IntegerRange {

	private volatile int hashCode;
	
	/**
	 * start position.
	 */
	protected int start;
	
	/**
	 * stop position.s
	 */
	protected int stop;

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
			result = prime * result + getStart();
			result = prime * result + getStop();
			result = prime * result + getInterval();
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
		if (!(obj instanceof IntegerRange))
			return false;
		IntegerRange other = (IntegerRange) obj;
		if (getStart() != other.getStart())
			return false;
		if (getStop() != other.getStop())
			return false;
		if (getInterval() != other.getInterval())
			return false;
		return true;
	}
	
	// Implement //
	
	public int getStart() {
		return start;
	}
	
	public int getStop() {
		return stop;
	}
	
	/**
	 * 
	 */
	public int getLength() {
		return getStop() - getStart() + 1;
	}
	
	/**
	 * 
	 */
	public int getInterval() {
		return 1;
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
		if (getStart() <= position && getStop() >= position)
			return true;
		return false;
	}

}
