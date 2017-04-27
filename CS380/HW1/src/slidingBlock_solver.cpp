#include "slidingBlock_solver.h"

void GameSolver::randomWalk(const int runtime)
{

  /*
  * TODO:
    Fix problem with not stopping after next number of iterations
  */

  vector<Move> puzzleMoves;
  GameState clonedState = gameState.cloneState();
  cout << "\nOriginal Puzzle" << endl;
  gameState.displayPuzzle();

  bool gameSolved = false;

  int win_moves = 0;
  for(int n = 0; n < runtime; n++)
  {
    clonedState.normalizeState();
    puzzleMoves.clear();
    puzzleMoves = clonedState.puzzleMoves();

    int num_moves = puzzleMoves.size();
    int rand_move = rand() % num_moves;
    cout << "\n";
    puzzleMoves[rand_move].printMove();
    cout << "\n";

    clonedState.applyMove(puzzleMoves[rand_move]);
    // cout << "Step: " << n << endl;
    clonedState.displayPuzzle();
    gameSolved = clonedState.gameCheck();

    if(gameSolved)
    {
      win_moves = n;
      break;
    }

  }

  if(gameSolved)
  {
    cout << "\nPuzzle Was Solved with " << win_moves << " moves!" << endl;
  }
  else{
    cout << "\nPuzzle not solved! " << endl;
  }
}

void GameSolver::breadFirstSearch()
{
  /*
  * TODO:
    Develop breadth-first search algorithm
  */
  queue<StateNode> frontier; // queue of unexplored (frontier) nodes
  set<GameState> explored; // queue of explored nodes

  StateNode parentNode; //starting node

  parentNode.nodeState = &gameState; //set state of the current node
  frontier.push(parentNode);
  bool gameSolved = parentNode.nodeState->gameCheck(); //var for solved node

  // check if the current node is the solution
  if(gameSolved)
  {
    cout << "\nPuzzle was solved!" << endl;
  }
  else{
    cout << "\nPuzzle NOT solved!" << endl;
  }

  /*
  * TODO:
      Create search explore and frontier methods
      find valid return type
      return solution
  */

  // while the puzzle is not solved
  while(!gameSolved)
  {
    // if no more nodes to explore, failed
    if(frontier.empty())
    {
      cout << "\nPuzzle not solved!" << endl;
      break;
    }

    StateNode currentNode = frontier.pop();
    explored.insert(currentNode.nodeState);

    int availMoves = currentNode.nodeState->puzzleMoves().size(); //available moves (children)
    for(int i = 0; i < availMoves; i++)
    {
      StateNode childNode = currentNode.nodeState->applyMoveCloning(availMoves[i]);

    }


  }

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
