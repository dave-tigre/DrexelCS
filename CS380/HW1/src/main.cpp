#include "slidingBlock_puzzle.h"
#include "slidingBlock_solver.h"
#include <iostream>
int main()
{
  GameState state("../gameboards/SBP-level0.txt");
  GameSolver solver(state);

  //solver.randomWalk(50);


  solver.breadFirstSearch();

  return 0;
}
