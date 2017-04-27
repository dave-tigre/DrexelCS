CCX=g++ -std=c++11 
RM = rm -f

headers:=				\
		slidingBlock_puzzle.h	\

sources:=				\
		slidingBlock_puzzle.cpp	\
		main.cpp		\

all: clean test

test:
	$(CCX) -o test $(sources) $(headers)

clean:
	$(RM) test	
