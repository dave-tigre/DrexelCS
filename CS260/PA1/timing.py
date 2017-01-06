#!/usr/bin/env python

# Author: David Tigreros
# 7/29/2016
# CS-260 Section 003
# Dr. Nowak
# Programming Assingment 1
# Timing of the ADT Implementations
# Note: all output time is in milliseconds

# import for timing
from timeit import timeit, Timer

# import created ADT's
import arraylist
import arraystack
import pointerlist
import pointerstack

# main method 
def list_testing():
	#-----------------------------
	# Iterated Insertion Testing
	#------------------------------
	
	# Forward Testing
	print "Iterated Insertion Testing: Forward"
	print "Order: Built In, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
		def f_built_in():
			l = []
			for i in xrange(0,ADT_size):
				l.insert(0,i)
		time = Timer(f_built_in)
		print (time.timeit(1)*1000)
		
		def f_array_imp():
			array_imp = []
			array_imp = arraylist.MAKENULL(array_imp)
			for i in xrange(0,ADT_size):
				arraylist.INSERT(i,0,array_imp)
		time = Timer(f_array_imp)
		print (time.timeit(1)*1000)
	
		def f_ptr_imp():
			ptr_imp = pointerlist.ptr_list()
			for i in xrange(0,ADT_size):
				pointerlist.INSERT(i,0,ptr_imp)
		time = Timer(f_ptr_imp)
		print (time.timeit(1)*1000)
	
	f_built_in()
	f_array_imp()
	f_ptr_imp()
	print
	
	# Backward Testing
	print "Iteration Insertion Testing: Backward"
	print "Order: Built In, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
		def b_built_in():
	 		l = []
			reverse = ADT_size
			for i in xrange(0,ADT_size):
				l.append(i)
		time = Timer(b_built_in)
		print (time.timeit(1)*1000)
			
		def b_array_imp():
			array_imp = []
			reverse = ADT_size
			array_imp = arraylist.MAKENULL(array_imp)
			for i in xrange(0, ADT_size):
				arraylist.INSERT(i,reverse,array_imp)
				reverse = reverse - 1
		time = Timer(b_array_imp)
		print (time.timeit(1)*1000)

		def b_ptr_imp():
			ptr_imp = pointerlist.ptr_list()
			reverse = ADT_size - 1
			for i in xrange(0, ADT_size):
				pointerlist.INSERT(i, reverse, ptr_imp)
				reverse = reverse - 1
		time = Timer(b_ptr_imp)
		print (time.timeit(1)*1000)
	b_built_in()
	b_array_imp()
	b_ptr_imp()
	print

	#---------------------------------
	# Traversal
	#---------------------------------
	print "Traversal Testing"
	print "Order: Built Int, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
		# testing built in DS
		l = []
		for i in xrange(0,ADT_size):
			l.insert(0,i)
		def trav_built_in():
			for num in xrange(0,len(l)):
				t = l[i]
		time = Timer(trav_built_in)
		print (time.timeit(1)*1000)
		
		# testing array imp
		array_imp = []
		array_imp = arraylist.MAKENULL(array_imp)
		for i in xrange(0,ADT_size):
			arraylist.INSERT(i,0,array_imp)
		def trav_array_imp():
			for num in xrange(0,len(array_imp)):
				t = arraylist.RETRIEVE(num,array_imp)
		time = Timer(trav_array_imp)
		print (time.timeit(1)*1000)

		# testing pointer imp
		ptr_imp = pointerlist.ptr_list()
		for i in xrange(0,ADT_size):
			pointerlist.INSERT(i,0,ptr_imp)
		def trav_ptr_imp():
			p = 0
			temp = pointerlist.FIRST(ptr_imp)
			while temp:
				t = pointerlist.RETRIEVE(p,ptr_imp)
				p = p + 1
				temp = temp.n3xt
		time = Timer(trav_ptr_imp)
		print (time.timeit(1)*1000)

	trav_built_in()
	trav_array_imp()
	trav_ptr_imp()
	print
	
	#---------------------------------
	# Itereated Deletion
	#---------------------------------
	
	# Forward Testing
	print "Iteration Deletion Testing: Forward"
	print "Order: Built In, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
		# testing built in DS
		l = []
		for i in xrange(0,ADT_size):
			l.insert(0,i)
		def df_built_in():
			end = len(l) - 1
			for element in l:
				l.remove(element)
		time = Timer(df_built_in)
		print (time.timeit(1)*1000)

		# testing array imp
		array_imp = []
		array_imp = arraylist.MAKENULL(array_imp)
		for i in xrange(0,ADT_size):
			arraylist.INSERT(i,0,array_imp)
		def df_array_imp():
			for p in xrange(0,len(array_imp)):
				arraylist.DELETE(p,array_imp)
		time = Timer(df_array_imp)
		print (time.timeit(1)*1000)

		# testing pointer imp
		ptr_imp = pointerlist.ptr_list()
		for i in xrange(0,ADT_size):
			pointerlist.INSERT(i,0,ptr_imp)
		def df_ptr_imp():
			p = 0
			temp = ptr_imp.head
			while temp:
				pointerlist.DELETE(p,ptr_imp)
				temp = temp.n3xt
				p = p + 1
		time = Timer(df_ptr_imp)
		print (time.timeit(1)*1000)

	df_built_in()
	df_array_imp()
	df_ptr_imp()
	print

	# Backward Testing
	print "Iteration Deletion Testing: Backward"
	print "Order: Built In, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
		# testing built in DS
		l = []
		for i in xrange(0,ADT_size):
			l.insert(0,i)
		def db_built_in():
			last = len(l) - 1
			while(last > 0):
				del l[last]
				last = last - 1
		time = Timer(db_built_in)
		print (time.timeit(1)*1000)

		# testing array imp
		array_imp = []
		array_imp = arraylist.MAKENULL(array_imp)
		for i in xrange(0,ADT_size):
			arraylist.INSERT(i,0,array_imp)
		def db_array_imp():
			last = len(array_imp) - 1
			while( last > 0 ):
				arraylist.DELETE(last,array_imp)
				last = last - 1
		time = Timer(db_array_imp);
		print (time.timeit(1)*1000)
		
		# testing pointer imp
		ptr_imp = pointerlist.ptr_list()
		for i in xrange(0,ADT_size):
			pointerlist.INSERT(i,0,ptr_imp)
		def db_ptr_imp():
			last = ADT_size-1
			temp = ptr_imp.head
			while temp:
				pointerlist.DELETE(last,ptr_imp)
				last = last - 1
				temp = temp.n3xt
		time = Timer(db_ptr_imp)
		print (time.timeit(1)*1000)
	db_built_in()
	db_array_imp()
	db_ptr_imp()
	print
	
	############################################
	#### STACK TESTING #########################
	############################################

