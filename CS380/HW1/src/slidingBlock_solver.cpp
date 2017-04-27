#include "slidingBlock_solver.h"

void GameSolver::randomWalk(const int runtime)
{

  /*
  * TODO:
    Fix problem with not stopping after next number of iterations
  */

  vector<Move> puzzleMoves;
  //GameState clonedPuzzle = gamePuzzle.cloneState();
  cout << "\nOriginal Puzzle" << endl;
  gamePuzzle.displayPuzzle();

  bool gameSolved = false;

  int n = 0;
  for(int n = 0; n < runtime; n++)
  {
    //gamePuzzle.normalizeState();
    puzzleMoves.clear();
    puzzleMoves = gamePuzzle.puzzleMoves();

    int num_moves = puzzleMoves.size();
    int rand_move = rand() % num_moves;
    cout << "\n";
    puzzleMoves[rand_move].printMove();
    cout << "\n";

    gamePuzzle.applyMove(puzzleMoves[rand_move]);
    // cout << "Step: " << n << endl;
    gamePuzzle.displayPuzzle();
    gameSolved = gamePuzzle.gameCheck();
    if(gameSolved)
      break;
  }

  if(gameSolved)
  {
    cout << "\nPuzzle Was Solved with " << n << " moves!" << endl;
  }
  else{
    
  }
}

void GameSolver::breadFirstSearch()
{
  /*
  * TODO:
    Develop breadth-first search algorithm
  */
}

void GameSolver::depthFirstSearch()
{
  /*
  * TODO:
    Develop depth-first search algorithm
  */
}

void GameSolver::iterDeepSearch()
{
  /*
  * TODO:
    Develop itertative deepening search algorithm
  */
}
