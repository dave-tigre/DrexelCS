#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Pointer Implementation of Queue

# class to hold pointer data
class Node:
	def __init__(self):
		self.data = None # hold data
		self.n3xt = None # next element
	
	def __str__(self):
		return str(self.data)

# pointer info
class ptr_queue:
	def __init__(self):
		self.front = None # front of the queue
		self.current = None # current element in queue

# MAKENULL: makes the queue empty.
def MAKENULL(Q):
	# make null by returning pointer as a new pointer
	Q = ptr_queue()
	return Q

# FRONT: return the front element in the queue.
def FRONT(Q):
	# return the front element of the queue
	return Q.front

# ENQUEUE: insert given element at the end of the queue.
def ENQUEUE(x,Q):
	# element becomes a new node at the end of the queue.
	end = Node()
	# have node hold element info
	end.data = x
	
	# if queue is empty, element is at the front
	if Q.front is None:
		Q.front = end
		Q.current = end
	# else iterate through until end is reached
	else:
		# temp node to hold front of queue
		temp = Q.front
		# while there are other elements loop until end is reached
		while temp.n3xt:
			temp = temp.n3xt
		# now end of temp will be new element node
		temp.n3xt = end 
		# the input queue now becomes the temp queue
		Q = temp
	return

# DEQUEUE: delete the first element of !
def DEQUEUE(Q):
	# the next element is now the new front of the node
	Q.front = Q.front.n3xt
	Q.current = Q.front
	return

# EMPTY: return true if the queue is empty.
def EMPTY(Q):
	# check if front of the node is none, if so it is empty
	if Q.front is None:
		return True
	else:
		return False

# PRINT: print the queue.
def PRINT(Q):
	temp = FRONT(Q);
	if temp is None:
		print
	# loop through queue and print element
	else:
		while temp:
			print temp
			temp = temp.n3xt
		print
