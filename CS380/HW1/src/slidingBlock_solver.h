#ifndef _SLIDING_BLOCK_H_
#define _SLIDING_BLOCK_H_

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
enum DIRECTION {UP, DOWN, LEFT, RIGHT};

class GameState{

public:

  /**
  * Constructor and Destructor
  */
  GameState();
  ~GameState();

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
  * Clone State
  */
  vector<vector <int> >  cloneState(const vector<vector <int> > original);

  /**
  * Display Game
  */
  void displayPuzzle();

  /**
  * Display Game for given puzzle
  */
  void displayPuzzle(const vector<vector<int> > puzzle);

  /**
  * Get Puzzle Matrix
  */
  vector<vector <int> > getPuzzle();

  /**
  * Determine if the puzzle is complete
  */
  bool gameCheck(const vector<vector<int> > puzzle);

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

class Move{


public:
  /**
  * Constructor and Destructor
  */
  Move();
  ~Move();

  /**
  *
  */
  vector< DIRECTION > possibleMoves(const vector<vector <int>> state, int piece);

  /**
  * Move generation
  * return:
  */
  void moveBlock(const int piece, const DIRECTION direction);


private:

  int row;
  int col;

};

#endif //_SLIDING_BLOCK_H_
