/**
* Author: David Tigreros
* 4/27/2017
*
* CS380 Homework 1
*
* slidingBlock_puzzle.h
* Defines classes that are used to create a game puzzle
*/

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

struct PiecePosition{
  vector<int> r_pos; // vector to hold row position
  vector<int> c_pos; // vector to hold coloumn position
};

class Move{

public:
  /**
  * Constructor and Destructor
  */
  Move(){};
  Move(int piece, DIRECTION direc)
  {
    this->piece = piece;
    this->direc = direc;
    this->moveCost = 0;
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

  void setMoveCost(float cost)
  {
    moveCost = cost;
  }

  float getMoveCost()
  {
    return moveCost;
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
  float moveCost;

};

class GameState{

public:

  /**
  * Constructor and Destructor
  */
  GameState(){}
  GameState(const vector<vector<int> > &puzzle);//: puzzleMatrix(puzzle){}
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
  GameState cloneState() const;

  /**
  * Display Game
  */
  void displayPuzzle() const;

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

  PiecePosition getPiecePosition(const int piece);

  /**
  * Returns list of possible moves a state has (union of moves that each piece can make)
  */
  vector<Move> puzzleMoves();

  /**
  * Move generation
  * return:
  */
  void applyMove(Move move);

  /**
  *
  */
  GameState applyMoveCloning(Move move);

  /**
  * State Comparison
  */
  bool compareState(GameState& state);

  friend bool operator< (GameState &gs1, GameState &gs2)
  {
    return gs1.compareState(gs2);
  }

private:
  vector<vector<int> > puzzleMatrix; // game puzzle matrix
  string filename;
  int row;
  int col;

};

#endif //_SLIDING_BLOCK_PUZZLE_H_
