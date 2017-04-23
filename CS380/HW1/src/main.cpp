#include "slidingBlock_solver.h"

int main()
{
  SlidingBlockSolver test;
  test.loadGame("../gameboards/SBP-level1.txt");
  test.displayPuzzle();
  return 0;
}
