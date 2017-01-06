#!/usr/bin/env python

from __future__ import division
import random
import math

count = 1

class BSTNode:
	def __init__(self, value, left = None, right = None):
		self.value = value
		self.left = left
		self.right = right

	def __repr__(self):
		return "(%s, %s, %s)" % (self.value, self.left, self.right)

	# Membership Test Fig 5.2
	def member(self, x):
		if x is self.value:
				return self.value
		elif self.left is None and self.right is None:
			return False
		elif x < self.value:
			if self.left is not None:
				return self.left.member(x)
			else:
				return False
		else:
			if self.right is not None:
				return self.right.member(x)
			else:
				return False
	
	# Insert Function Fig 5.3
	def insert(self, x):
		global count
		if self.left is None and x < self.value:
			self.left = BSTNode(x)
			count = count + 1
		elif self.right is None and x > self.value:
			self.right = BSTNode(x)
			count = count + 1
		elif x < self.value:
			self.left.insert(x)	
		elif x > self.value:
			self.right.insert(x)
	
	# Delete Smallest Element Fig 5.4
	def deleteMin(self):
		if self.left == None:
			min = self.value
			self.value = self.right
			return min
		else:
			return self.left.deleteMin()

	# Delete from Tree Fig 5.5
	def delete(self, x):
		if x < self.value:
			return self.left.delete(x)
		elif x > self.value:
			return self.right.delete(x)	
		elif self.left == None and self.right == None:
			self.value = None
		elif self.left == None:
			self.value = self.right
		elif self.right == None:
			self.value = self.left
		else:	
			self.value = self.right.deleteMin()
			
class BST:
	def __init__(self, root = None):
		self.root = root

	def __repr__(self):
		return "%s" % self.root

	def member(self, x):
		if self.root is None:
			return False
		else:
			return self.root.member(x)

	def insert(self, x):
		global count
		if self.root is None:
			self.root = BSTNode(x)
		else:
			self.root.insert(x)

	def delete(self, x):
		if self.root is None:
			return False
		else:
			return self.root.delete(x)
			
def main(): 
	global count
	tree = BST()
	randList = random.sample(xrange(10), 10)
	print("Random sequence generated.")
	print(randList)
	print("Random Sequence inserted into tree.")
	print("")
	
	for i in randList:
		tree.insert(i)
	print("Resulting tree:")
	print tree
	print("")
	
	print("Deleting random member:")
	print tree.member(randList[3])
	print("")
	
	tree.delete(randList[3])
	print("Resulting tree:")
	print tree
	
	avg = float((count)/3)
	print ""
	print("Average number of inserts for a random sequence tree: ")
	print(avg)
	print "Log2(10) = ",math.log(10,2)
			

if __name__ == "__main__":
  main()
