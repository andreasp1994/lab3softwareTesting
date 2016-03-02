package uk.ac.glasgow.jagora.test.stub;

import uk.ac.glasgow.jagora.Stock;

public class StubStock implements Stock {
	
	public static final Stock lemons = new StubStock ("lemons");
	public static final Stock apples = new StubStock("apples");
	
	private String name;
	
	public StubStock(String name){
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

}
