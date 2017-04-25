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
enum DIRECTION {UP=1, DOWN=2, LEFT=3, RIGHT=4};

class GameState{

public:

  /**
  * Constructor and Destructor
  */
  GameState(const string filename);
  ~GameState();

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
  vector<vector <int> >  cloneState();

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
  * Normalize the state
  */
  void normalizeState();

  void swapIdx(int idx1, int idx2);

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
  vector< DIRECTION > pieceMoves(const vector<vector <int>> state, int piece);

  /**
  *
  */


  /**
  * Move generation
  * return:
  */
  void applyMove(const int piece, const DIRECTION direction);


private:

  int row;
  int col;

};

#endif //_SLIDING_BLOCK_H_
