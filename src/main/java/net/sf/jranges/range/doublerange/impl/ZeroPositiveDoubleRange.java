package net.sf.jranges.range.doublerange.impl;

import net.sf.jranges.range.RangeException;

public class ZeroPositiveDoubleRange extends AbstractDoubleRange {

	public ZeroPositiveDoubleRange(double start, double stop) throws RangeException {
		super(start, stop, 0, Double.MAX_VALUE);
	}
	
	public ZeroPositiveDoubleRange(double start, double stop, double interval) throws RangeException {
		super(start, stop, 0, Double.MAX_VALUE, interval);
	}

	@Override
	protected ZeroPositiveDoubleRange newInstange(double start, double stop, double limit1, double limit2)
			throws RangeException {
		return new ZeroPositiveDoubleRange(start, stop, interval);
	}

}
