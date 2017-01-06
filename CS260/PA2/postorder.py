#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Post Order
# 	Problem 3.14b from textbook
# Evaluate Postorder binary tree arithmetic expressions

# postorder_calc: evaluate postorder arithmetic expressions
# T: postorder Tree input
# recursive program
def postorder_calc(T):
	# root operator is at end of Tree
	end = len(T) - 1
	half = ((len(T)-1)/2)
	# most basic form (two numbers, single operator)
	if len(T) == 3:
		if T[end] == '+':
			return T[0] + T[1]
		elif T[end] == '-':
			return T[0] - T[1]
		elif T[end] == '*':
			return T[0] * T[1]
		elif T[end] == '/':
			return T[0] / T[1]
	else:
		if T[end] == '+':
			return postorder_calc(T[:half]) + postorder_calc(T[half:end])
		elif T[end] == '-':
			return postorder_calc(T[:half]) - postorder_calc(T[half:end]) 
		elif T[end] == '*':
			return postorder_calc(T[:half]) * postorder_calc(T[half:end]) 
		elif T[end] == '/': 
			return postorder_calc(T[:half]) / postorder_calc(T[half:end]) 
	return "Error" # should not get here

# main funciton to test
def main():
	print
        print "Testing With Simple Addition (5 + 4 = 9)"
        T1 = [5,4,'+']
        print "Tree Preorder: ", T1
        print "Result: ",  postorder_calc(T1)
        print
        print "Testing With higher order addition ((5+4)+(6+8) = 23):"
        T2 = [5,4,'+',6,8,'+','+']
        print "Tree postorder: ", T2
        print "Result: ", postorder_calc(T2)
	print
        print "Testing With mulitplication  ((5*4)*(6*8) = 960):"
        T3 = [5,4,'*',6,8,'*','*']
        print "Tree postorder: ", T3
        print "Result: ", postorder_calc(T3)
        print
        print "Testing With division ((20/5)/(2/1) = 2):"
        T = [20,5,'/',2,1,'/','/']
        print "Tree postorder: ", T
        print "Result:", postorder_calc(T)
        print
        print "Testing With mixed operators ([(20-7)*(2/1)]*[(500/10)-(35+5)] = 260):"
        T = [20,7,'-',2,1,'/','*',500,10,'/',35,5,'+','-','*']
        print "Tree postorder: ", T
        print "Result: ", postorder_calc(T)
        print
main()
