/**
 * 
 */
package net.sf.jranges.range.impl;

import static org.junit.Assert.*;

import net.sf.jranges.range.RangeException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-19
 *
 */
public class TestOnePositiveRange {
	
	private OnePositiveRange r1;
	private OnePositiveRange r2;

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
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int)}.
	 */
	@Test
	public final void testOnePositiveRangeIntInt() {
		r1 = new OnePositiveRange(1, 2);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testOnePositiveRangeIntInt01() {
		r1 = new OnePositiveRange(0, 2);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testOnePositiveRangeIntInt03() {
		r1 = new OnePositiveRange(-1, 2);
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int, int)}.
	 */
	@Test
	public final void testOnePositiveRangeIntIntInt() {
		r1 = new OnePositiveRange(1, 2, 1);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int, int)}.
	 */
	@Test
	public final void testOnePositiveRangeIntIntInt01() {
		r1 = new OnePositiveRange(1, 7, 3);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testOnePositiveRangeIntIntInt02() {
		r1 = new OnePositiveRange(1, 6, 3);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.OnePositiveRange#OnePositiveRange(int, int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testOnePositiveRangeIntIntInt03() {
		r1 = new OnePositiveRange(1, 8, 3);
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		r1 = new OnePositiveRange(1, 2);
		r2 = new OnePositiveRange(1, 2);
		assertEquals(r1, r2);
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject01() {
		r1 = new OnePositiveRange(1, 2);
		r2 = new OnePositiveRange(1, 3);
		assertNotSame(r1, r2);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject02() {
		r1 = new OnePositiveRange(1, 2);
		r2 = new OnePositiveRange(1, 5, 2);
		assertNotSame(r1, r2);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject03() {
		r1 = new OnePositiveRange(1, 5, 2);
		r2 = new OnePositiveRange(1, 5, 2);
		assertEquals(r1, r2);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#getInterval()}.
	 */
	@Test
	public final void testGetInterval() {
		r1 = new OnePositiveRange(1, 5, 2);
		assertEquals(2, r1.getInterval());
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#getInterval()}.
	 */
	@Test
	public final void testGetInterval01() {
		r1 = new OnePositiveRange(1, 4);
		assertEquals(1, r1.getInterval());
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#shift(int)}.
	 */
	@Test
	public final void testShift() {
		r1 = new OnePositiveRange(4, 8);
		assertEquals(new OnePositiveRange(3,7), r1.shift(-1));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#shift(int)}.
	 */
	@Test
	public final void testShift01() {
		r1 = new OnePositiveRange(4, 8);
		assertEquals(new OnePositiveRange(5,9), r1.shift(1));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#shift(int)}.
	 */
	@Test
	public final void testShift02() {
		r1 = new OnePositiveRange(4, 8);
		assertEquals(new OnePositiveRange(4,8), r1.shift(0));
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#expandRange(int)}.
	 */
	@Test
	public final void testExpandRangeInt() {
		r1 = new OnePositiveRange(4, 8);
		assertEquals(new OnePositiveRange(3,9), r1.expandRange(1));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#expandRange(int)}.
	 */
	@Test
	public final void testExpandRangeInt01() {
		r1 = new OnePositiveRange(4, 8);
		assertEquals(new OnePositiveRange(5,7), r1.expandRange(-1));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#expandRange(int)}.
	 */
	@Test
	public final void testExpandRangeInt02() {
		r1 = new OnePositiveRange(4, 8);
		assertEquals(new OnePositiveRange(4,8), r1.expandRange(0));
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#expandRange(int, boolean)}.
	 */
	@Test(expected=RangeException.class)
	public final void testExpandRangeIntBoolean() {
		r1 = new OnePositiveRange(1, 8);
		r1.expandRange(2, false);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#expandRange(int, boolean)}.
	 */
	@Test
	public final void testExpandRangeIntBoolean01() {
		r1 = new OnePositiveRange(1, 8);
		assertEquals(new OnePositiveRange(1,10), r1.expandRange(2, true));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#expandRange(int, boolean)}.
	 */
	@Test
	public final void testExpandRangeIntBoolean02() {
		r1 = new OnePositiveRange(4, Integer.MAX_VALUE);
		assertEquals(new OnePositiveRange(2,Integer.MAX_VALUE), r1.expandRange(2, true));
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#includes(int)}.
	 */
	@Test
	public final void testIncludes() {
		r1 = new OnePositiveRange(1, 8);
		assertTrue(r1.includes(1));
		assertTrue(r1.includes(2));
		assertTrue(r1.includes(7));
		assertTrue(r1.includes(8));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#includes(int)}.
	 */
	@Test
	public final void testIncludes01() {
		r1 = new OnePositiveRange(1, 8);
		assertFalse(r1.includes(0));
		assertFalse(r1.includes(9));
		assertFalse(r1.includes(-1));
		assertFalse(r1.includes(10));
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#getLimit1()}.
	 */
	@Test
	public final void testGetLimit1() {
		r1 = new OnePositiveRange(1, 8);
		assertEquals(1, r1.getLimit1());
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#getLimit1()}.
	 */
	@Test
	public final void testGetLimit101() {
		r1 = new OnePositiveRange(2, 8);
		assertEquals(1, r1.getLimit1());
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.AbstractIntegerRange#getLimit2()}.
	 */
	@Test
	public final void testGetLimit2() {
		r1 = new OnePositiveRange(2,8);
		assertEquals(Integer.MAX_VALUE, r1.getLimit2());
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		r1 = new OnePositiveRange(2,8);
		r2 = new OnePositiveRange(2,8);
		assertEquals(r1.hashCode(), r2.hashCode());
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#hashCode()}.
	 */
	@Test
	public final void testHashCode01() {
		r1 = new OnePositiveRange(2,8);
		r2 = new OnePositiveRange(2,9);
		assertNotSame(r1.hashCode(), r2.hashCode());
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#hashCode()}.
	 */
	@Test
	public final void testHashCode02() {
		r1 = new OnePositiveRange(2,8,2);
		r2 = new OnePositiveRange(2,8,2);
		assertEquals(r1.hashCode(), r2.hashCode());
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#hashCode()}.
	 */
	@Test
	public final void testHashCode03() {
		r1 = new OnePositiveRange(2,8,3);
		r2 = new OnePositiveRange(2,8,1);
		assertNotSame(r1.hashCode(), r2.hashCode());
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#toString()}.
	 */
	@Test
	@Ignore
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#getStart()}.
	 */
	@Test
	public final void testGetStart() {
		r1 = new OnePositiveRange(2,8,3);
		assertEquals(2, r1.getStart());
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#getStop()}.
	 */
	@Test
	public final void testGetStop() {
		r1 = new OnePositiveRange(2,8,3);
		assertEquals(8, r1.getStop());
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#getLength()}.
	 */
	@Test
	@Ignore("TODO")
	public final void testGetLength() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#compareTo(net.sf.jranges.range.IntegerRange)}.
	 */
	@Test
	public final void testCompareTo() {
		r1 = new OnePositiveRange(2,8,3);
		r2 = new OnePositiveRange(2,8);
		assertEquals(0, r1.compareTo(r2));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#compareTo(net.sf.jranges.range.IntegerRange)}.
	 */
	@Test
	public final void testCompareTo01() {
		r1 = new OnePositiveRange(2,8);
		r2 = new OnePositiveRange(2,9);
		
		// compareTo compares start positions (not length)!!
		
		assertEquals(0, r1.compareTo(r2));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#compareTo(net.sf.jranges.range.IntegerRange)}.
	 */
	@Test
	public final void testCompareTo02() {
		r1 = new OnePositiveRange(2,8,3);
		r2 = new OnePositiveRange(2,9);
		
		// compareTo compares start positions (not length)!!
		
		assertEquals(0, r1.compareTo(r2));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#compareTo(net.sf.jranges.range.IntegerRange)}.
	 */
	@Test
	public final void testCompareTo03() {
		r1 = new OnePositiveRange(2,8,3);
		r2 = new OnePositiveRange(1,9);
		assertEquals(1, r1.compareTo(r2));
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.impl.DummyRange#compareTo(net.sf.jranges.range.IntegerRange)}.
	 */
	@Test
	public final void testCompareTo04() {
		r1 = new OnePositiveRange(1,8);
		r2 = new OnePositiveRange(2,9);
		assertEquals(-1, r1.compareTo(r2));
	}

}
