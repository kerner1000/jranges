package net.sf.jranges.range;

import java.util.Collection;

import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.integer.IntegerRange;
import net.sf.kerner.utils.math.MathUtils;

public class RangeUtils {
	
	public interface IntegerRangeTask {
		void call(int i);
	}
	
	public interface DoubleRangeTask {
		void call(double d);
	}
	
	private RangeUtils(){}
	
	public static boolean includesAll(IntegerRange range, Collection<? extends Integer> positions){
		for(int i : positions){
			if(range.includes(i)){
				// ok
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void doForAllInRange(IntegerRange range, IntegerRangeTask task){
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
