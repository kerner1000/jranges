/**
 * 
 */
package net.sf.jranges.range.integer.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import net.sf.jranges.range.integer.IntegerRange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-18
 *
 */
public class TestRangeCache {
	
	RangeCache cache;
	IntegerRange range1;
	IntegerRange range2;
	IntegerRange range3;
	IntegerRange range4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.range.impl.RangeCache#next()}.
	 */
	@Test
	public final void testNext() {
		ArrayList<IntegerRange> range = new ArrayList<IntegerRange>();
		range1 = new DummyIntegerRange(1,10);
			range2 = new DummyIntegerRange(11,20);
				range3 = new DummyIntegerRange(21,30);
					range4 = new DummyIntegerRange(31,40);
		range.add(range1);
		range.add(range2);
		range.add(range3);
		range.add(range4);
		cache = new RangeCache(range, 2);
		assertTrue(cache.hasNext());
		assertEquals(Arrays.asList(range1, range2), cache.next());
		assertTrue(cache.hasNext());
		assertEquals(Arrays.asList(range3, range4), cache.next());
		assertFalse(cache.hasNext());
	}

}
