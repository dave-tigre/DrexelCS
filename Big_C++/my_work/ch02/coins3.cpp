#include <iostream>

// Running total with coins

using namespace std;

int main(){

	cout << "How many pennies do you have? ";
	int count;
	cin >> count;
	double total = count*0.01;
	
	cout << "How many nickels do you have? ";
	cin >> count;
	total = total + count*0.05;

	cout << "How many dimes do you have? ";
	cin >> count;
	total = total + count*0.1;

	cout << "How many quarters do you have? ";
	cin >> count;
	total = total + count*0.25;

	cout << "Total value = $" << total << endl;

	return 0;
}
