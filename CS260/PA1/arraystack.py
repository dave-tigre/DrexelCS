#!/usr/bin/env python

# Author: David Tigreros
# 7/29/2016
# CS-260 Section 003
# Dr. Nowak
# Programming Assignment 1
# Array Implementation of Stack

# TOP: return the top element in the stack.
def TOP(S):
	return S[0];

# POP: return and delete the element at the top of the stack.
def POP(S):
	top = S[0];
	del S[0]
	return top

# MAKENULL: make the stack empty.
def MAKENULL(S):
	S = []
	return S

# PUSH: insert the element x at the top of the stack.
def PUSH(x,S):
	# make temp, then shift everthing
	temp = S[:]
	S = MAKENULL(S)
	S.append(x)
	for element in temp:
		S.append(element)
	return S

# EMPTY: return true if the stack is empty, else return false.
def EMPTY(S):
	if len(S) == 0:
		return True
	else:
		return False

# main method to run functions.
def main():
	test = []
	test = PUSH(1,test)
	test = PUSH(2,test)
	test = PUSH(3,test)
	test = PUSH(4,test)
	test = PUSH(5,test)
	print test
	print "Testing Top (expect 5): "
	print TOP(test)
	print "Testing POP (expect 5): "
	print POP(test)
	print test
	print "Testing Push: "
	test = PUSH(7,test)
	test = PUSH(10,test)
	print test
	print "Testing Empty (expect false): "
	print EMPTY(test)
	print "Testing Makenull: "
	test = MAKENULL(test)
	print test
	print "Testing empty (expect true): "
	print EMPTY(test)


main()
