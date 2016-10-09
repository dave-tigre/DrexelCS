/*
* Example 2
* Program demonstrates inheritance and passing by reference.
*
*/

#include <string>
#include <iostream>
#include <fstream>

using namespace std;

/*
* Read numbers from a file and finds the maximum value.
* @param in the input stream to read from.
* @return the maximum value or 0 if the file has no numbers.
*
* Demonstrates pass-by-refernce '(istream&)' because it is referencing the bits in
* that referenced address.
*/
double read_data(istream& in)
{
	double highest;
	double next;
	if (in >> next)
		highest = next;
	else
		return 0;

	while(in >> next)
	{
		if (next > highest)
			highest = next;
	}

	return highest;
}

int main()
{
	/*
	* Inheritance is shown with the streaming objects.
	* cin is from iostream and so is fstream.
	* the read_data is looking for istream which both of those inherit from.
	* since they are both from istream, they can both by used as input params
	* for the read_data function.
	*/
	double max;
	cout << "Do you want to read from a file? (y/n) ";
	string input;
	cin >> input;
	if (input == "y")
	{
		string filename;
		cout << "Please enter the name of the file: ";
		cin >> filename;

		ifstream infile;
		infile.open(filename.c_str());

		if (infile.fail())
		{
			cout << "Error opening " << filename << endl;
			return 0;
		}
		max = read_data(infile);
		infile.close();
	}
	else
	{
		max = read_data(cin);
	}

	cout << "The maximum value is " << max << endl;
	return 0;
}
