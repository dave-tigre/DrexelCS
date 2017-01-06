#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# List of children implementation of tree

import pointerlist
# class for tree
class tree():
	def __init__(self):
		self.children = None
		self.root = None

#  MAKENULL: make the tree null.
#	T: given tree.
def MAKENULL(T):
	T = tree()
	T.children = [None]*100
	return T	

# PARENT: returns the parent of given node in tree.
#	n: node
#	T: tree
def PARENT(n,T):
	# root has no parent (None)
	if T.children[T.root] == n:
		return None
	# use pointer to locate node
	else:
		for i in range(0, len(T.children)):
			# check until reach end
			if T.children[i] is not None:
				pos = pointerlist.LOCATE(n.data, T.children[i])
				# if node is not at end, beginning, or empty, it parent
				if pos != -1 and pos != 0 and pos is not None:
					return pointerlist.FIRST(T.children[i])
		return None # if not found return none, shouldn't get here

# LEFTMOST_CHILD: returns the leftmost child of node in tree.
#	n: node
#	T: tree
def LEFTMOST_CHILD(n,T):
	# loop through tree
	for i in range(len(T.children)):
		if T.children[i] is not None:
			# if element is the same, then return loc
			if LABEL(pointerlist.FIRST(T.children[i]),T) == LABEL(n,T):
				return pointerlist.NEXT_TREE(pointerlist.FIRST(T.children[i]))
	return None # if not found, return None

# RIGHT_SIBLING: retusnt eh right sibling of node in tree.
#	n: node
#	T: tree
def RIGHT_SIBLING(n,T):
	# loop through tree
	for i in range(0, len(T.children)):
		if T.children[i] is not None:
			pos = pointerlist.LOCATE(n.data, T.children[i])
			# if node not at end, beginning, or none, return right sibling
			if pos != 0 and pos != -1 and pos is not None:
				return pointerlist.NEXT_TREE(pointerlist.RETRIEVE(pos, T.children[i]))
	return None

# LABEL: returns the label of node in tree.
#	n: node
#	T: tree
def LABEL(n,T):
	return n.data
	for i in range(0, len(T.children)):
		if n == T.children[i]:
			t = T.children[i]
			return t.data

# ROOT: return the node that is the root of given tree.
# T: tree
def ROOT(T):
	# return first item in pointerlist (root)
	return pointerlist.FIRST(T.children[T.root])

# CREATE0: create new node with given label and no children.
#	v: label
def CREATE0(v):
	# makew new tree
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	#add label to children list
	new_tree.children[v] = pointerlist.ptr_list()
	# make the label the root
	new_tree.root = v
	# insert at end of pointer list
	pointerlist.INSERT(v, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	return new_tree # return the new tree node

# CREATE1: create a new tree with input tree as child
# v: label
# T: tree
def CREATE1(v, T):
	# make new tree
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	# add the tree as children of new tree
	for i in range(0, len(T.children)):
		if T.children[i] is not None:
			new_tree.children[i] = T.children[i]

	# label is child and root of new tree
	new_tree.children[v] = pointerlist.ptr_list()
	new_tree.root = v
	# insert label
	pointerlist.INSERT(v, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	# insert root of tree
	pointerlist.INSERT(T.root, pointerlist.END(new_tree.children[v]), new_tree.children[v])

	return new_tree # return new tree

# CREATE2: create new tree with input trees as children
# v: label
# T1: tree 1
# T2: tree 2
def CREATE2(v, T1, T2):
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	
	# same as CREATE1 but with two trees	
	for i in range(0, len(T1.children)):
		if T1.children[i] is not None:
			new_tree.children[i] = T1.children[i]
		elif T2.children[i] is not None:
			new_tree.children[i] = T2.children[i]

	new_tree.children[v] = pointerlist.ptr_list()
	new_tree.root = v

	pointerlist.INSERT(v, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	pointerlist.INSERT(T2.root, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	pointerlist.INSERT(T1.root, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	
	return new_tree

# CREATE3: create new tree with input trees as children
# v: label
# T1: tree 1
# T2: tree 2
# T3: tree 3
def CREATE3(v, T1, T2, T3):
	# same as CREATE1 but with 3 trees
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	
	for i in range(0, len(T1.children)):
		if T1.children[i] is not None:
			new_tree.children[i] = T1.children[i]
		elif T2.children[i] is not None:
			new_tree.children[i] = T2.children[i]
		elif T3.children[i] is not None:
			new_tree.children[i] = T3.children[i]
	
	new_tree.children[v] = pointerlist.ptr_list()
	new_tree.root = v
	
	pointerlist.INSERT(v, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	pointerlist.INSERT(T3.root, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	pointerlist.INSERT(T2.root, pointerlist.END(new_tree.children[v]), new_tree.children[v])
	pointerlist.INSERT(T1.root, pointerlist.END(new_tree.children[v]),new_tree.children[v])

	return new_tree

# PRINT: print tree inorder
# T: tree to print
def PRINT(T):
	for i in range(0, len(T.children)):
		if T.children[i] is not None:
			print i, "-",  
			pointerlist.PRINT(T.children[i])
