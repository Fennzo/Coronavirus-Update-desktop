import java.io.IOException;
import javafx.application.Application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jsoup.Jsoup;

public class coronavirusMain extends Application {
	
	
	public static void main(String [] args) {
		
	//	launch(args);
		
		
		try {
			Document doc = Jsoup.connect("https://www.cdc.gov/coronavirus/2019-ncov/cases-updates/cases-in-us.html").userAgent("Mozilla/17.0").get(); //Basic syntax to conenct to the website and use Mozilla to tell the website the request is coming from a brower ( user agent )
			Elements temp = doc.select("span.count"); // Fetching all div elements undr the div callout class
			String words = temp.text();
			String[]arr = words.split(" ");
			for ( int i = 0; i < arr.length; i++ ) {
				arr[i] = arr[i].replaceAll(",","");
			}

			int total = Integer.parseInt(arr[0]);
			int newCase = Integer.parseInt(arr[1]);
			
			System.out.println("Total number of people infected in the United states: " + total );
			System.out.println("New cases: " + newCase );
			
			Document doc1 = Jsoup.connect("https://www.census.gov/popclock/data/population.php/us?date=20200511&_=1589276543790").userAgent("Mozilla/17.0").get();
			Elements temp1= doc1.select("body");	
			String usPop = temp1.text();
			String[]arr1 = usPop.split("\\D+");
			System.out.println(arr1[1]);
			double usPopulation = Integer.parseInt(arr1[1]);
			
			System.out.println("The United States population: " + usPopulation);
			
			int initialPop = 0;
			double incubation = 6.4;
			int averageRecovery = 14;
			double rNought = 2.25;	
			double duration = 0;
			double beta = rNought/(initialPop*duration); 
			
		
			
		} catch (IOException e) {
			System.out.print("Website error");
		}
		

	 Application.launch(mainController.class, args); // launch the fx
		
		
	}



}
