#!/usr/bin/env python
# Author: David Tigreros
# 8/08/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Merge Lists
# Write a program to merge 'n' sorted lists.

import arraylist
# function to merge sorted lists
def array_merge(L1, L2):
	result = []
	result = arraylist.MAKENULL(result)
	p1 = 0
	p2 = 0
	total = len(L1) + len(L2)
	
	while len(result) != total:
		if len(L1) == p1:
			for i in range(p2, len(L2)):
				arraylist.INSERT(L2[i],(len(result)-1), result)
			#result += L2[p2:]
			break
		elif len(L2) == p2:
			for j in range(p1,len(L1)):
				arraylist.INSERT(L1[j],(len(result),-1), result)
			#result += L1[p1:]
			break
		elif L1[p1] < L2[p2]:
			arraylist.INSERT(L1[p1], (len(result)-1), result)
			#result.append(L1[p1])
			p1 += 1
		else:
			arraylist.INSERT(L2[p2], (len(result)-1), result)
			#result.append(L2[p2])
			p2 += 1
	return result

# funtion to break down mulitple lists for merging
def merge_multi(l):
	if len(l) == 0:
		return
	elif len(l) == 1:
		return l[0]
	else:
		temp = array_merge(l[0], l[1])
		for i in range(2,len(l)):
			temp = array_merge(temp, l[i])
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

	merged_list = merge_multi(l)
	print "Merge of all four list"
	print merged_list	
main()
