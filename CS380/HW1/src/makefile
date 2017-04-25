CCX=g++ -std=c++11 
RM = rm -f

headers:=				\
		slidingBlock_solver.h	\

sources:=				\
		slidingBlock_solver.cpp	\
		main.cpp		\

all: clean test

test:
	$(CCX) -o test $(sources) $(headers)

clean:
	$(RM) test	
