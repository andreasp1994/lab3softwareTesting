package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.assertEquals;
import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;
import uk.ac.glasgow.jagora.impl.DefaultTrader;

public class DefaultTraderTest {
	
	protected Stock stock = lemons;
	protected Integer quantity = 100;
	protected Double cash = 1000.0;
	protected String name = "default";
	
	protected Trader trader;
	
	@Before
	public void setUp() throws Exception {
		this.trader = new DefaultTrader(name, cash, stock, quantity);
	}
	
	@Test
	public void testGetName (){
		assertEquals(name,trader.getName());
	}
	
	@Test
	public void testGetCash (){
		assertEquals(cash, trader.getCash(), 0.0);
	}

	@Test
	public void testGetInventoryHolding (){
		assertEquals(quantity.intValue(), trader.getInventoryHolding(stock).intValue());
	}
	
	@Test
	public void testGetTradingStocks (){
		Set<Stock> expected = new HashSet<Stock>();
		expected.add(stock);
		assertEquals(expected, trader.getTradingStocks());
	}
	
	@Test
	public void testBuyStock() throws Exception {
		Double initialCash = trader.getCash();
		Integer initialQuantity = trader.getInventoryHolding(stock);
		trader.buyStock(stock, 10, 50.0);
		assertEquals(initialCash - 500 , trader.getCash(), 0.0);
		assertEquals(initialQuantity + 10, trader.getInventoryHolding(stock).intValue());
	}
	
	@Test
	public void testSellStock() throws Exception {
		Double initialCash = trader.getCash();
		Integer initialQuantity = trader.getInventoryHolding(stock);
		trader.sellStock(stock, 10, 50.0);
		assertEquals(initialCash + 500.0, trader.getCash(), 0.0);
		assertEquals(initialQuantity - 10, trader.getInventoryHolding(stock).intValue());
	}
	
	@Test(expected=TradeException.class)
	public void testBadBuyStock()  throws Exception {
		trader.buyStock(stock, 2, cash);
	}
	
	@Test(expected=TradeException.class)
	public void testBadSellStock() throws Exception {
		trader.sellStock(stock, quantity+1, 1.0);
	}
}
