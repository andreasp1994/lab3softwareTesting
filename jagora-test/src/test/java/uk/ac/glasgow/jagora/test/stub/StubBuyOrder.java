package uk.ac.glasgow.jagora.test.stub;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;

public class StubBuyOrder implements BuyOrder{

	Trader trader;
	Stock stock;
	Integer quantity;
	Double price;
	
	public StubBuyOrder(Trader trader, Stock stock, Integer quantity, Double price) {
		this.trader = trader;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public Trader getTrader() {
		// TODO Auto-generated method stub
		return trader;
	}

	@Override
	public Stock getStock() {
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public Integer getRemainingQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void satisfyTrade(TickEvent<Trade> tradeEvent) throws TradeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollBackTrade(TickEvent<Trade> tradeEvent) throws TradeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(BuyOrder order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
