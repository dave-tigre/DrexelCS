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
#include <queue>

using namespace std;

struct StateNode
{
  GameState *parentState = NULL; // parent node
  GameState *nodeState = NULL; // current state
  Move *action = NULL; // action to get here
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
  * Search Frontier
  */
  bool searchFrontier(const queue<StateNode> front, GameState& state);

  /**
  * Search Explored
  */
  bool searchExplored(const set<GameState> expl, GameState& state);

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
  GameState& gameState;
};
#endif // _SLIDING_BLOCK_SOLVER_H_
