package net.sf.jranges.range.doublerange.impl;

import net.sf.jranges.range.RangeException;

public class ZeroPositiveDoubleRange extends AbstractDoubleRange {

	public ZeroPositiveDoubleRange(double start, double stop) throws RangeException {
		super(start, stop, 0, Double.MAX_VALUE);
	}
	
	public ZeroPositiveDoubleRange(double start, double stop, double interval) throws RangeException {
		super(start, stop, 0, Double.MAX_VALUE, interval);
	}
	
	public ZeroPositiveDoubleRange(String start, String stop, String interval) throws RangeException, NumberFormatException {
		this(Double.parseDouble(start.trim()), Double.parseDouble(stop.trim()), Double.parseDouble(interval.trim()));
	}

	@Override
	protected ZeroPositiveDoubleRange newInstange(double start, double stop, double limit1, double limit2)
			throws RangeException {
		return new ZeroPositiveDoubleRange(start, stop, interval);
	}

}
