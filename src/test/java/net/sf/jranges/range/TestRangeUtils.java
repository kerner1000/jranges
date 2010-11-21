/**
 * 
 *
 */
package net.sf.jranges.range;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import net.sf.jranges.range.IntegerRange;
import net.sf.jranges.range.RangeUtils;
import net.sf.jranges.range.impl.DummyRange;
import net.sf.jranges.range.impl.DummyRangeFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-18
 * 
 */
public class TestRangeUtils {

	private List<IntegerRange> ranges;
//	private List<IntegerRange> ranges2;
//	private List<IntegerRange> ranges3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ranges = new ArrayList<IntegerRange>();

//		ranges2 = new ArrayList<IntegerRange>();
//
//		ranges3 = new ArrayList<IntegerRange>();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link net.sf.kerner.commons.range.impl.RangeUtils#includedByOne(java.util.List, int)}
	 * .
	 */
	@Test
	public final void testIncludedByOne() {
		ranges.add(new DummyRange(1, 2));
		ranges.add(new DummyRange(3, 4));
		ranges.add(new DummyRange(5, 6));
		ranges.add(new DummyRange(7, 8));
		assertTrue(RangeUtils.includedByOne(ranges, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.kerner.commons.range.impl.RangeUtils#includedByOne(java.util.List, int)}
	 * .
	 */
	@Test
	public final void testIncludedByOne01() {
		ranges.add(new DummyRange(1, 2));
		ranges.add(new DummyRange(3, 4));
		ranges.add(new DummyRange(5, 6));
		ranges.add(new DummyRange(7, 8));
		assertTrue(RangeUtils.includedByOne(ranges, 8));
	}

	/**
	 * Test method for
	 * {@link net.sf.kerner.commons.range.impl.RangeUtils#includedByOne(java.util.List, int)}
	 * .
	 */
	@Test
	public final void testIncludedByOne02() {
		ranges.add(new DummyRange(1, 2));
		ranges.add(new DummyRange(3, 4));
		ranges.add(new DummyRange(5, 6));
		ranges.add(new DummyRange(7, 8));
		assertFalse(RangeUtils.includedByOne(ranges, 0));
	}

	/**
	 * Test method for
	 * {@link net.sf.kerner.commons.range.impl.RangeUtils#includedByOne(java.util.List, int)}
	 * .
	 */
	@Test
	public final void testIncludedByOne03() {
		ranges.add(new DummyRange(1, 2));
		ranges.add(new DummyRange(3, 4));
		ranges.add(new DummyRange(5, 6));
		ranges.add(new DummyRange(7, 8));
		assertFalse(RangeUtils.includedByOne(ranges, -1));
	}

	/**
	 * Test method for
	 * {@link net.sf.kerner.commons.range.impl.RangeUtils#includedByOne(java.util.List, int)}
	 * .
	 */
	@Test
	public final void testIncludedByOne04() {
		ranges.add(new DummyRange(1, 2));
		ranges.add(new DummyRange(3, 4));
		ranges.add(new DummyRange(5, 6));
		ranges.add(new DummyRange(7, 8));
		assertFalse(RangeUtils.includedByOne(ranges, 9));
	}

	/**
	 * Test method for
	 * {@link net.sf.kerner.commons.range.impl.RangeUtils#merge(java.util.List, net.sf.kerner.commons.range.RangeFactory)}
	 * .
	 */
	@Test
	public final void testMerge() {
		ranges.add(new DummyRange(1, 2));
		ranges.add(new DummyRange(3, 4));
		ranges.add(new DummyRange(5, 6));
		ranges.add(new DummyRange(7, 8));
		assertEquals(new DummyRange(1, 8),
				RangeUtils.merge(ranges, new DummyRangeFactory()));
	}

	

	

}
