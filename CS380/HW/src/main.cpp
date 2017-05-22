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

  string heuristic[2] = {"manhattan", "Custom"};
  string levelName = "";
  /*
  * Level 1
  */
  levelName= "SBP-level1";
  GameState state1(levelName+".txt");
  cout << "\nStarting Puzzle: " << endl;
  state1.displayPuzzle();
  cout << "\n";
  GameSolver solver1(state1);

  // Manhattan Distance
  cout << "\n" << levelName << " " << heuristic[0] << "\n" << endl;
  clock_t startaStar_level1Manhattan = clock();
  solver1.aStarSearch(MANHATTAN);
  double durationAStar_level1Manhattan = ((clock() - startaStar_level1Manhattan)/(double) CLOCKS_PER_SEC);
  cout << "\nManhattan Level 1  A* Search Results: " << solver1.getAStarNodes() << " nodes, "
    << solver1.getAStarLength() << " length, " << durationAStar_level1Manhattan<< " seconds" << endl;

  // Custom
  cout << "\n" << levelName << " " << heuristic[1] << "\n" << endl;
  clock_t startaStar_level1Custom = clock();
  solver1.aStarSearch(EASE);
  double durationAStar_level1Custom = ((clock() - startaStar_level1Custom)/(double) CLOCKS_PER_SEC);
  cout << "\nCustom Level 1 Heuristic Results: " << solver1.getAStarNodes() << " nodes, "
    << solver1.getAStarLength() << " length, " << durationAStar_level1Custom << " seconds" << endl;

  /*
  * Level 2
  */
  cout <<"\n"<< endl;
  levelName = "SBP-level2";
  GameState state2(levelName+".txt");
  cout << "\nStarting Puzzle: " << endl;
  state2.displayPuzzle();
  cout << "\n";
  GameSolver solver2(state2);

  // Manhattan Distance
  cout << "\n" << levelName << " " << heuristic[0] << "\n" << endl;
  clock_t startaStar_level2Manhattan = clock();
  solver2.aStarSearch(MANHATTAN);
  double durationAStar_level2Manhattan = ((clock() - startaStar_level2Manhattan)/(double) CLOCKS_PER_SEC);
  cout << "\nManhattan Level 2  A* Search Results: " << solver2.getAStarNodes() << " nodes, "
    << solver2.getAStarLength() << " length, " << durationAStar_level2Manhattan<< " seconds" << endl;

  // Custom
  cout << "\n" << levelName << " " << heuristic[1] << "\n" << endl;
  clock_t startaStar_level2Custom = clock();
  solver2.aStarSearch(EASE);
  double durationAStar_level2Custom = ((clock() - startaStar_level2Custom)/(double) CLOCKS_PER_SEC);
  cout << "\nCustom Level 2 Heuristic Results: " << solver2.getAStarNodes() << " nodes, "
    << solver2.getAStarLength() << " length, " << durationAStar_level2Custom << " seconds" << endl;



  return 0;
}
