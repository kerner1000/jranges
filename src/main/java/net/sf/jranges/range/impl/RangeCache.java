package net.sf.jranges.range.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.sf.jranges.range.integer.IntegerRange;

class RangeCache implements Iterable<Collection<? extends IntegerRange>>,Iterator<Collection<? extends IntegerRange>>{
	
	final static int DEFAULT_ELEMENTS = 10000;
	
	final int elements;
	
	private final List<? extends IntegerRange> ranges;
	
	private volatile Collection<? extends IntegerRange> cache;
	
	private volatile int index = 0;
	
	RangeCache(final Collection<? extends IntegerRange> ranges, int elements){
		this.elements = elements;
		this.ranges = new ArrayList<IntegerRange>(ranges);
		fill();
	}
	
	RangeCache(final Collection<? extends IntegerRange> ranges){
		this.elements = DEFAULT_ELEMENTS;
		this.ranges = new ArrayList<IntegerRange>(ranges);
		fill();
	}
	
	private void fill(){
		int end = index + elements;
		if(end > ranges.size()-1)
			end = ranges.size();
		cache = new ArrayList<IntegerRange>(ranges.subList(index, end));
		index += elements;
	}

	/** 
	 * 
	 */
	public boolean hasNext() {
//		System.err.println(index);
		return (index <= ranges.size());
	}

	/** 
	 * 
	 */
	public synchronized Collection<? extends IntegerRange> next() {
		final Collection<? extends IntegerRange> result = new ArrayList<IntegerRange>(cache);
		fill();
		return result;
	}

	/** 
	 * 
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/** 
	 * 
	 */
	public Iterator<Collection<? extends IntegerRange>> iterator() {
		return this;
	}
}
