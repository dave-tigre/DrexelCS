#include  "slidingBlock_solver.h"

using namespace std;

SlidingBlockSolver::SlidingBlockSolver(){
  printf("Puzzle Game Initiated...");
}

SlidingBlockSolver::~SlidingBlockSolver()
{
  printf("Game Terminated...");
}

void SlidingBlockSolver::usageMessage()
{

}

void SlidingBlockSolver::loadGame(const string filename)
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
        std::vector<std::string> parts;
        size_t pos = 0, last_pos = 0;
        std::string token;
        while ((pos = s.find(delim, last_pos)) != std::string::npos) {
            token = s.substr(last_pos, pos - last_pos);
            if (keep_empty || token.length() > 0){
                parts.push_back(token);
            }
            last_pos = pos + 1;
        }
        token = s.substr(last_pos);
        if (keep_empty || token.length() > 0){
            parts.push_back(token);
        }
        return parts;
    }

void SlidingBlockSolver::createPuzzle(istream& in)
{
  string current_line;

  vector<std::string> parts;
  getline(in,current_line);
  parts = split(current_line, ",");

  int col = stoi(parts[0]);
  int row = stoi(parts[1]);
  // allocate puzzle matrix space
  puzzleMatrix.resize(col);
  for(int i = 0 ; i < col ; ++i)
  {
      //Grow Columns by n
      puzzleMatrix[i].resize(row);
  }

  for(int i = 0; i < row; i++)
  {
    getline(in,current_line);
    parts = split(current_line, ",", false);
    for(int j = 0; j < col; j++)
    {
      puzzleMatrix[i][j] = std::stoi(parts[j]);
      cout << puzzleMatrix[i][j] << " ";
    }
    cout << "\n";
  }

  cout << "rows: " << row << " col: " << col << endl;
}

void SlidingBlockSolver::displayPuzzle()
{
  /**
  * TODO:
  * use string formatting to display game puzzle matrix
  */
}

bool SlidingBlockSolver::gameCheck(const vector<vector<int> > puzzle)
{

}

void SlidingBlockSolver::moveBlock()
{

}

void SlidingBlockSolver::compareState()
{

}

void SlidingBlockSolver::randomWalk()
{

}
