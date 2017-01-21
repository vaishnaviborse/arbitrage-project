package com.example;

import java.text.DecimalFormat;

public class Recommendation {
	String username;
	DecimalFormat f = new DecimalFormat("00.0000");
	public void difference(Stock stock[]) 
	{
		Strategy strategy=new StratNsBs();
		int sl = stock.length;
		for(int i=0;i<sl;i++){
			strategy.calDiff(stock[i]);
		}
		Stock swap;
		for( int j=0;j<(sl-1);j++)
		{
			for(int k=0;k<(sl-j-1);k++)
			{
				if(stock[k].getDiff() < stock[k+1].getDiff()) /* For descending order use < */
		        {
			          swap = stock[k];
			         stock[k]   = stock[k+1];
			          stock[k+1] = swap;
		        }
			}
		}
		
		for(int i=0;i<stock.length;i++){
			System.out.println("The differnce of "+stock[i].getName()+" is: "+f.format(stock[i].getDiff())+" date & Time:"+stock[i].getDt());
		}
		
		
	}
	
	
	public void filter(String username,Stock stock[],Integer n)
	{	History history=new History();
		history.establish();

		System.out.println("\n\nHistory::");
		System.out.println("\n\nHistory username::"+username);
		System.out.println("\n\nHistory stock::"+stock[0].getName());
		System.out.println("\n\nHistory usernameNumber::"+n);
		for(int i=0;i<n;i++){
			System.out.println("The differnce of "+stock[i].getName()+" is: "+f.format(stock[i].getDiff()));
			history.setall(username,stock[i].getName(),stock[i].getNseValue(),stock[i].getBseValue(),stock[i].getHigher(),stock[i].getDiff(),stock[i].getDt());
			System.out.println("\n");
			System.out.println("filter****..");
			history.sethistory();
			}
		history.displayHistory();
		
	}

}
