import java.io.BufferedReader;
import java.io.FileReader;
/*
* @author: David Tigreros
* CS265 Section003 Lab8
* Csv.java
* Program parses csv data
*/

public class Csv {
	public static void main(String [] args) throws Exception{
		// BufferedReader & FileReader to parse the csv file
		BufferedReader input = new BufferedReader(new FileReader("./test.csv")); 
		String fieldLine = null; // variable to hold in entire field line
		int numOfLine = 0; // variable for the line number
		System.out.println();
		// reads input file until it no longer has any lines
		while(input.ready()){
			numOfLine++; // keeps track of what line it is on
			fieldLine = input.readLine(); // variable to hold current field
			// array to hold split parts of field line
			// delimiter with conditions to handle embedded quotes and commas
			String[] fieldSplit =
				fieldLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			// print line number
			System.out.println("Line: " + numOfLine);
			// print entire line to compare for correctness
			System.out.println(fieldLine);
			// iterate through array to show fields
			for(int i = 0; i < fieldSplit.length; i++){
				// print field num, and field 
				System.out.println("Field[" + i +
						"]  " + fieldSplit[i]);
			}
			System.out.println();
		}	
		input.close();
	}
}
