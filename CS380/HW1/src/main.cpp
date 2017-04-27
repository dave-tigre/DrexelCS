#include "slidingBlock_puzzle.h"
#include <iostream>
int main()
{
  GameState test("../gameboards/SBP-level3.txt");

  test.displayPuzzle();

  cout <<  "\n clone state test: \n" << endl;
  GameState cloneTest = test.cloneState();
  cloneTest.displayPuzzle();

  cout << "\nTest Game Check: " << test.gameCheck() << endl;
  // test.pieceMoves(3);
  // test.pieceMoves(2);
  // test.pieceMoves(4);


  cout << "\n\n Before Applying Move" << endl;
  test.puzzleMoves();
  //test.puzzleMoves()[0].printMove();
  cout << "\n After Move" << endl;
  test.applyMove(test.puzzleMoves()[0]);

  cout << "\n" << endl;
  test.displayPuzzle();


  return 0;
}
