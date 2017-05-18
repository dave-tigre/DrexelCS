/**
* Author: David Tigreros
* 4/27/2017
*
* CS380 Homework 1
*
* slidingBlock_puzzle.cpp
* Methods to implement and modify a Game Puzzle State
*/

#include  "slidingBlock_puzzle.h"

using namespace std;

GameState::GameState(const string filename){
  loadGame(filename);
}

GameState::GameState(const std::vector<std::vector<int> > &puzzle)
{
  row = puzzle.size();
  col = puzzle[1].size();

  int m = row, n = col;
   //Grow rows by m
   puzzleMatrix.resize(m);
   for(int i = 0 ; i < m ; ++i)
   {
       //Grow Columns by n
       puzzleMatrix[i].resize(n);
   }

  for(int i = 0 ; i < m ; ++i)
  {
    for(int j = 0 ; j < n ; ++j)
    {      //modify matrix
      puzzleMatrix[i][j] = puzzle[i][j];
    }
  }
}

GameState::~GameState()
{

}

void GameState::loadGame(const string filename)
{

    ifstream puzzle_file;
    puzzle_file.open(filename.c_str());

    if(puzzle_file.fail())
    {
      cout << "I'm sorry, the file \"" << filename << "\" cannot be found." << endl;
		  cout << "The file must be in the same directory as this program." << endl;
    }
    else
    {
		  createPuzzle(puzzle_file);
      puzzle_file.close();
    }
}

/**
* Split the given string into a vector using given delimiter
*/
static vector<string> split(const string& s, const string& delim, const bool keep_empty=true){
    vector<string> elems; // vector of string elements
    size_t pos = 0, last_pos = 0;
    string token;
    while ((pos = s.find(delim, last_pos)) != string::npos) {
        token = s.substr(last_pos, pos - last_pos);
        if (keep_empty || token.length() > 0){
            elems.push_back(token);
        }
        last_pos = pos + 1;
    }
    token = s.substr(last_pos);
    if (keep_empty || token.length() > 0){
        elems.push_back(token);
    }
    return elems;
}

void GameState::createPuzzle(istream& in)
{
  string current_line;

  vector<std::string> elems;
  getline(in,current_line);
  elems = split(current_line, ",");

  col = stoi(elems[0]);
  row = stoi(elems[1]);

  int m = row, n = col;
   //Grow rows by m
   puzzleMatrix.resize(m);
   for(int i = 0 ; i < m ; ++i)
   {
       //Grow Columns by n
       puzzleMatrix[i].resize(n);
   }

  for(int i = 0 ; i < m ; ++i)
  {
    getline(in,current_line);
    elems = split(current_line, ",", false);
    for(int j = 0 ; j < n ; ++j)
    {      //modify matrix
      puzzleMatrix[i][j] = std::stoi(elems[j]);
    }
  }

}

void GameState::displayPuzzle() const
{
  /**
  * TODO:
  * use string formatting to display game puzzle matrix
  */
  cout << fixed << setprecision(2);
  cout << setw(2) << col << "," << row << endl;
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      cout << setw(2) << puzzleMatrix[r][c] << ",";
    }
    cout << "\n";
  }
}

vector<vector <int> > GameState::getPuzzle()
{
  return puzzleMatrix;
}

GameState GameState::cloneState() const
{
  return GameState(puzzleMatrix);
}

bool GameState::gameCheck()
{
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] == -1)
      {
        return false;
      }
    }
  }

  return true;
}

void GameState::normalizeState()
{
  int nextIdx = 3;
  for(int r = 0; r < row; r++)
  {
    for(int c = 0 ; c < col; c++)
    {
      if(puzzleMatrix[r][c] == nextIdx)
      {
        nextIdx++;
      }
      else if(puzzleMatrix[r][c] > nextIdx)
      {
        swapIdx(nextIdx, puzzleMatrix[r][c]);
        nextIdx++;
      }
    }
  }
}

void GameState::swapIdx(int idx1, int idx2)
{
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] == idx1)
      {
        puzzleMatrix[r][c] = idx2;
      }
      else if (puzzleMatrix[r][c] == idx2)
      {
        puzzleMatrix[r][c] = idx1;
      }
    }
  }
}

PiecePosition GameState::getPiecePosition(const int piece)
{
  PiecePosition piece_pos;
  vector<int> r_pos; // vector to hold row position
  vector<int> c_pos; // vector to hold coloumn position

  // find piece position in puzzle
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] == piece){
        r_pos.push_back(r);
        c_pos.push_back(c);
      }
    }
  }

  piece_pos.r_pos = r_pos;
  piece_pos.c_pos = c_pos;

  return piece_pos;
}

