package net.sf.jranges.range.doublerange;

public interface FactoryRangeDouble<R extends DoubleRange> {

	R create(double start, double stop);

}
