/**
* @author David Tigrero
* CS265 Section003 Lab7s
* Problem 2 from javaranch.com
* Program takes in an input and determines if number is even or odd
**/
public class prob2 {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);	
		if((num%2) == 0){
			System.out.println("even");
		}
		else{
			System.out.println("odd");
		}
	}
}
