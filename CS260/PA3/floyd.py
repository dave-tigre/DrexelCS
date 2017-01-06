#!/usr/bin/env python

# Floyd's Shortest Path Program from Fig 6.17
def floyd(c,a,p):
	for i in range(len(a)):
		for j in range(len(a)):
			a[i][j] = c[i][j]
			p[i][j] = 0
	for i in range(len(a)):
		a[i][i] = 0
	for k in range(len(a)):
		for i in range(len(a)):
			for j in range(len(a)):
				if (a[i][k] + a[k][j] < a[i][j]):
					a[i][j] = a[i][k] + a[k][j]
					p[i][j] = k

# Shortest Path Print Program from Fig 6.18
def path(i,j):
	global p
	temp = p
	k = temp[i][j]
	if k == 0:
		return;
	path(i,k)
	print k
	path(k,j)

def print_matrix(m):
	for i in range(len(m)):
		for j in range(len(m)):
			print m[i][j],
		print ""

# Shortest Paths		
a = [[0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0]]

# Arc Costs
c = [[0, 4, 1, 5, 8, 10],
	 [0, 0, 0, 0, 0, 0],
	 [0, 2, 0, 0, 0, 0],
	 [0, 0, 0, 0, 2, 0],
	 [0, 0, 0, 0, 0, 1],
	 [0, 0, 0, 0, 0, 0]]

# Mid Point of Shortest Path
p = [[0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0],
	 [0, 0, 0, 0, 0, 0]]
	
floyd(c,a,p)
print "Matrix A"
print_matrix(a)
print
print "Matrix P"
print_matrix(p)
print ""

for i in range(6):
	print("path from 0 to " + str(i) + ":")
	print path(0,i)