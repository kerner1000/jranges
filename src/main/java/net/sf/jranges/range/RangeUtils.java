package net.sf.jranges.range;

import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.integer.IntegerRange;
import net.sf.kerner.utils.math.MathUtils;

public class RangeUtils {
	
	public interface IntegerRangeCallback {
		void call(int i);
	}
	
	public interface DoubleRangeTask {
		void call(double d);
	}
	
	private RangeUtils(){}
	
	public static void doForAllInRange(IntegerRange range, IntegerRangeCallback task){
		for(int i = range.getStart(); i <= range.getStop(); i+= range.getInterval()){
			task.call(i);
		}
	}
	
	public static void doForAllInRange(DoubleRange range, DoubleRangeTask task){
		for(double i = range.getStart(); MathUtils.round(i, 6) <= range.getStop(); i+= range.getInterval()){
			task.call(i);
		}
	}

}
