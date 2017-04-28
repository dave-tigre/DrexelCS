#include "slidingBlock_puzzle.h"
#include "slidingBlock_solver.h"
#include <iostream>
#include <ctime>
int main()
{
  GameState state("../gameboards/SBP-level0.txt");
  cout << "\nStarting Puzzle: " << endl;
  state.displayPuzzle();
  cout << "\n";



  //GameState test = state.applyMoveCloning(state.puzzleMoves()[0]);
  //test.displayPuzzle();
  //test.displayPuzzle();
  GameSolver solver(state);
  cout << "\nBreadth-First Search\n" << endl;
  clock_t startBFS = clock();
  solver.breadthFirstSearch();
  double durationBFS = (clock() - startBFS)/(double) CLOCKS_PER_SEC;
  cout << "\nBreadth-First Duration = " << durationBFS << " seconds" << endl;

  cout << "\nDepth-First Search\n" << endl;
  clock_t startDFS = clock();
  solver.depthFirstSearch();
  double durationDFS = (clock() - startDFS)/(double) CLOCKS_PER_SEC;
  cout << "\nDepth-First Duration = " << durationDFS << " seconds" << endl;
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
