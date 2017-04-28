#include "slidingBlock_puzzle.h"
#include "slidingBlock_solver.h"
#include <iostream>
int main()
{
  GameState state("../gameboards/SBP-level0.txt");




  //GameState test = state.applyMoveCloning(state.puzzleMoves()[0]);
  //test.displayPuzzle();
  //test.displayPuzzle();
  GameSolver solver(state);
  solver.breadFirstSearch();
  //
  //solver.randomWalk(50);
  //
  //
  //

  // cout << "Testing clone: Original\n";
  // state.displayPuzzle();
  // cout << "\n Clone" << endl;
  // GameState test = state.cloneState();
  // test.displayPuzzle();
  // cout << "\nclone move" << endl;
  // test.puzzleMoves()[0].printMove();
  // GameState test2 = test.applyMoveCloning(test.puzzleMoves()[0]);
  // test2.displayPuzzle();
  //
  // cout << "\nOriginal: " << endl;
  // state.displayPuzzle();

  return 0;
}
