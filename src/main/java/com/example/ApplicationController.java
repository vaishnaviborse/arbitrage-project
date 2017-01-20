package com.example;

//import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

@RestController
public class ApplicationController {
	@Autowired
		RestTemplate restTemplate;
	
	@Autowired
		Arbitrage arbitrage;
	
	@RequestMapping(value = "/get-acc-data", method = RequestMethod.GET)
	public RootObject[] getLivedata() {
		String liveData = restTemplate.getForObject("http://finance.google.com/finance/info?q=NSE:ACC,BSE:500410,NSE:ADANIPORTS,BSE:532921,NSE:AMBUJACEM,BSE:500425,NSE:ASIANPAINT,BSE:500820,NSE:AXISBANK,BSE:532215,"
				+ "NSE:BAJAJ-AUTO,BSE:532977,NSE:BANKBARODA,BSE:532134,NSE:BHEL,BSE:500103,NSE:BPCL,BSE:500547,NSE:BHARTIARTL,BSE:532454,NSE:BOSCHLTD,BSE:500530,"
				+"NSE:CAIRN,BSE:532792,NSE:CIPLA,BSE:500087,NSE:COALINDIA,BSE:533278,"
				+ "NSE:DRREDDY,BSE:500124,"
				+ "NSE:GAIL,BSE:532155,NSE:GRASIM,BSE:500300,"
				+ "NSE:HCLTECH,BSE:532281,NSE:HDFCBANK,BSE:500180,NSE:HEROMOTOCO,BSE:500182,NSE:HINDALCO,BSE:500440,NSE:HINDUNILVR,BSE:500696,NSE:HDFC,BSE:500010,"
				+ "NSE:ICICIBANK,BSE:532174,NSE:IDEA,BSE:532822,NSE:INDUSINDBK,BSE:532187,NSE:INFY,BSE:500209,NSE:ITC,BSE:500875,"
				+ "NSE:KOTAKBANK,BSE:500247,"
				+ "NSE:LT,BSE:500510,NSE:LUPIN,BSE:500257,"
				+ "NSE:MARUTI,BSE:532500,"
				+ "NSE:NTPC,BSE:532555,"
				+ "NSE:ONGC,BSE:500312,"
				+ "NSE:POWERGRID,BSE:532898,NSE:PNB,BSE:532461,"
				+ "NSE:RELIANCE,BSE:500325,"
				+ "NSE:SBIN,BSE:500112,NSE:SUNPHARMA,BSE:524715,"
				+ "NSE:TCS,BSE:532540,NSE:TATAMOTORS,BSE:500570,NSE:TATAPOWER,BSE:500400,NSE:TATASTEEL,BSE:500470,NSE:TECHM,BSE:532755,"
				+ "NSE:ULTRACEMCO,BSE:532538,"
				+ "NSE:VEDL,BSE:500295,"
				+ "NSE:WIPRO,BSE:507685,NSE:YESBANK,BSE:532648,NSE:ZEEL,BSE:505537,NSE:M&M,BSE:500520", String.class);
		
		String resultAsJsonString = liveData.substring(3);
		
		Gson gsonMapper = new Gson();
		RootObject[] liveDataArray  =gsonMapper.fromJson(resultAsJsonString, RootObject[].class);
		
		arbitrage.stockInput(liveDataArray);
		
		return liveDataArray;
	}
	@Bean
	public RootObject rootObjec() {
		return new RootObject();
	}
	

}
