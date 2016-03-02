package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.World;
import uk.ac.glasgow.jagora.impl.DefaultWorld;
import uk.ac.glasgow.jagora.test.stub.StubStock;
import uk.ac.glasgow.jagora.test.stub.StubTickEventForWorld;
import uk.ac.glasgow.jagora.test.stub.StubTrade;

public class DefaultWorldTest {
	
	protected World world;
	
	protected Trade trade = new StubTrade(20, 10.0, StubStock.lemons);
	
	protected TickEvent<Trade> tickEvent = StubTickEventForWorld.tradeEvent;
	
	@Before
	public void setUp(){
		world = new DefaultWorld();
	}
	
	@After
	public void tearDown(){
		world = null;
		trade = null;
		tickEvent = null;
	}
	
	@Test
	public void testCreateTickEvent(){
		assertTrue("Tick events are not created properly!", world.createTickEvent(trade).equals(tickEvent));
	}
}
