/*
* Extra Credit Problem

* Compute the time in different cities based on the current time in Philadlephia
*
*/

#include <iostream>
#include <iomanip>

using namespace std;

// function to determine time in other given city
int city_time(int time, int difference){
	int city_time = time + difference;
	if (city_time > 2359){
		city_time -= 2400;	
	}
	else if (city_time < 0){
		city_time += 2400;
	}

	return city_time;
}
	
int main(){
	// time difference of other cities compared to philadelphia
	const int HONOLULU_TIME = -600;
	const int SEATTLE_TIME = -300;
	const int LONDON_TIME = 500;
	const int MOSCOW_TIME = 800;
	const int HONGKONG_TIME = 1200;
	const int AUKLAND_TIME = 1700;

	cout << "What is the current time in Philadelphia? ";
	int philly_time;
	cin >> philly_time;

	//set up variables;
	int honolulu_time;
	int seattle_time;
	int london_time;
	int moscow_time;
	int hongkong_time;
	int aukland_time;
	
	// calculate time in other cities
	honolulu_time = city_time(philly_time, HONOLULU_TIME);
	seattle_time = city_time(philly_time, SEATTLE_TIME);
	london_time = city_time(philly_time, LONDON_TIME);
	moscow_time = city_time(philly_time, MOSCOW_TIME);
	hongkong_time = city_time(philly_time, HONGKONG_TIME);
	aukland_time = city_time(philly_time, AUKLAND_TIME);

	//results
	cout << "Current times in other cities: \n";
	cout << "Honolulu:   " << setfill('0') << setw(4) << honolulu_time << endl;
	cout << "Seattle:    " << setfill('0') << setw(4) << seattle_time << endl;
	cout << "London:     " << setfill('0') << setw(4) << london_time << endl;
	cout << "Moscow:     " << setfill('0') << setw(4) << moscow_time << endl;
	cout << "Hong Kong:  " << setfill('0') << setw(4) << hongkong_time << endl;
	cout << "Aukland:    " << setfill('0') << setw(4) << aukland_time << endl;

	return 0;
}
