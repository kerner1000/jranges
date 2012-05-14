package net.sf.jranges.range.doublerange.impl;

import net.sf.jranges.range.doublerange.FactoryRangeDouble;

public class FactoryRangeDoubleZeroPositive implements FactoryRangeDouble<ZeroPositiveDoubleRange> {

	public ZeroPositiveDoubleRange create(double start, double stop) {
		return new ZeroPositiveDoubleRange(start, stop);
	}

}
