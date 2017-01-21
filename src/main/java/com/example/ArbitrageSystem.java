package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RootObject;
@Service
public class ArbitrageSystem implements Arbitrage {
	static String name;
	static Stock stocktop[]=new Stock[5];
	static Integer number=0;
	
	public Stock[] stockInput(RootObject[] obj){
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
	    
	    stocktop=stock;
	    
	    for(int m=0;m<5;m++)
	    {
	    	System.out.println("top"+stocktop[m].getName());
	    }
	    
	    System.out.println("\nTop 5 reccomendations are:");
		 System.out.println("++++"+name);
		 System.out.println("arsys=====****..");
		 
		 //setNumber(5);
		 
		 //SaveHistory saveHistory= new SaveHistory();
		 //saveHistory.Shistory();
		 
	 return stocktop;
	
	 
	}
	/*public static void setName(String name) {
		ArbitrageSystem.name = name;
	}
	
	public Stock[] getStocktop() {
		return stocktop;
	}
	
	public void setStocktop(Stock[] stocktop) {
		this.stocktop = stocktop;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	*/
	public void nameOfUser(String uname)
	{
		name=uname;
	}

}