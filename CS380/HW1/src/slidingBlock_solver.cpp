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

    int num_moves = puzzleMoves.size(); //number of available moves
    int rand_move = rand() % num_moves; // choose a random move to start with

    cout << "\n";
    puzzleMoves[rand_move].printMove();
    cout << "\n";

    clonedState.applyMove(puzzleMoves[rand_move]); //apply random move

    clonedState.displayPuzzle();

    gameSolved = clonedState.gameCheck();

    // check if the game is solved
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

bool GameSolver::searchFrontier(deque<StateNode>& front, GameState& state)
{
  bool foundState = false;
  for(auto node : front)
  {
    foundState = node.nodeState.compareState(state);
    if(foundState)
      return true;
  }

  return false;

}

bool GameSolver::searchExplored(vector<GameState>& explored, GameState& state)
{
  bool foundState = false;
  for(auto expState : explored)
  {
    foundState = expState.compareState(state);
    if(foundState)
      return true;
  }

  return false;
}

void GameSolver::breadFirstSearch()
{
  /*
  * TODO:
    Develop breadth-first search algorithm
  */
  deque<StateNode> frontier; // queue of unexplored (frontier) nodes
  vector<GameState> explored; // queue of explored nodes

  StateNode parentNode; //starting node
  StateNode childNode; // intiate childNode
  StateNode currentNode;

  parentNode.nodeState = gameState.cloneState(); //set state of the current node
  cout << "Starting Puzzle:\n";
  parentNode.nodeState.displayPuzzle();

  frontier.push_back(parentNode);
  bool gameSolved = parentNode.nodeState.gameCheck(); //var for solved node

  // check if the current node is the solution
  if(gameSolved)
  {
    cout << "\nPuzzle was solved!" << endl;
  }

  /*
  * TODO:
      Create search explore and frontier methods
      find valid return type
      return solution
  */

  vector<Move> availMoves; // init of vector with available moves list
  //while the puzzle is not solved
  while(!gameSolved)
  {
    // if no more nodes to explore, failed
    if(frontier.empty())
    {
      cout << "\nPuzzle not solved!" << endl;
      break;
    }

    currentNode = frontier.front();
    frontier.pop_front();

    // add it to explored "Set"
    if(!searchExplored(explored, currentNode.nodeState))
    {
      explored.push_back(currentNode.nodeState);
    }

    availMoves.clear();
    availMoves = currentNode.nodeState.puzzleMoves(); //available moves (children)

    cout << "\nChildren = " << availMoves.size() << endl;
    for(int i = 0; i < availMoves.size(); i++)
    {

      childNode.parentState = currentNode.nodeState;
      availMoves[i].printMove(); // display action
      childNode.nodeState = currentNode.nodeState.applyMoveCloning(availMoves[i]);
      cout << "\n";
      childNode.nodeState.displayPuzzle();

      if(!searchFrontier(frontier, childNode.nodeState) || !searchExplored(explored, childNode.nodeState))
      {

        if(childNode.nodeState.gameCheck())
        {
          gameSolved = true;
        }
        else
        {
          frontier.push_back(childNode);
        }

      }
    }
    //gameSolved = true;
  }

  if(gameSolved)
    cout << "\nPuzzle was solved!" << endl;

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
