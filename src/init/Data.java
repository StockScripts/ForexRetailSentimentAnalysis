package init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Data {


	public int EURUSD, GBPUSD, NZDUSD, AUDUSD, USDJPY, DAX, SP, OIL, GOLD, USDCAD, EURGBP, EURCHF, EURAUD
	, BRENT, AUS200, FRA40, NAS100, US2000, US30, XAGUSD;
	
	public boolean data() {
		
		boolean result = true;
		
		try {
			
		  EURUSD = scrape("EURUSD");
		  GBPUSD = scrape("GBPUSD");
		  NZDUSD = scrape("NZDUSD");
		  AUDUSD = scrape("AUDUSD");
		  USDJPY = scrape("USDJPY");
		  USDCAD = scrape("USDCAD");
		  DAX = scrape("GER30");
		  SP = scrape("US500");
		  OIL = scrape("XTIUSD");
		  GOLD = scrape("XAUUSD");
		  EURGBP = scrape("EURGBP");
		  EURCHF = scrape("EURCHF");
		  EURAUD = scrape("EURAUD");
		  BRENT = scrape("XBRUSD");
		  AUS200 = scrape("AUS200");
		  FRA40 = scrape("FRA40");
		  NAS100 = scrape("NAS100");
		  US2000 = scrape("US2000");
		  US30 = scrape("US30");
		  XAGUSD = scrape("XAGUSD");
			
		} catch (Exception e) {
			// TODO: handle exception
			result = false;
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	public int scrape(String activo) {
		int resultado = 0;
		String dataline = "";
		String URLSt = "https://www.myfxbook.com/community/outlook/"+activo;
		try {
            URL url = new URL(URLSt);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
            	if(line.contains("%") && line.contains("<td>")) {
            		dataline = line;
            	}
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		dataline = dataline.replace("<td>","");
		dataline = dataline.replace("%</td>", "");
		dataline = dataline.replace(" ", "");
		resultado = Integer.valueOf(dataline);
		return resultado;
	}
	public int getEURUSD() {
		return EURUSD;
	}
	public int getGBPUSD() {
		return GBPUSD;
	}
	public int getNZDUSD() {
		return NZDUSD;
	}
	public int getAUDUSD() {
		return AUDUSD;
	}
	public int getUSDJPY() {
		return USDJPY;
	}
	public int getDAX() {
		return DAX;
	}
	public int getSP() {
		return SP;
	}
	public int getOIL() {
		return OIL;
	}
	public int getGOLD() {
		return GOLD;
	}
	public int getUSDCAD() {
		return USDCAD;
	}	
	public int getBRENT() {
		return BRENT;
	}
	public int getAUS200() {
		return AUS200;
	}
	public int getFRA40() {
		return FRA40;
	}
	public int getNAS100() {
		return NAS100;
	}
	public int getUS2000() {
		return US2000;
	}
	public int getUS30() {
		return US30;
	}
	public int getXAGUSD() {
		return XAGUSD;
	}
	public int getEURGBP() {
		return EURGBP;
	}
	public int getEURCHF() {
		return EURCHF;
	}
	public int getEURAUD() {
		return EURAUD;
	}
}
