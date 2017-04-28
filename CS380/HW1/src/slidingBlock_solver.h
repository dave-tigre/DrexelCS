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
  GameSolver(GameState& state): gameState(state){
    BFSnodes = 0;
    BFSlength = 0;

    DFSnodes = 0;
    DFSlength = 0;

    IDSnodes = 0;
    IDSlength = 0;
  }
  ~GameSolver(){}


  /**
  * Random Walk
  */
  void randomWalk(const int runtime);

  /**
  * Breadth-First Search
  */
  void breadthFirstSearch();
  int getBFSnodes(){return BFSnodes;}
  int getBFSlength(){return BFSlength;}

  /**
  * Depth-First Search
  */
  void depthFirstSearch();
  int getDFSnodes(){return DFSnodes;}
  int getDFSlength(){return DFSlength;}

  /**
  * Iterative Deepening Search
  */
  void iterDeepSearch();
  int getIDSnodes(){return IDSnodes;}
  int getIDSlength(){return IDSlength;}

private:

  /**
  * Search Frontier to see if given state is in the given frontieir queue
  * return true if state is found else return false
  */
  bool searchFrontier(const deque<StateNode>& front, GameState& state);

  /**
  * Search Explored to see if given state is in the explored set
  * return true if state is found else return false
  */
  bool searchExplored(const vector<GameState>& explored, GameState& state);


  GameState& gameState;
  int BFSnodes;
  int BFSlength;

  int DFSnodes;
  int DFSlength;

  int IDSnodes;
  int IDSlength;
};
#endif // _SLIDING_BLOCK_SOLVER_H_
