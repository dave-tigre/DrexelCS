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
  GameState state1("../gameboards/SBP-level1.txt");
  cout << "\nStarting Puzzle: " << endl;
  state1.displayPuzzle();
  cout << "\n";

  GameSolver solver(state1);
  // Breadth-First Search
  cout << "\nA Star Search\n" << endl;
  clock_t startaStar = clock();
  solver.aStarSearch(EASE);
  double durationAStar = ((clock() - startaStar)/(double) CLOCKS_PER_SEC);
  cout << "\nA Star Search Results: " << durationAStar << " seconds" << endl;

  return 0;
}
