#!/usr/bin/env python

# Author: David Tigreros
# 7/29/2016
# CS-260 Section 003
# Dr. Nowak
# Programming Assingment 1
# Array Implementation of List

# FIRST: method to return first item in list
def FIRST(L):
	return L[0]

# END: method to return last item in list
def END(L):
	end = len(L) - 1;
	return L[end]

# RETRIEVE: return element at a given position of list.
def RETRIEVE(p,L):
	end = len(L) - 1;
	if p < 0 :
		print "Error: Position needs to be from 0 to "
		print end
	elif p > end:
		print "Error: Position needs to be from 0 to "
		print end
	else:
		return L[p]

# LOCATE: return the position of a given element in list.
def LOCATE(x,L):
	p = 0
	# iterate until the element is located, else return end
	for element in L:
		if element == x:
			return p
			break
		p = p+1;
	else:
		return END(L)

# MAKENULL: makes a list null and returns end of list
def MAKENULL(L):
	# delete contents of array
	del L[:]
	return L

# DELETE: delete the element at a given position of list.
def DELETE(p,L):
	# create temps with elements before and after position
	temp1 = L[:p]
	temp2 = L[(p+1):]
	# make array null, then add temps
	L = MAKENULL(L)
	L.extend(temp1)
	L.extend(temp2)

# NEXT: return the next element following a given position
def NEXT(p,L):
	# loop until next position, return element
	if (p+1) > (len(L)-1) :
		return END(L)
	else:
		return L[p+1]

# PREVIOUS: return the previous element preceding a given position.
def PREVIOUS(p,L):
	# return previous element, unless invalid entry
	if p > 0:
		return L[p-1]
	else:
		return L[0]

# INSERT: insert an element at a given position.
def INSERT(x,p,L):
	# if at end, just append
	if p >= (len(L)):
		L.append(x)
	# else make temps, then add
	else:
		temp1 = L[:p]
		temp2 = [x]
		temp3 = L[p:]
		L = MAKENULL(L)
		L.extend(temp1)
		L.extend(temp2)
		L.extend(temp3)

def PRINT(L):
	print L
