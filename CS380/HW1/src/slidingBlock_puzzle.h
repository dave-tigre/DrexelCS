#ifndef _SLIDING_BLOCK_PUZZLE_H_
#define _SLIDING_BLOCK_PUZZLE_H_

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

class Move{

public:
  /**
  * Constructor and Destructor
  */
  Move(int piece, DIRECTION direc)
  {
    this->piece = piece;
    this->direc = direc;
  }
  ~Move(){}

  int getPiece()
  {
    return piece;
  }

  DIRECTION getDirection()
  {
    return direc;
  }

  void printMove()
  {
    string move = "";
    switch(direc)
    {
      case UP:      move = "up";
                    break;
      case DOWN:    move = "down";
                    break;
      case LEFT:    move = "left";
                    break;
      case RIGHT:   move = "right";
                    break;
    }
    cout << setw(2) << "(" << piece << "," << move << ")" << endl;
  }

private:

  int piece;
  DIRECTION direc;

};

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
  bool gameCheck();

  /**
  * Normalize the state
  */
  void normalizeState();

  void swapIdx(int idx1, int idx2);

  /**
  * Returns vector of possible moves a piece can make
  */
  vector<Move> pieceMoves(const int piece);

  /**
  * Returns list of possible moves a state has (union of moves that each piece can make)
  */
  vector<Move> puzzleMoves();

  /**
  * Move generation
  * return:
  */
  void applyMove(Move& move);

  /**
  *
  */
  void applyMoveCloning(Move& move);

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

#endif //_SLIDING_BLOCK_PUZZLE_H_
