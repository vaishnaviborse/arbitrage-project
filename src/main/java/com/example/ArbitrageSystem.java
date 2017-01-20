package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RootObject;
@Service
public class ArbitrageSystem implements Arbitrage {
	static String name;
	public Stock[] stockInput(RootObject[] obj){
		Stock stock[]=new Stock[49];
		Stock stocktop[]=new Stock[5];
		int j=0,k=1;
		
		for(int i=0;i<=96;i=i+2)
		{
			stock[j]=new Stock(obj[i].getT(),obj[i].getL(),obj[k].getL(),obj[k].getLtDts());
			j++;
			k=k+2;
		}
	
	    Recommendation rec=new Recommendation();
	    rec.difference(stock);
	    
	    stocktop=stock;
	    
	    for(int m=0;m<5;m++)
	    {
	    	System.out.println("top"+stocktop[m].getName());
	    	/*stocktop[m].setBseValue(stock[m].getBseValue());
	    	stocktop[m].setNseValue(stock[m].getNseValue());
	    	stocktop[m].setDiff(stock[m].getDiff());
	    	stocktop[m].setHigher(stock[m].getHigher());
	    	stocktop[m].setName(stock[m].getName());
	    	stocktop[m].setDt(stock[m].getDt());*/
	    }
	    
	    System.out.println("\nTop 5 reccomendations are:");
		 System.out.println("++++"+name);

	 rec.filter(name,stock,5);
	 return stocktop;
	
	 
	}
	public void nameOfUser(String uname)
	{
		name=uname;
	}
	
	

}