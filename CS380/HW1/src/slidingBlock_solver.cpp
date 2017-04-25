#include  "slidingBlock_solver.h"

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
      cout << "File Found...\n" << "Creating Puzzle..." << endl;
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
    cout << current_line << endl;
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
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      cout << setw(5) << puzzleMatrix[r][c];
    }
    cout << "\n";
  }
}

void GameState::displayPuzzle(const vector<vector <int> > puzzle)
{
  cout << fixed << setprecision(2);
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      cout << setw(5) << puzzle[r][c];
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

bool GameState::gameCheck(const vector<vector<int> > puzzle)
{
  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(puzzle[r][c] == -1)
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

void GameState::compareState()
{

}

void GameState::randomWalk()
{

}

/*
============================================================================
=============================  MOVE CLASS  =================================
============================================================================
*/

Move::Move()
{

}

Move::~Move()
{

}

vector< DIRECTION > Move::pieceMoves(const vector<vector <int>> state, int piece)
{
  vector < DIRECTION > possibleMoves; //vector to for list of possible directions for given piece
  col = state.size(); // get num of coloumns
  row = state[1].size(); // get num of rows

  set<int> r_pos;
  set<int> c_pos;
  int sides = 4;

  // return empty list if piece is wall or goal
  if(piece == 1 || piece == -1)
  {
    return possibleMoves;
  }

  for(int r = 0; r < row; r++)
  {
    for(int c = 0; c < col; c++)
    {
      if(state[r][c] == piece){
        r_pos.insert(r);
        c_pos.insert(c);
      }
    }
  }
  int pos_r = 0;
  int pos_c = 0;

  // only check if the piece is found
  if(!r_pos.empty())
  {

    if(r_pos.size() > c_pos.size())
    {
      cout << "row " << r_pos.size() << endl;
    }
    else if (c_pos.size() > r_pos.size())
    {
      cout << "col " << c_pos.size() << endl;
    }
    else
    {
      for(int i = 0; i < sides; i++)
      {

      }
    }
  }

  return possibleMoves;

}
