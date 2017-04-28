#include "slidingBlock_puzzle.h"
#include "slidingBlock_solver.h"
#include <iostream>
#include <ctime>
#define MILLI_PER_SEC 1000;
int main()
{
  GameState state("SBP-level0.txt");
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
  double durationBFS = ((clock() - startBFS)/(double) CLOCKS_PER_SEC)*MILLI_PER_SEC;
  cout << "\nBreadth-First Duration = " << durationBFS << " ms" << endl;

  cout << "\nDepth-First Search\n" << endl;
  clock_t startDFS = clock();
  solver.depthFirstSearch();
  double durationDFS = ((clock() - startDFS)/(double) CLOCKS_PER_SEC)*MILLI_PER_SEC;
  cout << "\nDepth-First Duration = " << durationDFS << " ms" << endl;

  cout << "\nIterative Deepening Search\n" << endl;
  clock_t startIDS = clock();
  solver.iterDeepSearch();
  double durationIDS = ((clock() - startIDS)/(double) CLOCKS_PER_SEC)*MILLI_PER_SEC;
  cout << "\nIterative Deepening Duration = " << durationIDS << " ms" << endl;



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
