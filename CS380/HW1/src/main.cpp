#include "slidingBlock_solver.h"
#include <iostream>
int main()
{
  GameState test;
  test.loadGame("../gameboards/SBP-level0.txt");
  test.displayPuzzle();

  cout <<  "\n clone state test: \n" << endl;
  test.displayPuzzle(test.cloneState(test.getPuzzle()));
  cout << test.gameCheck(test.cloneState(test.getPuzzle())) << endl;

  cout << "\n col: " << test.getPuzzle().size() << endl;
  cout << "\n row: " << test.getPuzzle()[1].size() << endl;

  return 0;
}
