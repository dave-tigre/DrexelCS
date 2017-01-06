#!/usr/bin/env python

# Author: David Tigreros
# 8/10/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assingment 2
# Test class for LCRS Tree

import lcrstree

def main():

	T1 = lcrstree.CREATE0(4)
	T2 = lcrstree.CREATE0(5)
	T3 = lcrstree.CREATE2(2,T1,T2)
	T6 = lcrstree.CREATE0(6)
	T7 = lcrstree.CREATE0(7)
	T4 = lcrstree.CREATE2(3, T6, T7)
 	T = lcrstree.CREATE2(1, T3, T4)
   	print "Printing Tree (inorder):"
   	lcrstree.PRINT(lcrstree.ROOT(T), T)
   	print
   	test = lcrstree.ROOT(T)
   	print "Testing Root (expect 1):"
   	print test
   	test = lcrstree.LEFTMOST_CHILD(test, T)
   	print "Testing Leftmost Child of Root (expect 2):"
   	print test
   	test = lcrstree.RIGHT_SIBLING(test, T)
   	print "Testing Right Sibling (expect 3):"
   	print test
   	test = lcrstree.PARENT(test, T)
   	print "Testing Parent of 3 (expect 1):"
   	print test
main()

