/*
* CS-350: Software Design
*
* Given Source Code from lecture slide
* Program 1
*/

#include <iostream>

class A
{
public:
  A();
  ~A();

};

A::A()
{
  std::cout << "constructor A" << std::endl;
}

A::~A()
{
  std::cout << "destructor A" << std::endl;
}

int main()
{
  int x;
  A Test;
  A * Test2;
  Test2 = new A;
  delete Test2;
  return 0;
}
