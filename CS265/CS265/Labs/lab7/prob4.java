import java.util.Date;
/**
* @author David Tigreros
* CS265 Section003 Lab7
* Problem 8 from javaranch.com
* returns the date in either millis, seconds, days, or the date
* dependent on user input.
**/
public class prob4 {
	public static void main(String[] args) {
		int option = Integer.parseInt(args[0]);
		Date date = new Date();
		String unit = null;
		long value = 0;
		switch(option){
			case 0: unit = "milliseconds"; value = date.getTime();
					 break;
			case 1: unit = "seconds"; value = date.getTime()/1000;
					break;
			case 2: unit = "days"; value = date.getTime()/1000/60/60/24;
					break;
			case 3: unit =  date.toString();
					break;  
		}
		if(option == 3){
			System.out.println("current date and time: " + unit);
		}
		else{
			System.out.println(unit + " since January 1, 1970: " + value);
		}
	}
}

