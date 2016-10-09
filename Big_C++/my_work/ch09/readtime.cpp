/*
* Examples from chapter 9
*
* Program demonstrates istringstream class
*
*/
#include <string>
#include <iostream>
#include <sstream>

using namespace std;


/*
* Converts an integer value to a string
* @param s an integer value
* @return the equivalent string
*/
string int_to_string(int n)
{
	outstringsteam outstr;
	outstr << n;
	return outstr.str();
}

/**
	Reads time from standard input in the format hh::mm or
	hh:mm am or hh::mm pm.
	@param hours filled with the hours
	@param minutes filled with the minutes
*/
void read_time(int& hours, int& minutes)
{
	string line;
	getline(cin, line);
	istringstream instr(line);
	
	instr >> hours;
	
	minutes = 0;

	char ch;
	instr.get(ch);
	
	if (ch == ':')
		instr >> minutes;
	else
		instr.unget();

	string suffix;
	instr >> suffix;

	if (suffix == "pm")
		hours = hours + 12;
}
