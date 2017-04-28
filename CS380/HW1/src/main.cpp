#include "slidingBlock_puzzle.h"
#include "slidingBlock_solver.h"
#include <iostream>
#include <ctime>
#define MILLI_PER_SEC 1000;
int main()
{
  GameState state1("SBP-level0.txt");
  cout << "\nStarting Puzzle: " << endl;
  state1.displayPuzzle();
  cout << "\n";

  GameSolver solverRandomWalk(state1);

  //Random Walk
  int N = 3;
  solverRandomWalk.randomWalk(N);

  GameState state2("SBP-level1.txt");
  cout << "\nStarting Puzzle: " << endl;
  state2.displayPuzzle();
  cout << "\n";

  GameSolver solver(state2);


  // Breadth-First Search
  cout << "\nBreadth-First Search\n" << endl;
  clock_t startBFS = clock();
  solver.breadthFirstSearch();
  double durationBFS = ((clock() - startBFS)/(double) CLOCKS_PER_SEC)*MILLI_PER_SEC;
  cout << "\nBreadth-First Duration = " << durationBFS << " ms" << endl;

  // Depth-First Search
  cout << "\nDepth-First Search\n" << endl;
  clock_t startDFS = clock();
  solver.depthFirstSearch();
  double durationDFS = ((clock() - startDFS)/(double) CLOCKS_PER_SEC)*MILLI_PER_SEC;
  cout << "\nDepth-First Duration = " << durationDFS << " ms" << endl;

  //Iterative Deepening Search
  cout << "\nIterative Deepening Search\n" << endl;
  clock_t startIDS = clock();
  solver.iterDeepSearch();
  double durationIDS = ((clock() - startIDS)/(double) CLOCKS_PER_SEC)*MILLI_PER_SEC;
  cout << "\nIterative Deepening Duration = " << durationIDS << " ms" << endl;

  return 0;
}
