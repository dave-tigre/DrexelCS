/*
* Author: DT
* Problem 2.3
* Write a program that displays the squares, cubes, and fourth powers of the numbers 1 through 5.
*/

#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

int main(){
	int end = 5;
	cout << setw(8) << "num" << setw(8) <<"sqr" << setw(8) << "cube" << setw(8) << "fourth" << endl;
	for(int i = 1; i != end+1; i++){
		cout << setw(8) << i << setw(8) << i*i 
			<< setw(8) << pow(i,3) << setw(8) << pow(i,4) << endl;
	}
	return 0;
}

