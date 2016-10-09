/*
* Author: DT
* Program 1
*
* Calculate the how much gasoline is needed for a particular long distance trup in a chevy camaro.
* Return:
	the FE, total number of gallons consumed, and total cost of the consumed gas.
*/

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

/*
* Method to calculate fuel efficiency of a chevy camaro
* s: speed of the car in miles per hour
* returns the fuel_efficiency
*/
double fuel_efficiency(double s){
	double FE = 71.7 *s * pow( (2+0.0192*s), -4.5) + exp((-5.1*s)) - 1;
	return FE;
}

int main(){
	cout << "What is the average speed driven during a trip (MPH)?: ";
	double avg_speed;
	cin >> avg_speed;

	cout << "What is the distance traveled (miles)?: ";
	double distance;
	cin >> distance;
	
	cout << "What is the cost of gasoline (dollars/gallon)?: ";
	double cost_gas;
	cin >> cost_gas;
	
	double FE = fuel_efficiency(avg_speed);
	double gallons = (1/FE)*distance;
	double total_cost = gallons*cost_gas;

	cout << fixed << setprecision(2);
	cout << setw(8) << "FE" << setw(8) << "Gallons" << setw(8) << "Cost" << endl;
	cout << setw(8) << FE << setw(8) << gallons << setw(8) << total_cost << endl;

	return 0;
	
	
}
