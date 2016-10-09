/*
* Problem 2.5
* Wirte a program that prompts the user for a radius and then prints
* The area and circumference of a circle with given radius
* The surface area and volume of a sphere with given radius
*/

#include <iostream>
#include <cmath>

using namespace std;

int main(){
	cout << "Input a radius : ";
	double radius; // variable for given radius
	cin >> radius;
 
	const double PI = 3.1459265359; //constant for value of pi
	
	double circumference = 2*PI*radius;
	double circ_area = PI*radius*radius;
	
	double surface_area = 4*PI*radius*radius;
	double volume = (4/3)*PI*pow(radius,3); 

	cout << "Circular Area: " << circ_area << " Circumference: " << circumference << endl;
	cout << "Surface Area: " << surface_area << " Volume: " << volume << endl;
	
	return 0;
}
