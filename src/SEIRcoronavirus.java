import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SEIRcoronavirus {

	
	public static double roundDouble( double d) {
		DecimalFormat df = new DecimalFormat("###.##");
		d = Double.parseDouble(df.format(d));
		return d;
		}
		public static void main(String []args) {
			
			// so I(t) = trans*Suscep*Infected - recovery*Infected
			// S(t) = -trans*Suscep*Infected 
			// R(t) = recovery*Infected
			DecimalFormat df = new DecimalFormat("00000000.00");
			double n = 329194645;;
			double iStart = 1;
			double sStart = n-iStart;
			double rStart = 0;
			double incubation = 5.8;	
			double recovery = 0.07; 	 // duration a person is infected before cured
			double rNought = 2.25;
			double trans = 0.000000015;	// daily number of close contact or transmission rate 
			int timeIncrement = 1;		// 0.15747 for http://jtd.amegroups.com/article/view/36385/html
										// 
			
		
			
			ArrayList <Double>sAL= new ArrayList<>();
			ArrayList <Double>iAL= new ArrayList<>();
			ArrayList <Double>rAL= new ArrayList<>();
			
			Scanner input = new Scanner(System.in);
			
			int runTime = 0;
			System.out.println("Input time to run SIR model: ");
			runTime = input.nextInt();
			
			double iEnd, sEnd, rEnd;
			sEnd = n - 1;
			sAL.add(sEnd);
			iEnd = 1;
			iAL.add(iEnd);
			rEnd = 0;
			rAL.add((double) 0);
			
			
			System.out.println(sAL.get(0) + " " + iAL.get(0) + " " + rAL.get(0) );
			runTime++;
			
				for ( int i = 1; i < runTime ; i++) {
					sEnd = sAL.get(i-1) - 	(trans*sAL.get(i-1)*iAL.get(i-1));
					sAL.add(sEnd);
					iEnd = (trans*sAL.get(i-1)*iAL.get(i-1)) - recovery*iAL.get(i-1) + iAL.get(i-1) ;
					iAL.add(iEnd);
				//	rEnd = rAL.get(0) + recovery*iAL.get(i-1);
					rEnd = n - sEnd - iEnd;
					rAL.add(rEnd);
					System.out.println(Math.round(sEnd) + " " + Math.round(iEnd) + " " + Math.round(rEnd));
				}	
			
	
		
			input.close();
		}
}
