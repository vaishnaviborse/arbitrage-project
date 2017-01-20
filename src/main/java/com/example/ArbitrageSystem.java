package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RootObject;
@Service
public class ArbitrageSystem implements Arbitrage {
	static String name;
	public void stockInput(RootObject[] obj){
		Stock stock[]=new Stock[49];
		int j=0,k=1;
		
		for(int i=0;i<=96;i=i+2)
		{
			stock[j]=new Stock(obj[i].getT(),obj[i].getL(),obj[k].getL(),obj[k].getLtDts());
			j++;
			k=k+2;
		}
	
	    Recommendation rec=new Recommendation();
	    rec.difference(stock);
	    
	    System.out.println("\nTop 5 reccomendations are:");
		 System.out.println("++++"+name);

	 rec.filter(name,stock,5);
	
	 
	}
	public void nameOfUser(String uname)
	{
		name=uname;
		 System.out.println("////////"+name);
	}
	
	

}