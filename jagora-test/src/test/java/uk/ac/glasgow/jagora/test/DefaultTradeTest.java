package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.SellOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;
import uk.ac.glasgow.jagora.World;
import uk.ac.glasgow.jagora.impl.DefaultTickEvent;
import uk.ac.glasgow.jagora.impl.DefaultTrade;
import uk.ac.glasgow.jagora.test.stub.StubBuyOrder;
import uk.ac.glasgow.jagora.test.stub.StubSellOrder;
import uk.ac.glasgow.jagora.test.stub.StubStock;
import uk.ac.glasgow.jagora.test.stub.StubTrader;
import uk.ac.glasgow.jagora.test.stub.StubWorld;

public class DefaultTradeTest {

	protected Trade trade;
	protected World world = StubWorld.world;
	
	protected Trader seller = StubTrader.seller;
	protected Trader buyer = StubTrader.buyer;
	
	protected BuyOrder buyOrder = new StubBuyOrder(buyer, StubStock.lemons, 10, 10.0);
	protected SellOrder sellOrder = new StubSellOrder(seller, StubStock.lemons, 12, 8.20);
	
	protected Stock stockLemons = StubStock.lemons;
	protected Stock stockApples = StubStock.apples;
	
	@Before
	public void setUp() throws Exception {
		trade = new DefaultTrade(world, buyOrder, sellOrder, stockLemons, 2, 8.20);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStock(){
		assertTrue("Trade does not return corrent stock", trade.getStock().getName().equals("lemons"));
	}
	
	@Test
	public void testGetQuantity(){
		assertTrue("Trade does not return quantity correctly", trade.getQuantity() == 2);
	}
	
	@Test
	public void testGetPrice(){
		assertTrue("Trade does not return price correcty", trade.getPrice() == 8.20);
	}

	@Test
	public void testExecute() throws Exception{
		assertTrue("Trade does not return correct tick event", trade.execute().equals(world.createTickEvent(trade)));
		assertFalse("trade's returned Tick event which is not unique", trade.execute().equals(new DefaultTickEvent<Trade>(trade, 50l)));
	}
	
	@Test(expected = TradeException.class)
    public void testNotMatchingPricesTrade() throws Exception{
		sellOrder = new StubSellOrder(seller, stockLemons, 10, 5.00);
		buyOrder = new StubBuyOrder(buyer, stockLemons, 10, 8.00);
		
		trade = new DefaultTrade(world, buyOrder, sellOrder, stockLemons, 10,5.00);
		trade.execute();
	}
	
	@Test(expected = TradeException.class)
	public void testNotMatchingStocksTrade() throws Exception{
		sellOrder = new StubSellOrder(seller, stockLemons, 10, 5.00);
		buyOrder = new StubBuyOrder(buyer, stockApples, 10, 10.00);
		
		trade = new DefaultTrade(world, buyOrder, sellOrder, stockLemons, 10, 5.00);
		
		trade.execute();
	}
	
	@Test(expected = TradeException.class)
	public void testZeroQuantityExecution() throws Exception{
		trade = new DefaultTrade(world, buyOrder, sellOrder, stockLemons, 0, 5.00);
		
		trade.execute();
	}
	
	@Test(expected = TradeException.class)
	public void testBadBuyOrder() throws Exception{
		trade = new DefaultTrade(world, null, sellOrder, stockLemons, 10, 5.00);
		trade.execute();
	}
	
	@Test(expected = TradeException.class)
	public void testBadSellOrder() throws Exception{
		trade = new DefaultTrade(world, buyOrder, null, stockLemons, 10, 5.00);
		trade.execute();
	}
}
