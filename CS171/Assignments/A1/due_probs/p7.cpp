/*
* Problem 2.7
* Write a program that prompts the user for 
* the lenfths of the two sides of a triangle
* The sze of the angle between the two sides (in degrees)
*
* returns the length of the third size
* the sizes of the other two angles
*
*/

#include <iostream>
#include <cmath>

using namespace std;


const double PI = 3.145926535;

double deg2rad(double a){
	double rad = (a*PI)/180;
	return rad;
}

double rad2deg(double a){
	double deg = (a*180)/PI;
	return deg;
}

int main(){
	cout << "What is the length of two sides of a triangle?: ";
	double side1, side2;
	cin >> side1 >> side2;

	cout << "What is the size of the angle in between the two sides?: ";
	double angle3;
	cin >> angle3;
	angle3 = deg2rad(angle3);

	double side3 = sqrt( (side1*side1) + (side2*side2) - (2*side1*side2) * cos(angle3) );
	double angle2 = acos( ( (side2*side2) - (side3*side3) - (side1*side1) )/( -2*side2*side3));
	angle2 = rad2deg(angle2);
	angle3 = rad2deg(angle3);
	
	double angle1 = 180 - (angle2+angle3);

	cout << "Length of side3 = " << side3 << endl;
	cout << "A1 = " << angle3 << " A2 = " << angle2 << " A3 = " << angle3 << endl;
	return 0; 
}
