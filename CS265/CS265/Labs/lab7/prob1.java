/**
* @author:  David Tigreros
* CS265 Section003 Lab7
* Problem 1 from javaranch.com
* Print out a given string 100 times
 **/
public class prob1 {
		public static void main(String[] args) {
			String name = args[0];		
			for (int i = 0; i < 100; i++){
				System.out.print(name + " ");
			}
		}
}
