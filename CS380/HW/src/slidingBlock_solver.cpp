/**
* Author: David Tigreros
* 4/27/2017
*
* CS380 Homework 1
*
* slidingBlock_solver.cpp
* Methods that are used to solve a game puzzle
*/


#include "slidingBlock_solver.h"

void GameSolver::randomWalk(const int runtime)
{

  vector<Move> puzzleMoves; //vector of moves
  GameState clonedState = gameState.cloneState(); //clone the original puzzle

  bool gameSolved = false; //boolean for solved game

  int solve_moves = 0; //determine number of iterations it needed to solve
  for(int n = 0; n < runtime; n++)
  {

    puzzleMoves.clear();
    puzzleMoves = clonedState.puzzleMoves();

    int num_moves = puzzleMoves.size(); //number of available moves
    int rand_move = rand() % num_moves; // choose a random move to start with

    cout << "\n";
    puzzleMoves[rand_move].printMove();
    cout << "\n";

    clonedState.applyMove(puzzleMoves[rand_move]); //apply random move
    clonedState.normalizeState();

    clonedState.displayPuzzle();

    gameSolved = clonedState.gameCheck();

    // check if the game is solved
    if(gameSolved)
    {
      solve_moves = n;
      break;
    }

  }

  if(gameSolved)
  {
    cout << "\nPuzzle Was Solved with " << solve_moves << " moves!" << endl;
  }
  else{
    cout << "\nPuzzle not solved! " << endl;
  }
}

bool GameSolver::searchFrontier(const deque<StateNode>& front, GameState& state)
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

bool GameSolver::searchExplored(const vector<GameState>& explored, GameState& state)
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

void GameSolver::breadthFirstSearch()
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

  frontier.push_back(parentNode); // FIFO queue, push parent node to the back
  bool gameSolved = parentNode.nodeState.gameCheck(); //var for solved node

  // check if the current node is the solution
  if(gameSolved)
  {
    cout << "\nBFS Solved Puzzle:" << endl;
    parentNode.nodeState.displayPuzzle();
  }

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

    currentNode = frontier.front(); // get current node from queue
    frontier.pop_front(); // pop front node
    BFSnodes++; // count nodes

    // add it to explored "Set"
    if(!searchExplored(explored, currentNode.nodeState))
    {
      explored.push_back(currentNode.nodeState);
    }

    availMoves.clear();
    availMoves = currentNode.nodeState.puzzleMoves(); //available moves (children)

    // loop through breadth-branches
    for(int i = 0; i < availMoves.size(); i++)
    {

      childNode.parentState = currentNode.nodeState; // record parent state of child node

      childNode.nodeState = currentNode.nodeState.applyMoveCloning(availMoves[i]); // apply move and clone
      childNode.nodeState.normalizeState(); // normalize clone
      //cout << "\n";

      // determine if already looked at this node
      if(!(searchFrontier(frontier, childNode.nodeState) || searchExplored(explored, childNode.nodeState)))
      {
        availMoves[i].printMove(); // display action
        BFSlength++;
        if(childNode.nodeState.gameCheck())
        {
          cout << "\nBFS Solved Puzzle:" << endl;
          childNode.nodeState.displayPuzzle();
          gameSolved = true;
          break;
        }
        else
        {
          frontier.push_back(childNode);
        }

      }
    }

  }

}

void GameSolver::depthFirstSearch()
{

  deque<StateNode> frontier; // queue of unexplored (frontier) nodes
  vector<GameState> explored; // queue of explored nodes

  StateNode parentNode; //starting node
  StateNode childNode; // intiate childNode
  StateNode currentNode;

  parentNode.nodeState = gameState.cloneState(); //set state of the current node

  frontier.push_front(parentNode); // LIFO queue
  bool gameSolved = parentNode.nodeState.gameCheck(); //var for solved node

  // check if the current node is the solution
  if(gameSolved)
  {
    cout << "\nDFS Solved Puzzle:" << endl;
    parentNode.nodeState.displayPuzzle();
  }

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

    currentNode = frontier.front(); // get front node
    frontier.pop_front(); // pop node
    DFSnodes++; // count nodes


    // add it to explored "Set"
    if(!searchExplored(explored, currentNode.nodeState))
    {
      explored.push_back(currentNode.nodeState);
    }

    availMoves.clear();
    availMoves = currentNode.nodeState.puzzleMoves(); //available moves (children)

    // open deepest node
    for(int i = 0; i < availMoves.size(); i++)
    {

      childNode.parentState = currentNode.nodeState; // set parent to child node
      childNode.nodeState = currentNode.nodeState.applyMoveCloning(availMoves[i]); // apply move and clone
      childNode.nodeState.normalizeState(); // normalize clone

      // determine if already looked at this node
      if(!(searchFrontier(frontier, childNode.nodeState) || searchExplored(explored, childNode.nodeState)))
      {
        availMoves[i].printMove(); // display action
        DFSlength++; // record move length
        if(childNode.nodeState.gameCheck())
        {
          cout << "\nDFS Solved Puzzle:" << endl;
          childNode.nodeState.displayPuzzle();
          gameSolved = true;
          break;
        }
        else
        {
          frontier.push_front(childNode);
        }

      }
    }
  }
}

