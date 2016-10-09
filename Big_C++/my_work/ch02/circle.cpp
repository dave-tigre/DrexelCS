/*
* Program demonstrates modeling real life tasks with objects.
*
* Draws a circle
*/

#include "../../book_examples/bigc2code/cccfiles/ccc_win.h"
#include <iostream>

using namespace std;

int main(){
	Point p(1,3);
	cwin << p << Circle(p,2.5);
	return 0;
}
