package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SaveHistory {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/save-history")
	public @ResponseBody Boolean Shistory()
	{		
		Stock[] stocktop=new Stock[5];

		stocktop=ArbitrageSystem.stocktop;
		String name=ArbitrageSystem.name;
		System.out.println("&&&&&&&&&&&&77"+stocktop[0].getName());
		Recommendation rec=new Recommendation();
		rec.filter(name,stocktop,5);
		
		return true;
		
	}
}
