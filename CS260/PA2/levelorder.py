#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Level Order
# Problem 3.10 of the textbook
#	Print the level order listing of nodes of a tree

import pointerqueue
import lcrstree

# level order function
# n: node
# T: tree
# Q: queue
# p: position
def level_order(n, T, Q, p):
	# if theres not left child, 
	if lcrstree.LEFTMOST_CHILD(n, T) is None:
		# root is first level, add to queue and print
		if Q[p] is None:
			Q[p] = pointerqueue.ptr_queue()
		pointerqueue.ENQUEUE(n.label, Q[p])
		return
	# if more than just root
	else:
		# temp tree to hold left child
		temp = lcrstree.LEFTMOST_CHILD(n, T)
		# while there is a right sibling, add to queue
		while temp is not None:
			level_order(temp, T, Q, p+1)
			temp = lcrstree.RIGHT_SIBLING(temp, T)
			if Q[p] is None:
				#print queue
				Q[p] = pointerqueue.ptr_queue()
		pointerqueue.ENQUEUE(n.label, Q[p])

def main():
	T1 = lcrstree.CREATE0(4)
	T2 = lcrstree.CREATE0(5)
	T3 = lcrstree.CREATE2(2,T1,T2)
	T6 = lcrstree.CREATE0(6)
	T7 = lcrstree.CREATE0(7)
	T4 = lcrstree.CREATE2(3, T6, T7)
 	T = lcrstree.CREATE2(1, T3, T4)
	print
	print "Inorder Printing of Tree: ",
	lcrstree.PRINT(lcrstree.ROOT(T), T)	
	print
	print "Level-order print: "
	print
	test = [None]*100
	level_order(lcrstree.ROOT(T), T, test, 0)
	for i in range(0,len(test)) :
		if test[i] is not None :
			print "Level",i,':'
			pointerqueue.PRINT(test[i])

main()
