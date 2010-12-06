/**
 * 
 */
package net.sf.jranges.range.integer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import net.sf.jranges.range.integer.IntegerRange;
import net.sf.jranges.range.integer.IntegerRangeUtils;
import net.sf.jranges.range.integer.impl.DummyRange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-17
 *
 */
public class TestIntegerRangeUtils2 {
	
	private IntegerRange range1;
	private IntegerRange range2;
	private IntegerRange range3;
	private IntegerRange range4;

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
	 * Test method for {@link net.sf.jranges.range.integer.IntegerRangeUtils.range.impl.RangeUtils#positionFrequencies(java.util.Collection, java.util.Collection)}.
	 */
	@Test
	public final void testPositionFrequencies() {
		
	}

	/**
	 * Test method for {@link net.sf.jranges.range.integer.IntegerRangeUtils.range.impl.RangeUtils#medianPositionFrequencies(java.util.Collection, java.util.Collection)}.
	 */
	@Test
	public final void testMedianPositionFrequencies() {
		range1 = new DummyRange(1,10000);
		range2 = range1;
		assertEquals(1, IntegerRangeUtils.medianPositionFrequencies(Arrays.asList(range1), Arrays.asList(range2)),0);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.IntegerRangeUtils.range.impl.RangeUtils#medianPositionFrequencies(java.util.Collection, java.util.Collection)}.
	 */
	@Test
	public final void testMedianPositionFrequencies01() {
		range1 = new DummyRange(10001,20000);
		range2 = new DummyRange(1,100000);
		assertEquals(0.1, IntegerRangeUtils.medianPositionFrequencies(Arrays.asList(range1), Arrays.asList(range2)),0);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.IntegerRangeUtils.range.impl.RangeUtils#medianPositionFrequencies(java.util.Collection, java.util.Collection)}.
	 */
	@Test
	public final void testMedianPositionFrequencies02() {
		range1 = new DummyRange(10001,20000);
		range2 = new DummyRange(20001,30000);
		range3 = new DummyRange(1,100000);
		assertEquals(0.2, IntegerRangeUtils.medianPositionFrequencies(Arrays.asList(range1, range2), Arrays.asList(range3)),0);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.IntegerRangeUtils.range.impl.RangeUtils#medianPositionFrequencies(java.util.Collection, java.util.Collection)}.
	 */
	@Test
	public final void testMedianPositionFrequencies03() {
		range1 = new DummyRange(10001,20000);
		range2 = new DummyRange(20001,30000);
		range3 = new DummyRange(1,50000);
		range4 = new DummyRange(50001,100000);
		assertEquals(0.2, IntegerRangeUtils.medianPositionFrequencies(Arrays.asList(range1, range2), Arrays.asList(range3, range4)),0);
	}

}
