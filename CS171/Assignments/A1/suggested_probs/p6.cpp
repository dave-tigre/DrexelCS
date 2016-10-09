/*
* Problem 2.6
* Write a program that asks the user for the lengths of the sides of a 
* rectangle.
* return the area and perimter of the rectangle
* return the length of the diagonal
*
*/

#include <iostream>
#include <cmath>

using namespace std;

int main(){
	cout << "Enter the width of the rectangle: ";
	double width;
	cin >> width;

	cout << "Enter the height of the rectangle: ";
	double height;
	cin >> height;

	double area = width*height;
	double perimeter = (2*width) + (2*height);

	double diagonal = sqrt( (width*width) + (height*height) );

	cout << "Area: " << area << endl;
	cout << "Perimeter: " << perimeter << endl;
	cout << "Diagonal: " << diagonal << endl;

	return 0;
}
