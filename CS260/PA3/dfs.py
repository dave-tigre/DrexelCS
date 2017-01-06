#!/usr/bin/env python

node = ['a', 'b', 'c', 'd', 'e', 'f']
mark = [False, False, False, False, False, False]
print node
print mark
print "Each node is set to False at the beginning of the program"
print ""

def dfs(i) :
	global mark
	
	# Converted node letters to numbers a=0, b=1, c=2, d=3, e=4, f=5
	# Each number is listed from left to right in each bracket by order of closeness
	# to current node in figure 6.38
	D = [[1, 3, 5], [2, 5], [3], [1], [3, 5], [3]]
	print node[i],
	mark[i] = True
	
	# Depth First Search from Fig 6.24
	for j in D[i]:
		if mark[j] == False:
			dfs(j)

print "Depth First Search Order:"
for i in range(6):
	if mark[i] == False:
		dfs(i)
	
		
