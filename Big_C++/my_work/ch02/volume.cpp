#include <iostream>

/*
* Program demonstrates the use of constants 
*
*/

using namespace std;

int main(){
	
	double bottles;
	cout << "How many bottles do you have? ";
	cin >> bottles;

	double cans;
	cout << "How many cans do you have? ";
	cin >> cans;

	const double BOTTLE_VOLUME = 2.0; // constant var for volume of bottle in liters
	const double CAN_VOLUME = 0.355; // constant var for volume of cans in liters

	double total = bottles * BOTTLE_VOLUME + cans * CAN_VOLUME;
	
	cout << "Total volume is " << total << " liters.\n";
	return 0;
}
