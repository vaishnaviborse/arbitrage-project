package com.example;

public class StratNsBs implements Strategy {

	@Override
	public void calDiff(Stock stock) {
		// TODO Auto-generated method stub
		if(stock.getBseValue() > stock.getNseValue())
		{
			Double diff=(stock.getBseValue() - stock.getNseValue()) ;
			stock.setDiff(diff);
			stock.setHigher("BSE");
		}
		else if (stock.getBseValue() < stock.getNseValue()){
			Double diff=(stock.getNseValue()-stock.getBseValue() ) ;
			stock.setDiff(diff);
			stock.setHigher("NSE");
		}
		else
			stock.setDiff(0.0);
			
		
	}
	

}
