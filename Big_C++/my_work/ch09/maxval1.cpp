/*
* Example from chapter 9
*
* Demonstrates how to use file streaming.
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

/*
* Reads number from a files and finds the maximum value.
* @param in : the input stream to read from.
* @return the maximum value, or '0' if the file has no numbers
*
*/
double read_data(ifstream& in)
{
	double highest; //var for highest value
	double next; //var for next value

	//if the file has an int at line, make it the current highest
	if(in >> next)
		highest = next;
	else
		return 0;

	// while there are more lines, compare to highest value
	while (in >> next){
		// if current line is higher than current highest, swap
		if (next > highest)
			highest = next;
	}

	return highest;
}

int main(){
	// enter file name
	cout << "Please enter the data file name: ";
	string filename;
	cin >> filename;

	// set up file
	ifstream infile;
	infile.open(filename.c_str());

	//if state of infile is fail, error no file or trouble opening, exit error
	if(infile.fail()){
		cout << "Error opening " << filename << "\n";
		return 1;
	}

	// use function to find the highest value
	double max = read_data(infile);
	cout << "The maximum value is " << max << endl;

	infile.close(); //close the file
	return 0;
}
