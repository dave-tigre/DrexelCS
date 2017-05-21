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

  int master_max_r = master_start_r + master_height;
  int master_max_c = master_start_c + master_width;

  /*
  * Get most right and down position of goal
  */
  int goalRDStartR = goal_pos.r_pos[0]; // starting row position
  int goalRDStartC= goal_pos.c_pos[0]; // starting column position

  int goal_num_pos = goal_pos.r_pos.size();
  int goalRDWidth = 0;
  int goalRDHeight = 0;

  for(int i = 0; i < goal_num_pos; i++)
  {

    if(goalRDStartR != goal_pos.r_pos[i])
      goalRDHeight++;

    if(goalRDStartC != goal_pos.c_pos[i])
      goalRDWidth++;
  }

  int goalRDMaxR = goalRDStartR + goalRDHeight;
  int goalRDMaxC = goalRDStartC + goalRDWidth;
  //
  // cout << "Piece Start: (" << master_start_r << "," << master_start_c << ")";
  // cout << " Piece RD: (" << master_max_r << "," << master_max_c << ")" << endl;
  //
  // cout << "Goal Start: (" << goalRDStartR << "," << goalRDStartC << ")";
  // cout << " Goal RD: (" << goalRDMaxR << "," << goalRDMaxC << ")" << endl;

  int manhattanDistance = abs(goalRDMaxR - master_max_r) + abs(goalRDMaxC - master_max_c);

  if(master_pos.r_pos.size() == 1 && master_pos.c_pos.size() == 1)
  {
    int checkDist = abs(goalRDStartR - master_max_r) + abs(goalRDStartC - master_max_c);
    if(checkDist < manhattanDistance)
    {
      manhattanDistance = checkDist;
    }
  }
  return manhattanDistance;
}

float GameSolver::getStraightLineDistance(PiecePosition master_pos, PiecePosition goal_pos)
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

  float r_dif = goal_max_r - master_max_r;
  float c_dif = goal_max_c - master_max_c;

  float straightLine_distance = sqrt((r_dif*r_dif)+(c_dif*c_dif));
  return straightLine_distance;
}

int GameSolver::getEaseCost(GameState movedState, GameState parentState, int movedPiece)
{
  PiecePosition oldPos = parentState.getPiecePosition(movedPiece);
  PiecePosition movedPos = movedState.getPiecePosition(movedPiece);

  PiecePosition goalPos = movedState.getPiecePosition(goalPiece);
  PiecePosition masterPos = movedState.getPiecePosition(masterPiece);

  int oldDist = getManhattanDistance(oldPos, goalPos);
  int movedDist = getManhattanDistance(movedPos, goalPos);
  int goalDist = getManhattanDistance(masterPos, goalPos);
  int easeCost = goalDist - movedDist;

  if(movedPiece == masterPiece)
  {
    easeCost = goalDist - 2*movedDist;
  }
  else if(movedDist > oldDist)
  {
    easeCost = easeCost;
  }
  else if (oldDist == movedDist)
  {
    easeCost++;
  }
  else{
    easeCost = easeCost +5;
  }


  cout << "\nMove Piece: " << movedPiece  << " ManDis: " << movedDist << " Ease Cost:  " << easeCost <<  endl;



  return easeCost;
}

int GameSolver::block(GameState movedState, PiecePosition master_pos, PiecePosition goal_pos)
{
  vector<vector<int> > puzzleMatrix = movedState.getPuzzle();

  /*
  * Get most right and down position of goal
  */
  int goal_start_r = goal_pos.r_pos[0]; // starting row position
  int goal_start_c = goal_pos.c_pos[0]; // starting column position
  int goal_num_pos = goal_pos.r_pos.size();
  int goal_width = 0;
  int goal_height = 0;
  int boundary = 0; // boundary to allow master piece(2) to cover 0 and -1 block
  for(int i = 0; i < goal_num_pos; i++)
  {

    if(goal_start_r != goal_pos.r_pos[i])
      goal_height++;

    if(goal_start_c != goal_pos.c_pos[i])
      goal_width++;
  }

  //check UP side
  bool openUp = true;
  for(int c = goal_start_c; c < goal_start_c + goal_width; c++)
  {
    if(puzzleMatrix[goal_start_r-1][c] < boundary || puzzleMatrix[goal_start_r-1][c] > 0)
    {
      openUp = false;
      break;
    }
  }

  //check Down side
  bool openDown = true;
  for(int c = goal_start_c; c < goal_start_c + goal_width; c++)
  {
    if(puzzleMatrix[goal_start_r+1][c] < boundary || puzzleMatrix[goal_start_r+1][c] > 0)
    {
      openDown = false;
      break;
    }
  }

  //check Left side
  bool openLeft = true;
  for(int r = goal_start_r; r < goal_start_r + goal_height; r++)
  {
    if(puzzleMatrix[r][goal_start_c-1] < boundary || puzzleMatrix[r][goal_start_c-1] > 0)
    {
      openLeft = false;
      break;
    }
  }

  //check Right side
  bool openRight = true;
  for(int r = goal_start_r; r < goal_start_r + goal_height; r++)
  {
    if(puzzleMatrix[r][goal_start_c+1] < boundary || puzzleMatrix[r][goal_start_c+1] > 0)
    {
      openRight = false;
      break;
    }
  }

  int blockCost = 0;
  if(!openUp || !openDown || !openRight || !openLeft)
    blockCost++;

  int totalCost = blockCost + getManhattanDistance(master_pos, goal_pos);

  return totalCost;

}


