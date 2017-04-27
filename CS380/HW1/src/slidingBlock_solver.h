#ifndef _SLIDING_BLOCK_SOLVER_H_
#define _SLIDING_BLOCK_SOLVER_H_

#include "slidingBlock_puzzle.h"

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <set>
#include <iomanip>

using namespace std;

class GameSolver
{
public:
  GameSolver(GameState& puzzle): gamePuzzle(puzzle){}
  ~GameSolver(){}


  /**
  * Random Walk
  */
  void randomWalk(const int runtime);

  /**
  * Breadth-First Search
  */
  void breadFirstSearch();

  /**
  * Depth-First Search
  */
  void depthFirstSearch();

  /**
  * Iterative Deepening Search
  */
  void iterDeepSearch();

private:
  GameState gamePuzzle;
};
#endif // _SLIDING_BLOCK_SOLVER_H_
