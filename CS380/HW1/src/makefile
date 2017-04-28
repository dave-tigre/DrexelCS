# Author: David Tigreros
# 4/27/2017
# 
# CS380 Homework 1
# Makefile

CCX=g++ -std=c++11 
RM = rm -f

headers:=				\
		slidingBlock_puzzle.h	\
		slidingBlock_solver.h	\

sources:=				\
		slidingBlock_puzzle.cpp	\
		slidingBlock_solver.cpp	\
		main.cpp		\

all: hw1

hw1:
	$(CCX) -o hw1 $(sources) $(headers)

clean:
	$(RM) hw1	
