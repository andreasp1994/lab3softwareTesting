package uk.ac.glasgow.jagora.test.stub;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;

public class StubTrade implements Trade{


	private Stock stock;
	private Integer quantity;
	private Double price;
	
	public StubTrade(Integer quantity, Double price, Stock stock) {
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public Stock getStock() {
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public Integer getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public TickEvent<Trade> execute() throws TradeException {
		// TODO Auto-generated method stub
		return null;
	}

}
