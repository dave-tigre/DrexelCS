#!/usr/bin/env python

# Author: David Tigreros
# 8/10/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Test class for LOC Tree

import loctree

def main():
	T1 = loctree.CREATE0(4)
	T2 = loctree.CREATE0(5)
	T3 = loctree.CREATE2(2,T1,T2)
	T6 = loctree.CREATE0(6)
	T7 = loctree.CREATE0(7)
	T4 = loctree.CREATE2(3, T6, T7)
 	T = loctree.CREATE2(1, T3, T4)
   	print "Print Tree [parent-{children(including itself)}]: "
   	loctree.PRINT(T)
   	print
   	test = loctree.ROOT(T)
   	print "Testing Root (expect 1):", test
   	test = loctree.LEFTMOST_CHILD(test, T)
   	print "Testing Leftmost Child (expect 2):",test
   	test = loctree.LEFTMOST_CHILD(test, T)
   	print "Testing Next Left Most Child (expect 5):",test
   	test = loctree.RIGHT_SIBLING(test, T)
   	print "Testing Right Sibling (expect 6):",test
   	test = loctree.PARENT(test, T)
   	print "Testing Parent (expect 2):",test

main()
