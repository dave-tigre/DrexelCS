/*
*
*
*
*/

#include <iostream>

class A
{
public:
  A();
  ~A();
  virtual void T();
};

class B : public A
{
public:
  B();
  ~B();
  void T();
};

B::B(){}
B::~B(){}
A::A(){}
A::~A(){}

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


}
