/**
* Author: David Tigreros
* 4/27/2017
*
* CS380 Homework 1
* main.cpp
* runs each solver algorithm
*/

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

  GameSolver solver1(state1);

  int test1 = solver1.getManhattanDistance(state1.getPiecePosition(2), state1.getPiecePosition(-1));
  cout << "\n\n Manhattan distance test1 : "  << test1 << endl;

  GameState state2("SBP-level1.txt");
  cout << "\nStarting Puzzle: " << endl;
  state2.displayPuzzle();
  cout << "\n";

  GameSolver solver(state2);
  state2.displayPuzzle();
  cout << "\n";

  int test2 = solver.getManhattanDistance(state2.getPiecePosition(2), state2.getPiecePosition(-1));
  cout << "\n\n Manhattan distance test2 : "  << test2 << endl;
  return 0;
}
