#!/usr/bin/env python

# Programming Assignment 3
# CS-260 Section-003
# 8/23/2016

# Trie of Alice in Wonderland
# Uses pointer list

# Using previously created pointer list
import pointerlist

# import system to read file
import sys

# global variable for word cout
global word_count

# getword: gets the node at the given position of the list. 
# p: position in pointer list
# L: given pointer list 
def getword(p, L):
	# make temp list
	temp = pointerlist.FIRST(L)
	# loop until node is found
	for i in range(0, p):
		if temp.n3xt != None:
			temp = temp.n3xt
	return temp

# addchild: Add child node to trie
# ltr: given letter in the list
# L: given pointer list
def addchild(ltr, L):
	f = pointerlist.ptr_list()
	n = pointerlist.Node()
	n.data = ltr
	L.child = f
	f.head = n
	f.cursor = f.head
	return f

# addword: add word to list
# x: wordtype
# L: given pointer list
def addword(x, L):
	global word_count
	f = L
	# for each letter in the word type
	for ltr in x:
		# if list not empty
		if f is not None:
			# if it did not locate letter, add it to the end
			if pointerlist.LOCATE(ltr,f) == -1:
				pointerlist.INSERT(ltr,pointerlist.END(f),f)
				# add the letter to trie as child node
				for let in x[x.index(ltr)+1:]:
					temp = addchild(let,f)
					f = temp
				addchild('$',f)
				word_count +=1
				return L
			else:
				L = getword(pointerlist.LOCATE(ltr,f),f).child
		else:
			# if list is empty, insert letters into list
			f = pointerlist.MAKENULL(f)
			pointerlist.INSERT(ltr,pointerlist.END(f),f)
			f = pointerlist.END(f)
			# add letter to trie as child node
			for let in x[x.index(ltr)+1:]:
				temp = addchild(let,f)
				f = temp
			addchild('$',f)
			word_count +=1
			return L
	return L

# main function to run program
def main():
	test = pointerlist.ptr_list(); 
	global word_count
	word_count = 0
	# parse input stdin file
	for line in sys.stdin.readlines():
		splitLine = line.strip().split(' ')
		for x in splitLine:
			test = addword(x.lower(), test)
	print "Trie size of Alice in Wonderland: ", word_count
main()
