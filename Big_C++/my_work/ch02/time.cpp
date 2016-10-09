#include "../../book_examples/bigc2code/cccfiles/ccc_time.cpp"
#include <iostream>

/*
* Program demonstrates using objects.
* Time object was given
*
*/

using namespace std;

int main(){
	Time wake_up(7,0,0);
	wake_up.add_seconds(1000); // a thousand seconds later
	cout << wake_up.get_hours() << ":" << wake_up.get_minutes()
		<< ":" << wake_up.get_seconds() << endl;
	Time now;
	int seconds_left = Time(23,59,59).seconds_from(now);
	cout << "There are " << seconds_left << " seconds left in this day.\n";

	return 0;
}