vector<Move> GameState::pieceMoves(const int piece)
{
  vector<Move> possibleMoves; //vector to for list of possible directions for given piece

  vector<int> r_pos; // vector to hold row position
  vector<int> c_pos; // vector to hold coloumn position

  int boundary = 0; // boundary to allow master piece(2) to cover 0 and -1 block

  // return empty list if piece is wall or goal
  if(piece < 2)
  {
    return possibleMoves;
  }

  if (piece == 2)
  {
    boundary = -1;
  }

  // find piece position in puzzle
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] == piece){
        r_pos.push_back(r);
        c_pos.push_back(c);
      }
    }
  }


  int num_pos = r_pos.size(); // number of positions found for given piece
  int width = 1; // width of block given piece
  int height = 1; // height of block of given piece

  // only check if the piece is found
  if(!r_pos.empty())
  {
    int start_r = r_pos[0]; // starting row position
    int start_c = c_pos[0]; // starting column position

    for(int i = 0; i < num_pos; i++)
    {

      if(start_r != r_pos[i])
        height++;

      if(start_c != c_pos[i])
        width++;
    }

    //check UP side
    bool openUp = true;
    for(int c = start_c; c < start_c + width; c++)
    {
      if(puzzleMatrix[start_r-1][c] < boundary || puzzleMatrix[start_r-1][c] > 0)
      {
        openUp = false;
        break;
      }
    }

    //check Down side
    bool openDown = true;
    for(int c = start_c; c < start_c + width; c++)
    {
      if(puzzleMatrix[start_r+1][c] < boundary || puzzleMatrix[start_r+1][c] > 0)
      {
        openDown = false;
        break;
      }
    }

    //check Left side
    bool openLeft = true;
    for(int r = start_r; r < start_r + height; r++)
    {
      if(puzzleMatrix[r][start_c-1] < boundary || puzzleMatrix[r][start_c-1] > 0)
      {
        openLeft = false;
        break;
      }
    }

    //check Right side
    bool openRight = true;
    for(int r = start_r; r < start_r + height; r++)
    {
      if(puzzleMatrix[r][start_c+1] < boundary || puzzleMatrix[r][start_c+1] > 0)
      {
        openRight = false;
        break;
      }
    }

    // add moves to vector
    if(openUp)
      possibleMoves.push_back(Move(piece, UP));

    if(openDown)
      possibleMoves.push_back(Move(piece, DOWN));

    if(openLeft)
      possibleMoves.push_back(Move(piece, LEFT));

    if(openRight)
      possibleMoves.push_back(Move(piece, RIGHT));
  }
  return possibleMoves;

}

vector<Move> GameState::puzzleMoves()
{
  vector<Move> allMoves;
  vector<Move> pMoves;
  int max_num = 0; // highest block number in puzzle

  // find max number in puzzle
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] > max_num){
        max_num = puzzleMatrix[r][c];
      }
    }
  }

  for(int i = 2; i < (max_num+1); i++)
  {
    pMoves = pieceMoves(i);
    allMoves.insert( allMoves.end(),  pMoves.begin(),  pMoves.end());
    pMoves.clear();
  }

  //debug to view moves output
  // cout << "\n";
  // for (int p = 0; p < allMoves.size(); p++)
  // {
  //   allMoves[p].printMove();
  // }

  return allMoves;

}

void GameState::applyMove(Move move)
{
  int piece = move.getPiece();

  vector<int> r_pos; // vector to hold row position
  vector<int> c_pos; // vector to hold coloumn position

  // find piece position in puzzle
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] == piece){
        r_pos.push_back(r);
        c_pos.push_back(c);
      }
    }
  }

  int num_pos = r_pos.size(); // number of positions found for given piece
  int width = 1; // width of block given piece
  int height = 1; // height of block of given piece

  int start_r = r_pos[0]; // starting row position
  int start_c = c_pos[0]; // starting column position
  // cout << "\nPosition of " << piece <<  ": ";
  for(int i = 0; i < num_pos; i++)
  {
    if(start_r != r_pos[i])
      height++;

    if(start_c != c_pos[i])
      width++;
  }

  switch(move.getDirection())
  {
    case UP:
              for(int c = start_c; c < start_c + width; c++)
              {
                puzzleMatrix[start_r-1][c] = piece;
                puzzleMatrix[start_r+height-1][c] = 0;
              }
              break;
    case DOWN:
              for(int c = start_c; c < start_c + width; c++)
              {
                puzzleMatrix[start_r+1][c] = piece;
                puzzleMatrix[start_r-height+1][c] = 0;
              }
              break;
    case LEFT:
              for(int r = start_r; r < start_r + height; r++)
              {
                puzzleMatrix[r][start_c-1] = piece;
                puzzleMatrix[r][start_c+width-1] = 0;
              }
              break;
     case RIGHT:
             for(int r = start_r; r < start_r + height; r++)
             {
               puzzleMatrix[r][start_c+1] = piece;
               puzzleMatrix[r][start_c-width+1] = 0;
             }
             break;
  }

}

GameState GameState::applyMoveCloning(Move move)
{
    GameState movedState = this->cloneState();
    movedState.applyMove(move);
    return movedState;
}

bool GameState::compareState(GameState& state)
{
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzleMatrix[r][c] != state.getPuzzle()[r][c]){
        return false;
      }
    }
  }

  return true;
}
