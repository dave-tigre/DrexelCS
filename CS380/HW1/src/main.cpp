#include "slidingBlock_solver.h"
#include <iostream>
int main()
{
  GameState test("../gameboards/SBP-level0.txt");

  test.displayPuzzle();

  cout <<  "\n clone state test: \n" << endl;
  test.displayPuzzle(test.cloneState());
  cout << test.gameCheck(test.cloneState()) << endl;


  cout << "\n\n Testing normalization\n" << endl;

  GameState test2("../gameboards/SBP-test-not-normalized.txt");

  test2.displayPuzzle();

  cout << "After normalization\n" << endl;
  test2.normalizeState();
  test2.displayPuzzle();

  Move testMove;

  testMove.pieceMoves(test.getPuzzle(), 2);

  return 0;
}
