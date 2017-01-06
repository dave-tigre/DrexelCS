#ifndef PRODUCT_H
#define PRODUCT_H

#include <string>

using namespace std;

class Product
{
public:
  /**
    Constructs a product with score 0 and price 1
  */
  Product();

  /**
    Reads in this product object
  */
  void read();

  /**
    Compares two product objects
  */
  bool is_better_than(Product b) const;

  /**
    Prints this product object.
  */
  void print() const;

private:
  string name;
  double price;
  int score;
};

#endif
