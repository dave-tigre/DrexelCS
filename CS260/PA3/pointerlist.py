#!/usr/bin/env python

# Author: David Tigreros
# 7/29/2016
# CS-260 Section 003
# Dr. Nowak
# Programming Assignment 1
# Pointer Implementation of List

# node to hold info in pointer
class Node:
	def __init__(self):
		self.data = None
		self.n3xt = None
		self.child = None

	def __str__(self):
		return str(self.data)
# pointer info
class ptr_list:
	def __init__(self):
		self.head = None
		self.cursor = None
	def __len__(self):
		return len(self)

# FIRST: method to return first item in list.
def FIRST(L):
	return L.head

# END: method to return last item in list.
def END(L):
	# check if list actually contains info, not null
	if L.head is None and L.cursor is None:
		return None
	# else create temp, iterate until end, return end
	else:
		temp = L.head
		while temp.n3xt:
			temp = temp.n3xt
		return temp

# RETRIEVE: return element at a given position of list.
def RETRIEVE(p,L):
	# create temp
	temp = L.head
	# iterate until position is reached, then return
	for n in range(0, p):
		if temp.n3xt  != None :
			temp = temp.n3xt
	return temp


# LOCATE: return the position of a given element in list.
def LOCATE(x,L):
	p = 0
	temp = FIRST(L)
	# iterate until found, keep count for position
	while temp:
		if temp.data == x:
			return p
		else:
			p = p + 1
			temp = temp.n3xt
	# return none if not found
	return -1

# NEXT: return the next element following a given position.
def NEXT(p,L):
	temp = L.head
	loc = 0
	# iterate with position count, return element after the position
	while temp:
		if loc == (p+1):
			return temp
		else:
			temp = temp.n3xt
		loc = loc + 1
	return None

# NEXT_TREE: added for use with trees
def NEXT_TREE(p):
		return p.n3xt
	
# PREVIOUS: return the previous element proceding a given position.
def PREVIOUS(p,L):
	temp = L.head
	loc = 0
	# iterate with position count, return element before position
	while temp :
		if loc  == (p-1) :
			return temp
		else:
			temp = temp.n3xt
		loc = loc + 1
	return None

# INSERT: insert an element at a given position.
def INSERT(x,p,L):
	# create new node
	node = Node()
	# add element to node
	node.data = x
	# if list is empty, make element the head
	if p is None:
		node.n3xt = None
		L.head = node
		L.cursor = L.head
		return
	# if insert position is at 0 aka first element in non-empty list
	elif (p == 0) or (p == FIRST(L) and FIRST(L) != END(L)):
		# make new element the head
		node.n3xt = L.head
		L.head = node
		L.cursor = L.head
		return
	# else other position
	else:
		# check if list is empty
		if L.head is None:
			L.head = node
			L.cursor = node
		# else make temp
		else:
			temp = FIRST(L)
			# loop until position is reached
			while temp and p > 1:
				temp = temp.n3xt
				p = p - 1
			if temp:
				# make node the temp
				node.n3xt = temp.n3xt
				temp.n3xt = node
		return

# MAKENULL: makes a list null and returns the end of the list
def MAKENULL(L):
	L = ptr_list()
	return L

# DELETE: delete the element at a given position.
def DELETE(p,L):
	temp = L.head
	# make temp
	if p == 0:
		# list starts from element after temp head
		L.head = temp.n3xt
	# if end of list
	elif p == END(L):
		# check if list has more than one element
		if temp.n3xt == None:
			L = MAKENULL(L)
		# else iterate until end of list, make it none
		else:
			while (temp.n3xt).n3xt :
				temp = temp.n3xt
			temp.n3xt = None
	else:
		# else loop until position is found, get before and after
		while temp and (p - 1) > 0:
				temp = temp.n3xt
				p = p - 1
		before = temp
		if temp is not None:
			if temp.n3xt is not None:
				after = temp.n3xt
		else:
			after = None
		if before is not None:
			if before.n3xt is not None:
				before.n3xt = after.n3xt
	L.cursor = L.head

# PRINT: print the given list
def PRINT(L):
	temp = FIRST(L)
	if temp is None:
		print "list is empty"
	else:
		while temp:
			print temp,
			temp = temp.n3xt
	print
