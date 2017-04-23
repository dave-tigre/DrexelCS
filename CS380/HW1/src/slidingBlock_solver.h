#ifndef _GAME_STATE_H_
#define _GAME_STATE_H_

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

class SlidingBlockSolver{

public:

  /**
  * Constructor and Destructor
  */
  SlidingBlockSolver();
  ~SlidingBlockSolver();

  /**
  * Usage Message
  */
  void usageMessage();
  /**
  * Load Puzzle
  */
  void loadGame(const string filename);

  /**
  * Create Puzzle Board
  */

  void createPuzzle(istream& in);

  /**
  * Display Game
  */
  void displayPuzzle();

  /**
  * Determine if the puzzle is complete
  */
  bool gameCheck(const vector<vector<int> > puzzle);

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
  vector<vector<int> > puzzleMatrix; // game puzzle matrix
  string filename;
  int row;
  int col;

};

#endif //_GAME_STATE_H_
