#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Pre-Order
# Problem 3.14a of textbook
# 	Preorder program to evaluate arithmetic expressions

# preorder_calc: evaluate preorder arithmetic expressions
# T: preorder Tree input
# recursive program
def preorder_calc(T):
	# most basic version (if just two numbers and an operation)
	half = ((len(T)+1)/2)
	if len(T) == 3:
		if T[0] == '+':
			return T[1] + T[2]
		elif T[0] == '-':
			return T[1] - T[2]
		elif T[0] == '*':
			return T[1] * T[2]
		elif T[0] == '/':
			return T[1] / T[2]
	# else call function recursively until broken down into single number
	else:
		if T[0] == '+':
			return preorder_calc(T[1:half]) + preorder_calc(T[half:])
		elif T[0] == '-':
			return preorder_calc(T[1:half]) - preorder_calc(T[half:])
		elif T[0] == '*':
			return preorder_calc(T[1:half]) * preorder_calc(T[half:])
		elif T[0] == '/':
			return preorder_calc(T[1:half]) / preorder_calc(T[half:])
	return "Error" # should not get here

# main function to test
def main():
	print
	print "Testing With Simple Addition (5 + 4 = 9)"
	T1 = ['+',5,4]
	print "Tree Preorder: ", T1
	print "Result: ",  preorder_calc(T1)
	print
	print "Testing With higher order addition ((5+4)+(6+8) = 23):"
	T2 = ['+','+',5,4,'+',6,8]
	print "Tree preorder: ", T2
	print "Result: ", preorder_calc(T2)
	print
	print "Testing With mulitplication  ((5*4)*(6*8) = 960):"
        T3 = ['*','*',5,4,'*',6,8]
        print "Tree preorder: ", T3
        print "Result: ", preorder_calc(T3)
	print
	print "Testing With division ((20/5)/(2/1) = 2):"
        T = ['/','/',20,5,'/',2,1]
        print "Tree preorder: ", T
        print "Result:", preorder_calc(T)
	print
	print "Testing With mixed operators ([(20-7)*(2/1)]*[(500/10)-(35+5)] = 260):"
        T = ['*','*','-',20,7,'/',2,1,'-','/',500,10,'+',35,5]
        print "Tree preorder: ", T
        print "Result: ", preorder_calc(T)
	print
main()
