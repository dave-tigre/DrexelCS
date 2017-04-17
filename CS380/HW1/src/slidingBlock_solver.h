#ifndef _GAME_STATE_H_
#define _GAME_STATE_H_

#include <stdlib.h>
#include <iostream>
#include <string>
#include <vector>


class SlidingBlockSolver{

public:

  /**
  * Constructor and Destructor
  */
  SlidingBlockSolver();
  ~SlidingBlockSolver();

  /**
  * Load Puzzle
  */
  void loadGame(const string filename);

  /**
  * Display Game
  */
  void displayGame();

  /**
  * Determine if the puzzle is complete
  */
  bool gameCheck(const vector<vector<int> >);

  /**
  * Move generation
  */
  void moveBlock();

  /**
  * State Comparison
  */
  void compareState();

  /**
  * Random Walks
  */
  void randomWalk();

private:
  std::vector<vector<int> > puzzleMatrix; // game puzzle matrix

};

#endif //_GAME_STATE_H_
