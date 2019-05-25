package init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Data {


	public int EURUSD, GBPUSD, NZDUSD, AUDUSD, USDJPY, DAX, SP, OIL, GOLD, USDCAD;
	
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
}
