/**
 * 
 */
package net.sf.jranges.range.integer.impl;

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
 * @version 2010-12-08
 *
 */
public class TestZeroPositiveRange {

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
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int)}.
	 */
	@Test
	public final void testZeroPositiveRangeIntInt() {
		new ZeroPositiveRange(0, 5);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int)}.
	 */
	@Test
	public final void testZeroPositiveRangeIntInt01() {
		new ZeroPositiveRange(0, Integer.MAX_VALUE);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int)}.
	 */
	@Test
	public final void testZeroPositiveRangeIntInt02() {
		new ZeroPositiveRange(34, Integer.MAX_VALUE);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testZeroPositiveRangeIntInt03() {
		new ZeroPositiveRange(-1, Integer.MAX_VALUE);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testZeroPositiveRangeIntInt04() {
		new ZeroPositiveRange(-1, 1);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int)}.
	 */
	@Test
	public final void testZeroPositiveRangeIntInt05() {
		new ZeroPositiveRange(0, 0);
	}

	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int, int)}.
	 */
	@Test
	public final void testZeroPositiveRangeIntIntInt() {
		new ZeroPositiveRange(0, 0, 1);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int, int)}.
	 */
	@Test
	public final void testZeroPositiveRangeIntIntInt01() {
		new ZeroPositiveRange(0, 8, 2);
	}
	
	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#ZeroPositiveRange(int, int, int)}.
	 */
	@Test(expected=RangeException.class)
	public final void testZeroPositiveRangeIntIntInt02() {
		new ZeroPositiveRange(0, 9, 2);
	}

	/**
	 * Test method for {@link net.sf.jranges.range.integer.impl.ZeroPositiveRange#newInstange(int, int, int, int)}.
	 */
	@Test
	@Ignore("delegate to constructor")
	public final void testNewInstangeIntIntIntInt() {
		fail("Not yet implemented"); // TODO
	}

}