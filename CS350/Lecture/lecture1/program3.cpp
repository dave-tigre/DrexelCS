/*
*
* Program example 3
*
*
*/

#include <iostream>

class A
{
public:
  A();
  ~A();
}

class B: public A
{
public:
  B();
  ~B();
}

B::B()
{
  std::cout << "constructor B" << std::endl;
}

B::~B()
{
  std::cout << "destructor B" << std::endl;
}

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
  std::cout << "Expected: Option " << std::endl;
  int x;
  B Test;
  B * Test2;
  Test2 = new B;
  delete Test2;

  return 0;
}
