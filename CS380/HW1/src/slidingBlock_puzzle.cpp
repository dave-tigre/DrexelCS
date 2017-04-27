#include  "slidingBlock_puzzle.h"

using namespace std;

/*
============================================================================
==========================  GAME STATE CLASS  ==============================
============================================================================
*/

GameState::GameState(const string filename){
  loadGame(filename);
}

GameState::~GameState()
{

}

void GameState::loadGame(const string filename)
{
  /**
  * TODO:
  * find file and load game
  * enable error handling for misspelled or missing file names
  */

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
 * Generic split string function.
 * Args:
 *     keep_empty (bool): Retain empty strings in the returned vector if set to true.
 *         Defaults to true.
 */
static std::vector<std::string> split(const std::string& s, const std::string& delim,
        const bool keep_empty=true){
    std::vector<std::string> elems; // vector of string elements
    size_t pos = 0, last_pos = 0;
    std::string token;
    while ((pos = s.find(delim, last_pos)) != std::string::npos) {
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

  // allocate puzzle matrix space
  puzzleMatrix.resize(col);
  for(int c = 0; c < col; c++)
  {
      //Grow Columns by n
      puzzleMatrix[c].resize(row);
  }

  for(int r = 0; r < row; r++)
  {
    if(in.eof())
      break;
    getline(in,current_line);
    elems = split(current_line, ",", false);

    for(int c = 0; c < col; c++)
    {
      puzzleMatrix[r][c] = std::stoi(elems[c]);
    }

  }
}

void GameState::displayPuzzle()
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

void GameState::displayPuzzle(const vector<vector <int> > puzzle)
{
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

vector<vector <int> > GameState::cloneState()
{
  vector<vector <int> > clone;

  clone.resize(col);
  for(int c = 0; c < col; c++)
  {
      //Grow Columns by n
      clone[c].resize(row);
  }

  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      clone[r][c] = puzzleMatrix[r][c];
    }
  }

  return clone;
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

vector<Move> GameState::pieceMoves(const int piece)
{
  vector<Move> possibleMoves; //vector to for list of possible directions for given piece

  vector<int> r_pos; // vector to hold row position
  vector<int> c_pos; // vector to hold coloumn position

  // return empty list if piece is wall or goal
  if(piece < 2)
  {
    return possibleMoves;
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
    // cout << "\nPosition of " << piece <<  ": ";
    for(int i = 0; i < num_pos; i++)
    {

      //cout << "(" << c_pos[i] << ", " << r_pos[i] << ")";
      if(start_r != r_pos[i])
        height++;

      if(start_c != c_pos[i])
        width++;
    }
    //cout << "\nwidth = " << width << "  height= " << height <<"\n\n";

    //check UP side
    bool openUp = true;
    for(int c = start_c; c < start_c + width; c++)
    {
      if(puzzleMatrix[start_r-1][c] != 0)
      {
        openUp = false;
        break;
      }
    }

    //check Down side
    bool openDown = true;
    for(int c = start_c; c < start_c + width; c++)
    {
      if(puzzleMatrix[start_r+1][c] != 0)
      {
        openDown = false;
        break;
      }
    }

    //check Left side
    bool openLeft = true;
    for(int r = start_r; r < start_r + height; r++)
    {
      if(puzzleMatrix[r][start_c-1] != 0)
      {
        openLeft = false;
        break;
      }
    }

    //check Right side
    bool openRight = true;
    for(int r = start_r; r < start_r + height; r++)
    {
      if(puzzleMatrix[r][start_c+1] != 0)
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

  // debug to view moves output
  // cout << "\n";
  // for (int p = 0; p < allMoves.size(); p++)
  // {
  //   allMoves[p].printMove();
  // }

  return allMoves;

}

void GameState::applyMove(Move& move)
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
                if(puzzleMatrix[start_r-1][c] == 0)
                {
                  puzzleMatrix[start_r-1][c] = piece;
                  puzzleMatrix[start_r][c] = 0;

                }
              }
              break;
    case DOWN:
              for(int c = start_c; c < start_c + width; c++)
              {
                if(puzzleMatrix[start_r+1][c] == 0)
                {
                  puzzleMatrix[start_r+1][c] = piece;
                  puzzleMatrix[start_r][c] = 0;

                }
              }
              break;
    case LEFT:
              for(int r = start_r; r < start_r + height; r++)
              {
                if(puzzleMatrix[r][start_c-1] == 0)
                {
                  puzzleMatrix[r][start_c-1] = piece;
                  puzzleMatrix[r][start_c] = 0;
                }
              }
              break;
     case RIGHT:
             for(int r = start_r; r < start_r + height; r++)
             {
               if(puzzleMatrix[r][start_c+1] == 0)
               {
                 puzzleMatrix[r][start_c+1] = piece;
                 puzzleMatrix[r][start_c] = 0;
               }
             }
             break;
  }

}

void GameState::applyMoveCloning(Move& move)
{
  
}

void GameState::compareState()
{

}

void GameState::randomWalk()
{

}
