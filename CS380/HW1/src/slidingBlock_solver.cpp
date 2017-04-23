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
    }
}

void SlidingBlockSolver::createPuzzle(istream& in)
{
  string current_line;
	string current_word = "";

  int row = 0;
  int col = 0;

	while (!in.eof())
	{
		if (in.eof())
			break;
		getline(in, current_line,',');
    row = stoi(current_line);
    getline(in, current_line,',');
    col = stoi(current_line);
    break;
	}
  // allocate puzzle matrix space
  puzzleMatrix.resize(row);
  for(int i = 0 ; i < row ; ++i)
  {
      //Grow Columns by n
      a[i].resize(col);
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
