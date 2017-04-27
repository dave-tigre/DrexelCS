#include "slidingBlock_puzzle.h"
#include <iostream>
int main()
{
  GameState test("../gameboards/SBP-level0.txt");

  test.displayPuzzle();

  cout <<  "\n clone state test: \n" << endl;
  test.displayPuzzle(test.cloneState());
  cout << test.gameCheck() << endl;


  // cout << "\n\n Testing normalization\n" << endl;
  //
  // GameState test2("../gameboards/SBP-level2.txt");
  //
  // test2.displayPuzzle();
  //
  // cout << "After normalization\n" << endl;
  // test2.normalizeState();
  // test2.displayPuzzle();

  return 0;
}
