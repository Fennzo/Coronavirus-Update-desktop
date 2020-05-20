import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scrap {
	
	final static String url = "https://www.worldometers.info/coronavirus/";
	
	public ArrayList<Country> getCountryData(){
		ArrayList<Country>countryData = new ArrayList<Country>();
		try {
		
             Document doc = Jsoup.connect(url).get();
             Elements table = doc.select("#main_table_countries_today");
             Elements rows = table.select("tbody").select("tr");
             int idx = 0;
             for (Element row : rows) {
                 Elements eachCountry = row.select("td");
                 Country curr = new Country();
                 curr.setId(idx++);
                 curr.setCountry(eachCountry.get(1).text());            
                 curr.setTotalCases(eachCountry.get(2).text());
                 curr.setNewCases(eachCountry.get(3).text());
                 curr.setTotalDeaths(eachCountry.get(4).text());
                 curr.setNewDeaths(eachCountry.get(5).text());
                 curr.setTotalRecovered(eachCountry.get(6).text());
                 curr.setActiveCases(eachCountry.get(7).text());
                 curr.setSeriousCases(eachCountry.get(8).text());
                 curr.setTotalCasesPerMillionPop(eachCountry.get(9).text());
                 curr.setTotalDeathsPerMillionPop(eachCountry.get(10).text());
                 curr.setTotalTests(eachCountry.get(11).text());
                 curr.setTestsPerMillion(eachCountry.get(12).text());
                 curr.setPop(eachCountry.get(13).text());                
                 countryData.add(curr);
              
             }}
	
             catch (IOException e) {
	             e.printStackTrace();
	         }
		return countryData;
	}
	

	
public static  boolean checker ( String str ) {
		
		List<String> valid = Arrays.asList("Europe","Asia","Africa","Australia/Oceania","South America", "North America" );
				return valid.contains(str);
				
	}



    
    public ArrayList<String> populateCountries() {
    	ArrayList<String>al = new ArrayList<String>();
    	   try {
    		   
    	        Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/countries-where-coronavirus-has-spread/").get();
    	        Elements tr = doc.select("tr");
    	        System.out.println("Country List: ");
    	       for (int i = 0; i < tr.size(); i++) { 
    	    	   Element row = tr.get(i); 
    	    	   Elements columns = row.select("td"); 
    	    	   if (columns.size() == 0) { } 
    	    	   for (int j = 0; j < columns.size(); j++) { 
    	    		   Element currentTd = columns.get(j); 
    	    		   String temp = currentTd.text();
    	    		     if ( !checker(temp) && temp.matches("[^\\d]+")) {
    	    		    	 System.out.println(temp);
    	    		    	 al.add(temp);
    	    		   }}
    	       }
    	        return al;
    	    }
    	    
    	    
    	    
    	    catch(Exception e) {
    	    	
    	    	return null;
    	    }
    }
	
}
