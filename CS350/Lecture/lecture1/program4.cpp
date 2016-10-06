/*
* Program 4 of examples
*
*/

#include <iostream>

class A
{
public:
  A();
  ~A();
  void T();
};

class B : public A
{
public:
  B();
  ~B();
  void T();
};

B::B()
{

}

B::~B()
{

}

A::A()
{

}

A::~A(){

}

void A::T()
{
  std::cout << "A - T" << std::endl;
}

void B::T()
{
  std::cout << "B - T" << std::endl;
}

int main()
{
  int x;
  B Test1;
  B * Test2;
  A Test3;
  A * Test4;

  Test1.T();
  Test2 = new B;
  Test2->T();
  delete Test2;
  Test3.T();
  Test4 = new A;
  Test4->T();
  delete Test4;

  return 0;
}
