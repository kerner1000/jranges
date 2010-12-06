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

package net.sf.jranges.range.integer.impl;

import net.sf.jranges.range.RangeException;
import net.sf.jranges.range.integer.AbstractIntegerRange;


/**
 * 
 * 
 * {@code ZeroPositiveRange} is an implementation for
 * {@link net.sf.jranges.range.integer.IntegerRange IntegerRange}, for which the
 * following is true:<br> {@code 0 <= start <= stop <= Integer.MAX_VALUE}
 * 
 * <p>
 * <b>Example:</b>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-10-19
 * 
 */
public class ZeroPositiveRange extends AbstractIntegerRange {

	public ZeroPositiveRange(int start, int stop) throws RangeException {
		super(start, stop, 0, Integer.MAX_VALUE);
		if (start < 0) {
			throw new RangeException("invalid range");
		}
	}
	
	public ZeroPositiveRange(int start, int stop, int interval) throws RangeException {
		super(start, stop, 0, Integer.MAX_VALUE, interval);
		if (start < 0) {
			throw new RangeException("invalid range");
		}
	}

	@Override
	protected
	ZeroPositiveRange newInstange(int start, int stop, int limit1, int limit2)
			throws RangeException {
		return new ZeroPositiveRange(start, stop, interval);
	}
}
