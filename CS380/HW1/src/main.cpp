#include "slidingBlock_puzzle.h"
#include <iostream>
int main()
{
  GameState test("../gameboards/SBP-level3.txt");

  test.displayPuzzle();

  cout <<  "\n clone state test: \n" << endl;
  test.displayPuzzle(test.cloneState());
  cout << test.gameCheck() << endl;
  // test.pieceMoves(3);
  // test.pieceMoves(2);
  // test.pieceMoves(4);
  test.puzzleMoves();


  return 0;
}
