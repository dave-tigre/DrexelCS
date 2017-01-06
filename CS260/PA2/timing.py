#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Timing of pre-order and post-order traversals of full trees.

# import for timing
from timeit import timeit, Timer

# import tree ADT's
import loctree
import lcrstree

##################################################
########### Preorder Time Testing ################
##################################################

#----------------------------------------
# List of Children Tree Testing
#----------------------------------------

def pr_loctree_test():
	print
	# function to create 3 degree trees
	def create_loctree(v,n):
		if n == 0:
			return loctree.CREATE0(v)
		else:
			return loctree.CREATE3(v, create_loctree((3*n)-1,n-1), create_loctree((3*n),n-1),create_loctree((3*n)+1,n-1))
	# funtion to traverse through trees
	def preorder_traverse_loctree(n,T):
		if loctree.LEFTMOST_CHILD(n,T) is None:
			return
		else:
			preorder_traverse_loctree(loctree.LEFTMOST_CHILD(n,T),T)
			temp = loctree.LEFTMOST_CHILD(n,T)
			temp = loctree.RIGHT_SIBLING(temp,T)
			while temp is not None:
				preorder_traverse_loctree(temp,T)
				temp = loctree.RIGHT_SIBLING(temp,T)

	test = loctree.tree()
	# Testing traversal time
	print "Testing LOC Tree Preorder Traversal"
	print "Size"," | ", "Time (millis)"
	print "----------------------------"
	for size in xrange(1,5,1):
		test = create_loctree(1,size)
		def loctree_trav():
			preorder_traverse_loctree(loctree.ROOT(test),test)
		time = Timer(loctree_trav)
		travtime = time.timeit(1)
		print size, " 	| ", travtime*1000
	print

#---------------------------------------------
# Left-child, Right-sibling Tree Timing
#--------------------------------------------
def pr_lcrstree_test():
	print
	# function to create 3 degree trees
	def create_lcrstree(v,n):
		if n == 0:
			return lcrstree.CREATE0(v)
		else:
			return lcrstree.CREATE3(v, create_lcrstree((3*n)-1,n-1), create_lcrstree((3*n),n-1),create_lcrstree((3*n)+1,n-1))
	# function to traverse tree
	def preorder_traverse_lcrstree(n,T):
		if lcrstree.LEFTMOST_CHILD(n,T) is None:
			return
		else:
			preorder_traverse_lcrstree(lcrstree.LEFTMOST_CHILD(n,T),T)
			temp = lcrstree.LEFTMOST_CHILD(n,T)
			temp = lcrstree.RIGHT_SIBLING(temp,T)
			while temp is not None:
				preorder_traverse_lcrstree(temp,T)
				temp = lcrstree.RIGHT_SIBLING(temp,T)

	test = lcrstree.tree()
	# Testing traversal time
	print "Testing LCRS Tree Preorder Traversal"
	print "Size"," | ", "Time (millis)"
	print "----------------------------"
	for size in xrange(1,5,1):
		test = create_lcrstree(1,size)
		def lcrstree_trav():
			preorder_traverse_lcrstree(lcrstree.ROOT(test),test)
		time = Timer(lcrstree_trav)
		travtime = time.timeit(1)
		print size, " 	| ", travtime*1000
	print

pr_loctree_test()
pr_lcrstree_test()

'''
###################################################
########## Post Order Time Testing ################
###################################################

#----------------------------------------
# List of Children Tree Testing
#----------------------------------------

def po_loctree_test():
	print
	# function to create 3 degree trees
	def create_loctree(v,n):
		if n == 0:
			return loctree.CREATE0(v)
		else:
			return loctree.CREATE3(v, create_loctree((3*n)-1,n-1), create_loctree((3*n),n-1),create_loctree((3*n)+1,n-1))
	# funtion to traverse through trees
	def postorder_traverse_loctree(n,T):
		if loctree.LEFTMOST_CHILD(n,T) is None:
			return
		else:
			postorder_traverse_loctree(loctree.LEFTMOST_CHILD(n,T),T)
			temp = loctree.LEFTMOST_CHILD(n,T)
			temp = loctree.RIGHT_SIBLING(temp,T)
			while temp is not None:
				postorder_traverse_loctree(temp,T)
				temp = loctree.RIGHT_SIBLING(temp,T)

	test = loctree.tree()
	# Testing traversal time
	print "Testing LOC Tree Post-Order Traversal"
	print "Size"," | ", "Time (millis)"
	print "----------------------------"
	for size in xrange(1,5,1):
		test = create_loctree(1,size)
		def loctree_trav():
			postorder_traverse_loctree(loctree.ROOT(test),test)
		time = Timer(loctree_trav)
		travtime = time.timeit(1)
		print size, " 	| ", travtime*1000
	print

#---------------------------------------------
# Left-child, Right-sibling Tree Timing
#--------------------------------------------
def po_lcrstree_test():
	print
	# function to create 3 degree trees
	def create_lcrstree(v,n):
		if n == 0:
			return lcrstree.CREATE0(v)
		else:
			return lcrstree.CREATE3(v, create_lcrstree((3*n)-1,n-1), create_lcrstree((3*n),n-1),create_lcrstree((3*n)+1,n-1))
	# function to traverse tree
	def postorder_traverse_lcrstree(n,T):
		if lcrstree.LEFTMOST_CHILD(n,T) is None:
			return
		else:
			postorder_traverse_lcrstree(lcrstree.LEFTMOST_CHILD(n,T),T)
			temp = lcrstree.LEFTMOST_CHILD(n,T)
			temp = lcrstree.RIGHT_SIBLING(temp,T)
			while temp is not None:
				postorder_traverse_lcrstree(temp,T)
				temp = lcrstree.RIGHT_SIBLING(temp,T)

	test = lcrstree.tree()
	# Testing traversal time
	print "Testing LCRS Tree Post-Order Traversal"
	print "Size"," | ", "Time (millis)"
	print "----------------------------"
	for size in xrange(1,5,1):
		test = create_lcrstree(1,size)
		def lcrstree_trav():
			postorder_traverse_lcrstree(lcrstree.ROOT(test),test)
		time = Timer(lcrstree_trav)
		travtime = time.timeit(1)
		print size, " 	| ", travtime*1000
	print

po_loctree_test()
po_lcrstree_test()
'''
