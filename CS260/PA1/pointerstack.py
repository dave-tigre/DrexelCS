#!/usr/bin/env python

# Author: David Tigreros
# 7/29/2016
# CS-260 Section 003
# Programming Assignment 1
# Pointer Implementation of Stack

class Node:
	def __init__(self):
		self.data = None
		self.n3xt = None
	
	def __str__(self):
		return str(self.data)

class ptr_stack:
	def __init__(self):
		self.top = None

# TOP: return the top element in the stack.
def TOP(S):
	return S.top

# POP: return and delete the element at the top of the stack.
def POP(S):
	S.top = S.top.n3xt
	return

# PUSH: insert the element x at the top of the stack.
def PUSH(x,S):
	# make temp, new top of stack
	temp = Node()
	temp.data = x
	temp.n3xt = S.top
	S.top = temp
	return

# EMPTY: return true if the stack is empty, else return false.
def EMPTY(S):
	if S.top is None:
		return True
	else:
		return False

# MAKENULL: make the stack empty.
def MAKENULL(S):
	S = ptr_stack()
	return S

# PRINT: print the stack.
def PRINT(S):
	temp = TOP(S)
	if temp is None:
		print
	else:
		while temp:
			print temp
			temp = temp.n3xt

# main method to run functions.
def main():
	test = ptr_stack()
	PUSH(1,test)
	PUSH(2,test)
	PUSH(3,test)
	PUSH(4,test)
	PRINT(test)
	print "Testing Top (expect 4): "
	print TOP(test)
	print "Testing Pop: "
	POP(test)
	PRINT(test)
	print "Testing Empty (expect false): "
	print EMPTY(test)
	print "Testing make null"
	test = MAKENULL(test)
	PRINT(test)
	print "Testing Empty: expect (true): "
	print EMPTY(test)

main()
