#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# List of children implementation of tree

# class for tree nodes
class tree_node():
	def __init__(self):
		self.label = None
		self.left_child = None
		self.right_sibling = None
		self.parent = None

	def __str__(self):
		return str(self.label)


# class for tree
class tree():
	def __init__(self):
		self.children = None
		self.root = None

# MAKENULL: make the tree null.
#  T: given tree.
def MAKENULL(T):
	T = tree()
	T.children = [None]*100
	return T

# PARENT: returns the parent of given node in tree.
#  n: node
#  T: tree
def PARENT(n,T):
	return T.children[n.parent]

# LEFTMOST_CHILD: returns the leftmost child of node in tree.
#  n: node
#  T: tree
def LEFTMOST_CHILD(n,T):
	# if left child is empty, return None
	if n.left_child == None:
		return None
	else:
		return T.children[n.left_child]
	print "Error: ", n, " is not a part of given tree!"

# RIGHT_SIBLING: return the right sibling of node in tree.
#  n: node
#  T: tree
def RIGHT_SIBLING(n,T):
	if n.right_sibling is None:
		return None
	else:
		return T.children[n.right_sibling]
	print "Error: ", n, "is not a part of given tree!"

# LABEL: returns the label of node in tree.
#  n: node
#  T: tree
def LABEL(n,T):
	return n.label

# ROOT: return the node that is the root of given tree
# T: tree
def ROOT(T):
	return T.children[T.root]

# CREATE: create new nodes with given label and roots of trees.
#  v: label
#  lT: list of trees
def CREATE0(v):
	# create new tree
	new_tree = tree()
	new_tree = MAKENULL(new_tree)	
	# add label to tree, make it the root
	new_tree.children[v] = tree_node()
	new_tree.children[v].label = v

	new_tree.root = v
	return new_tree	

# CREATE1: create new tree from label and tree
# v: label
# T: input tree
def CREATE1(v, T):
	# create new tree
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	
	# loop through tree, make it child of new tree
	for i in range(0, len(T.children)):
		if T.children[i] is not None:
			new_tree.children[i] = T.children[i]
	# new roots
	new_tree.children[v] = tree_node()
	new_tree.children[T.root] = tree_node()
	# input label
	new_tree.children[v].label = v
	new_tree.children[v].left_child = T.root
	new_tree.children[v].right_sibling = None
	# update T as child tree
	new_tree.children[T.root].label = T.root
	new_tree.children[T.root].right_sibling = None
	new_tree.children[T.root].parent = v
	# make label the new root
	new_tree.root = v
	#return new tree
	return new_tree

def CREATE2(v, T1, T2):
	# make new tree
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	# same as CREATE1 but with 2 trees
	# 100 is the max number of nodes in tree
	for i in range(0, 100):
		if T1.children[i] is not None:
			new_tree.children[i] = T1.children[i]
		elif T2.children[i] is not None:
			new_tree.children[i] = T2.children[i]

	new_tree.children[v] = tree_node()
	new_tree.children[T1.root] = tree_node()
	new_tree.children[T2.root] = tree_node()

	new_tree.children[v].label = v
	new_tree.children[v].left_child = T1.root
	new_tree.children[v].right_sibling = None

	new_tree.children[T1.root] = T1.children[T1.root]
	new_tree.children[T1.root].right_sibling = T2.root
	new_tree.children[T1.root].parent = v

	new_tree.children[T2.root] = T2.children[T2.root]
	new_tree.children[T2.root].parent = v
	new_tree.children[T2.root].right_sibling = None

	new_tree.root = v
	
	return new_tree

def CREATE3(v, T1, T2, T3):
	new_tree = tree()
	new_tree = MAKENULL(new_tree)
	# same as other CREATE functions but with 3 trees
	for i in range(0, 100):
		if T1.children[i] is not None:
			new_tree.children[i] = T1.children[i]
		elif T2.children[i] is not None:
			new_tree.children[i] = T2.children[i]
		elif T3.children[i] is not None:
			new_tree.children[i] = T3.children[i]

	new_tree.children[v] = tree_node()
	new_tree.children[T1.root] = tree_node()
	new_tree.children[T2.root] = tree_node()
	new_tree.children[T3.root] = tree_node()

	new_tree.children[v].label = v
	new_tree.children[v].left_child = T1.root
	new_tree.children[v].right_sibling = None

	new_tree.children[T1.root] = T1.children[T1.root]
	new_tree.children[T1.root].right_sibling = T2.root
	new_tree.children[T1.root].parent = v

	new_tree.children[T2.root] = T2.children[T2.root]
	new_tree.children[T2.root].right_sibling = T3.root
	new_tree.children[T2.root].parent = v
	
	new_tree.children[T3.root] = T3.children[T3.root]
	new_tree.children[T3.root].parent = v	
	new_tree.children[T3.root].right_sibling = None

	new_tree.root = v

	return new_tree

# PRINT: print tree inorder
def PRINT(n,T):
	if n.left_child is None:
		print n,
	else:
		PRINT(T.children[n.left_child],T)
		print n,
		temp = LEFTMOST_CHILD(n,T)
		temp = RIGHT_SIBLING(temp,T)
		while temp is not None:
			PRINT(temp, T)
			temp = RIGHT_SIBLING(temp, T)
