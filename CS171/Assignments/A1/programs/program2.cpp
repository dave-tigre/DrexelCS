/*
* Author: DT
* Program calculates how to divide up a given amount of ounces.
*
*
*/

#include <iostream>

using namespace std;

int main(){

	// setting up constants
	const int TBS_PER_OUNCE = 2;
	const int OUNCES_PER_GILL = 4;
	const int OUNCES_PER_CUP = 2*OUNCES_PER_GILL;
	const int OUNCES_PER_PINT = 2*OUNCES_PER_CUP;
	const int OUNCES_PER_QUART = 2*OUNCES_PER_PINT;
	const int OUNCES_PER_GALLON = 4*OUNCES_PER_QUART;
	const int OUNCES_PER_BARREL = 42*OUNCES_PER_GALLON;

	cout << "How many fluid onces do you have? ";
	int ounces;
	cin >> ounces;

	//set up vars
	int original_ounces = ounces;
	int tablespoons = 0;
	int gills = 0;
	int cups = 0;
	int pints = 0;
	int quarts = 0;
	int gallons = 0;
	int barrels = 0;

	// conversions
	barrels = ounces/OUNCES_PER_BARREL;
	ounces -= barrels*OUNCES_PER_BARREL;
	gallons = ounces/OUNCES_PER_GALLON;
	ounces -= gallons*OUNCES_PER_GALLON;
	quarts = ounces/OUNCES_PER_QUART;
	ounces -= quarts*OUNCES_PER_QUART;
	pints = ounces/OUNCES_PER_PINT;
	ounces -= pints*OUNCES_PER_PINT;
	cups = ounces/OUNCES_PER_CUP;
	ounces -= cups*OUNCES_PER_CUP;
	gills = ounces/OUNCES_PER_GILL;
	ounces -= gills*OUNCES_PER_GILL;
	tablespoons = ounces*TBS_PER_OUNCE;


	// results
	cout << original_ounces << " fluid ounces can be divided into:" << endl;
	cout << barrels << " barrel(s)\n";
	cout << gallons << " gallon(s)\n";
	cout << quarts << " quart(s)\n";
	cout << pints << " pint(s)\n";
	cout << cups << " cup(s)\n";
	cout << gills << " gill(s)\n";
	cout << tablespoons << " tablespoon(s)\n";

	return 0;
}