void GameSolver::iterDeepSearch()
{
  deque<StateNode> frontier; // queue of unexplored (frontier) nodes
  vector<GameState> explored; // queue of explored nodes

  StateNode parentNode; //starting node
  StateNode childNode; // intiate childNode
  StateNode currentNode;

  parentNode.nodeState = gameState.cloneState(); //set state of the current node

  frontier.push_front(parentNode);
  bool gameSolved = parentNode.nodeState.gameCheck(); //var for solved node

  // check if the current node is the solution
  if(gameSolved)
  {
    cout << "\nIDS Solved Puzzle:" << endl;
    parentNode.nodeState.displayPuzzle();
  }

  vector<Move> availMoves; // init of vector with available moves list
  int currentLevel = 0; //  current level IDS is on
  int cutoff = 0; //cutoff level

  //while the puzzle is not solved
  while(!gameSolved)
  {
    // if no more nodes to explore, failed
    if(frontier.empty())
    {
      cout << "\nPuzzle not solved!" << endl;
      break;
    }
    currentLevel = 0; // reset current level
    while(currentLevel <= cutoff)
    {
      // if no more nodes to explore, failed
      if(frontier.empty())
      {
        cout << "\nPuzzle not solved!" << endl;
        break;
      }

      currentNode = frontier.front(); //get front node
      frontier.pop_front(); // pop front node
      IDSnodes++; // count nodes

      // add it to explored "Set"
      if(!searchExplored(explored, currentNode.nodeState))
      {
        explored.push_back(currentNode.nodeState);
      }

      availMoves.clear();
      availMoves = currentNode.nodeState.puzzleMoves(); //available moves (children)

      // open deepest node in level
      for(int i = 0; i < availMoves.size(); i++)
      {

        childNode.parentState = currentNode.nodeState;
        childNode.nodeState = currentNode.nodeState.applyMoveCloning(availMoves[i]);
        childNode.nodeState.normalizeState();


        if(!(searchFrontier(frontier, childNode.nodeState) || searchExplored(explored, childNode.nodeState)))
        {
          availMoves[i].printMove(); // display action
          IDSlength++;
          if(childNode.nodeState.gameCheck())
          {
            cout << "\nIDS Solved Puzzle:" << endl;
            childNode.nodeState.displayPuzzle();
            gameSolved = true;
            break;
          }
          else
          {
            frontier.push_front(childNode);
          }
        }
      }
      currentLevel++; //update current level
      if(gameSolved)
        break;
    }
    cutoff++; //update cutoff
  }
}

int GameSolver::getManhattanDistance(PiecePosition master_pos, PiecePosition goal_pos)
{
  /*
  * Get most right and down position of master block
  */
  int master_start_r = master_pos.r_pos[0]; // starting row position
  int master_start_c = master_pos.c_pos[0]; // starting column position
  int mas_num_pos = master_pos.r_pos.size();
  int master_width = 0;
  int master_height = 0;
  for(int i = 0; i < mas_num_pos; i++)
  {

    if(master_start_r != master_pos.r_pos[i])
      master_height++;

    if(master_start_c != master_pos.c_pos[i])
      master_width++;
  }

  int master_max_r = master_start_r + master_height - 1;
  int master_max_c = master_start_c + master_width - 1;

  /*
  * Get most right and down position of goal
  */
  int goal_start_r = goal_pos.r_pos[0]; // starting row position
  int goal_start_c = goal_pos.c_pos[0]; // starting column position
  int goal_num_pos = goal_pos.r_pos.size();
  int goal_width = 0;
  int goal_height = 0;
  for(int i = 0; i < goal_num_pos; i++)
  {

    if(goal_start_r != goal_pos.r_pos[i])
      goal_height++;

    if(goal_start_c != goal_pos.c_pos[i])
      goal_width++;
  }

  int goal_max_r = goal_start_r + goal_height - 1;
  int goal_max_c = goal_start_c + goal_width - 1;

  int manhattan_distance = abs(goal_max_r - master_max_r) + abs(goal_max_c - master_max_c);
  return manhattan_distance;
}


int GameSolver::getEstimatedCost(int g, int h)
{
  return 0;
}


void GameSolver::aStarSearch(const HEURISTIC heuristic)
{
  deque<StateNode> frontier;
  vector<GameState> explored;

  StateNode parentNode; // root node
  StateNode childnode; // initiate child node
  StateNode currentNode; // current Node

  parentNode.nodeState = gameState.cloneState(); // clone root node

  frontier.push_back(parentNode); // add to frontier
  bool gameSolved = parentNode.nodeState.gameCheck(); // check if root is goal

  if(gameSolved)
  {
    cout << "\nA* Search Solved Puzzle:" << endl;
    parentNode.nodeState.displayPuzzle();
  }

  vector<Move> availMoves; // init vector with available moves list

  while(!gameSolved)
  {
    if(frontier.empty())
    {
      cout << "\nPuzzle not solved!" << endl;
      break;
    }
    currentNode = frontier.front(); //get current node from queue
    frontier.pop_front(); // pop front node
    aStarNodes++;

    // add it to explored "Set"
    if(!searchExplored(explored, currentNode.nodeState))
    {
      explored.push_back(currentNode.nodeState);
    }

    availMoves.clear();
    availMoves = currentNode.nodeState.puzzleMoves(); //available moves (children)


  }

}
