/*
* CS-350 Software Design
*
* Program 2
*
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

void TestFunc1(A t)
{
  std::cout << "in TestFunc1" << std::endl;
}

void TestFunc2(A * t)
{
  std::cout << "in TestFunc2" << std::endl;
}

int main()
{

  std::cout << "Expected: Option d from slides" << std::endl;
  std::cout <<"Actual: " << std::endl;
  int x;
  A Test;
  A * Test2;
  Test2 = new A;
  TestFunc1(Test);
  TestFunc2(Test2);


  return 0;
}
