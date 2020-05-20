import java.util.ArrayList;
import java.util.Scanner;
public class CoronavirusUpdateMain  {
	
	public static boolean alCheck(String s, ArrayList<String> l){
	     for (String string : l){
	        if (string.equalsIgnoreCase(s)){
	            return true;
	         }
	     }
	    return false;
	  }
	
	public static void main(String []args) {

		Scanner input = new Scanner(System.in);
		
		Scrap sp = new Scrap();
		ArrayList<Country>countryData = sp.getCountryData();
		ArrayList<String>countries = sp.populateCountries();
		boolean flag = false;
		
		
		String inputCountry = null;
	
		while ( !flag ) {
			System.out.print("\nInput country: ");
			inputCountry = input.next();
			flag = alCheck(inputCountry, countries);
		}
		
		
		for ( int i = 0; i < countryData.size(); i++) {
			flag = countryData.get(i).getCountry().equalsIgnoreCase(inputCountry);
			if ( flag ) {
				System.out.println(countryData.get(i));
			}
		}
	
		
		
		
		

		input.close();
		
	}
}
