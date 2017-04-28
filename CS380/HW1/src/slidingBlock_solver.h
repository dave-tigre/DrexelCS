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
#include <deque>

using namespace std;

struct StateNode
{
  GameState parentState; // parent node
  GameState nodeState; // current state
  Move action; // action to get here
};

class GameSolver
{
public:
  GameSolver(GameState& state): gameState(state){}
  ~GameSolver(){}


  /**
  * Random Walk
  */
  void randomWalk(const int runtime);

  /**
  * Breadth-First Search
  */
  void breadthFirstSearch();

  /**
  * Depth-First Search
  */
  void depthFirstSearch();

  void recersiveDepthFirstSearch(int limit, bool useLimit);

  /**
  * Iterative Deepening Search
  */
  void iterDeepSearch();

private:

  /**
  * Search Frontier to see if given state is in the given frontieir queue
  * return true if state is found else return false
  */
  bool searchFrontier(deque<StateNode>& front, GameState& state);

  /**
  * Search Explored to see if given state is in the explored set
  * return true if state is found else return false
  */
  bool searchExplored(vector<GameState>& explored, GameState& state);


  GameState& gameState;
};
#endif // _SLIDING_BLOCK_SOLVER_H_