int GameSolver::getEstimatedCost(int g, int h)
{
  return g+h;
}


void GameSolver::aStarSearch(const HEURISTIC heuristic)
{
  deque<StateNode> frontier;
  vector<GameState> explored;

  StateNode parentNode; // root node
  StateNode childNode; // initiate child node
  StateNode currentNode; // current Node

  float moveEval = 0;

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

    explored.push_back(currentNode.nodeState);

    availMoves.clear();
    availMoves = currentNode.nodeState.puzzleMoves(); //available moves (children)

    vector<Move> evaluatedMoves;
    evaluatedMoves.clear();

    Move lowestMove;

    for(auto currentMove : availMoves)
    {
      childNode.parentState = currentNode.nodeState; // record parent state of child node

      childNode.nodeState = currentNode.nodeState.applyMoveCloning(currentMove); // apply move and clone


      //get lowest score of moves
      PiecePosition master = childNode.nodeState.getPiecePosition(masterPiece);
      PiecePosition goal = childNode.nodeState.getPiecePosition(goalPiece);

      // determine if already looked at this node
      // if(!(searchFrontier(frontier, childNode.nodeState) || searchExplored(explored, childNode.nodeState)))
      // {
      //
      //
      // }

      if(childNode.nodeState.gameCheck())
      {
        cout << "\nA* Search Solved Puzzle:" << endl;
        childNode.nodeState.displayPuzzle();
        gameSolved = true;
        break;
      }

      /*
      * Evaluate current move
      */
      switch(heuristic)
      {
        case NONE: moveEval = pathCost;
        break;

        case MANHATTAN: moveEval = getEstimatedCost(pathCost, getManhattanDistance(master,goal));
        break;

        case SLD: moveEval = getEstimatedCost(pathCost, getStraightLineDistance(master,goal));
        break;

        case EASE: moveEval = getEstimatedCost(pathCost, getEaseCost(childNode.nodeState,childNode.parentState, currentMove.getPiece()));
        break;

        case BLOCK: moveEval = getEstimatedCost(pathCost, block(childNode.nodeState,master, goal));
        break;

        default: moveEval = getEstimatedCost(pathCost, getManhattanDistance(master,goal));
        break;
      }
      cout << "\nMOve Cost = " << moveEval << endl;;
      currentMove.setMoveCost(moveEval);

      // insert move into evaluated moves in order of evalcost
      int pos = evaluatedMoves.size()+9;
      if(evaluatedMoves.empty())
      {
        evaluatedMoves.push_back(currentMove);
      }
      else
      {
        for(unsigned int i = 0; i < evaluatedMoves.size(); i++)
        {
          if(currentMove.getMoveCost() < evaluatedMoves[i].getMoveCost())
          {
            pos = i;
            break;
          }
        }
      }

      if(pos > evaluatedMoves.size())
      {
        evaluatedMoves.push_back(currentMove);
      }
      else
      {
        evaluatedMoves.insert(evaluatedMoves.begin()+pos, currentMove);
      }
      currentMove.printMove();
      childNode.nodeState.displayPuzzle();
      //SchildNode.nodeState.normalizeState(); // normalize clone
    }

    for(unsigned int i = 0; i < evaluatedMoves.size(); i++)
    {
      childNode.nodeState = currentNode.nodeState.applyMoveCloning(evaluatedMoves[i]);
      if(!(searchFrontier(frontier, childNode.nodeState) || searchExplored(explored, childNode.nodeState)))
      {
        //evaluatedMoves[i].printMove();
        frontier.push_front(childNode);
        cout << "\n\nNew Node" << endl;
        childNode.nodeState.displayPuzzle();
        cout << "\n";
        break;
      }
    }


  }

}
