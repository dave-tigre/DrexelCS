#ifndef _GAME_STATE_H_
#define _GAME_STATE_H_

#include <stdlib.h>
#include <iostream>
#include <vector>


class GameState{

public:

  /**
  * Constructor and Destructor
  */
  GameState();
  ~GameState();

  /**
  * Load Puzzle
  */
  loadGame();

  /**
  * Display Game
  */
  displayGame();

private:
  std::vector<vector<int> > puzzleMatrix; // game puzzle matrix

};
