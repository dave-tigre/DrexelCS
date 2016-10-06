/**
* @author David Tigreros
* CS265 Section003 Lab7
* Problem 3 from javaranch.com
* Determines if a given year is a leap year
**/
public class prob3 {
	public static void main(String[] args) {
		int year = Integer.parseInt(args[0]);
		boolean leap = false;
		if(year % 4 == 0){
				if(year % 100 == 0){
					if(year % 400 == 0){
						leap = false;
					}
					leap = true;
				}
				leap = true;
		}
		else{
			leap = false;
		}
		if (leap){
			System.out.println("leap year!");
		}
		else{
			System.out.println("not a leap year!");
		}
	}
}
