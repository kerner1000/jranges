package net.sf.jranges.range.doublerange.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.sf.jranges.range.doublerange.DoubleRange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestRangeDoubleUtils {

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

	@Test
	public final void testSplit01() {
		DoubleRange range = new DummyDoubleRange(0, 10);
		List<? extends DoubleRange> result = RangeDoubleUtils.split(range, 2, new FactoryRangeDoubleZeroPositive());
		assertEquals(10, result.size());
	}
	
	@Ignore
	@Test
	public final void testSplit02() {
		DoubleRange range = new ZeroPositiveDoubleRange(0, 10, 0.2);
		List<? extends DoubleRange> result = RangeDoubleUtils.split(range, 2, new FactoryRangeDoubleZeroPositive());
		System.out.println(result);
	}

}
