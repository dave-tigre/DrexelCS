/*
* Chapter 5.1 Discovering Classes
* This program determines the "best bang for you buck" when given a score
* and price of a product
*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
  string best_name = "";
  double best_price = 1;
  int best_score = 0;
  bool more = true;

  while(more)
  {
    string next_name;
    double next_price;
    int next_score;

    cout << "Please enter the model name: ";
    getline(cin, next_name);
    cout << "Please enter the price: ";
    cin >> next_price;
    cout << "Please enter the score of the product: ";
    cin >> next_score;
    string remainders;
    getline(cin, remainders);

    if(next_score / next_price > best_score / best_price)
    {
      best_name = next_name;
      best_price = next_price;
      best_score = next_score;
    }

    cout << "More Data? (y/n) ";
    string answer;
    cin  >> answer;
    if(answer != "y")
      more = false;
  }

  cout << "The best value is: " << best_name << endl;
  cout << "Score: " << best_score << endl;
  cout << "Price: $" << best_price << endl;
  return 0;
}
