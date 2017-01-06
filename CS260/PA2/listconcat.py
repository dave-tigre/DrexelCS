#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Concatenate Lists
# Write a program to concatenate lists of lists.

import arraylist

# function to concatenate list
def concat_list(L1, L2):
	result = []
	result = arraylist.MAKENULL(result)
	p1 = 0
	p2 = 0
	total = len(L1) + len(L2)
	for i in range(0, len(L1)):
		arraylist.INSERT(L1[i],(len(result)-1),result)

	for j in range(0, len(L2)):
		arraylist.INSERT(L2[j],(len(result)-1), result)

	return result
# break down list of list
def concat_multi(l):
	if len(l) == 0:
		return
	elif len(l) == 1:
		return l[0]
	else:
		temp = concat_list(l[0], l[1])
		for i in range(2,len(l)):
			temp = concat_list(temp, l[i])
		return temp

def main():
	L1 = [] 
	L2 = [] 
	L3 = []
	L4 = [] 

	for i in xrange(11,1,-1):
		arraylist.INSERT(i,0,L1)
	
	for j in xrange(22,2,-2):
		arraylist.INSERT(j,0,L2)

	for k in xrange(33,3,-3):
		arraylist.INSERT(k,0,L3)

	for y in xrange(44,4,-4):
		arraylist.INSERT(y,0,L4)
	
	# print individual list
	print "L1: ",
	arraylist.PRINT(L1)
	print "L2: ",
	arraylist.PRINT(L2)
	print "L3: ",
	arraylist.PRINT(L3)
	print "L4: ",
	arraylist.PRINT(L4)

	# print merge of all four list
	l = [L1, L2, L3, L4]

	concated_list = concat_multi(l)
	print "Concatenate of all four list"
	print concated_list	
main()
