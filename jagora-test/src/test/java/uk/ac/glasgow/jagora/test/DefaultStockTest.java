package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.impl.DefaultStock;

public class DefaultStockTest {

	protected Stock bananas;
	
	
	@Before
	public void setUp() throws Exception {
		bananas = new DefaultStock("bananas");
	}

	@After
	public void tearDown() throws Exception {
		bananas = null;
	}

	@Test
	public void test() {
		assertTrue("Stock name was returned incorrectly", bananas.getName().equals("bananas"));
	}

}