# Python stack method
class Stack:
	def __init__(self):
  		self.items = []

	def isEmpty(self):
		return self.items == []

	def push(self, item):
		self.items.append(item)

  	def pop(self):
		return self.items.pop(0)

	def peek(self):
		return self.items[len(self.items)-1]
	
	def size(self):
		return len(self.items)	

def stack_testing():
	#---------------------------------------------------
	# Iterated Insertion Push
	#--------------------------------------------------
	
	print "Stack Iterated Insertion (PUSH)"
	print "Order: Built in, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
		
		# testing built in
		def si_built_in():
			s = Stack()
			for i in xrange(0,ADT_size):
				s.push(i)
		time = Timer(si_built_in)
		print (time.timeit(1)*1000)
		
		# testing array
		def si_array_imp():
			array_imp = []
			array_imp = arraystack.MAKENULL(array_imp)
			for i in xrange(0,ADT_size):
				array_imp = arraystack.PUSH(i,array_imp)
		time = Timer(si_array_imp)
		print (time.timeit(1)*1000)

		# testing pointer imp
		def si_ptr_imp():
			ptr_imp = pointerstack.ptr_stack()	
			for i in xrange(0,ADT_size):
				pointerstack.PUSH(i,ptr_imp)
		time = Timer(si_ptr_imp)
		print (time.timeit(1)*1000)

	si_built_in()
	si_array_imp()
	si_ptr_imp()
	print
	
	#---------------------------------
	# Iterated Deletion POP
	#--------------------------------
	print "Stack Iterated Deletion (POP)"
	print "Order: Built In, Array, Pointer"
	print
	for ADT_size in xrange(500,3000,500):
		print
		print "Number of Elements: ",ADT_size
	
		# testing built in
		s = Stack()
		for i in xrange(0,ADT_size):
			s.push(i)
		def sd_built_in():
			for i in xrange(0,ADT_size):
				if s.isEmpty() == False:
					s.pop()
		time = Timer(sd_built_in)
		print (time.timeit(1)*1000)

		# testing array imp
		array_imp = []
		arraystack.MAKENULL(array_imp)
		for i in xrange(0,ADT_size):
			array_imp = arraystack.PUSH(i,array_imp)
		def sd_array_imp():
			for i in xrange(0,ADT_size):
				if arraystack.EMPTY(array_imp) == False:
					arraystack.POP(array_imp)
		time = Timer(sd_array_imp)
		print (time.timeit(1)*1000)

		# testing pointer imp
		ptr_imp = pointerstack.ptr_stack()
		for i in xrange(0,ADT_size):
			pointerstack.PUSH(i,ptr_imp)
		def sd_ptr_imp():
			for i in xrange(0,ADT_size):
				if pointerstack.EMPTY(ptr_imp) == False:
					pointerstack.POP(ptr_imp)
		time = Timer(sd_ptr_imp)
		print (time.timeit(1)*1000)

	sd_built_in()
	sd_array_imp()
	sd_ptr_imp()
	print 

list_testing()
stack_testing()

			

