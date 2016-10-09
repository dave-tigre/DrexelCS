/*
* Program demonstrates how to manipulate strings to produce a formmated output.
*
*
*
*/

#include <iostream>
#include <string>
#include <iomanip> //header file needed to manipulate output

using namespace std;
int main(){
	int pennies = 1;
	int nickels = 12;
	int dimes = 4;
	int quarters = 120;
	
	/*
	* fixed: sets the decimal precision to be fixed for all outputs
	* setprecision( int n ) sets the decimal precision output to be of integer n
	* setw( int n ) sets the column width by number of characters
	*/
	cout << fixed << setprecision(2);
	cout << setw(8) << pennies << " "
     		<< setw(8) << pennies * 0.01 << "\n";
  	cout << setw(8) << nickels << " "
     		<< setw(8) << nickels * 0.05 << "\n";
  	cout << setw(8) << dimes << " "
     		<< setw(8) << dimes * 0.10 << "\n";
  	cout << setw(8) << quarters << " "
		<< setw(8) << quarters * 0.25 << "\n";

	return 0;
}
