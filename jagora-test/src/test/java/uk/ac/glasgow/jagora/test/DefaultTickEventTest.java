package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.impl.DefaultTickEvent;
import uk.ac.glasgow.jagora.test.stub.StubStock;
import uk.ac.glasgow.jagora.test.stub.StubTrade;

public class DefaultTickEventTest {

	protected TickEvent<Trade> tickEvent;
	protected TickEvent<Trade> earlyTickEvent;
	protected TickEvent<Trade> lateTickEvent;
	protected Trade trade = new StubTrade(10, 5.0, StubStock.lemons);
	
	@Before
	public void setUp() throws Exception {
		tickEvent = new DefaultTickEvent<Trade>(trade, 20l);
		earlyTickEvent = new DefaultTickEvent<Trade>(trade, 1l);
		lateTickEvent = new DefaultTickEvent<Trade>(trade, 40l);
	}

	@After
	public void tearDown() throws Exception {
		earlyTickEvent = null;
		tickEvent = null;
		lateTickEvent = null;
		trade = null;
	}

	@Test
	public void getTickTest(){
		assertTrue("Tick getter from tick event object", tickEvent.getTick() == 20l);
	}
	
	@Test
	public void getEventTest(){
		assertTrue("Event getter from tick event object", tickEvent.getEvent().equals(trade));
	}

	@Test
	public void compareToTest(){
		assertTrue("compare should return > 0", tickEvent.compareTo(earlyTickEvent) > 0);
		assertTrue("Compare should return < 0", tickEvent.compareTo(lateTickEvent) < 0);
		assertTrue("Equality comparison should return true", tickEvent.compareTo(new DefaultTickEvent<Trade>(trade, 20l)) == 0);
	}
}
