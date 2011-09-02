package net.sf.jranges.range.integer.impl;

import net.sf.jranges.range.integer.IntegerRange;
import net.sf.jranges.range.integer.IntegerRangeFactory;

public class ZeroPositiveIntegerRangeFactory implements IntegerRangeFactory<ZeroPositiveIntegerRange> {

	public ZeroPositiveIntegerRange create() {
		return new ZeroPositiveIntegerRange(0, 0);
	}

	public ZeroPositiveIntegerRange create(int start, int stop) {
		return new ZeroPositiveIntegerRange(start, stop);
	}

	public ZeroPositiveIntegerRange create(IntegerRange template) {
		return create(template.getStart(), template.getStop());
	}

}
