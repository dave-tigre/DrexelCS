#!/usr/bin/python
#
# Author: David Tigreros
# CS265 Section003 Lab4
#
# s2.py
# Computes the average of all of the scores of the student
# in the student csv file.


f = file( "students.csv", "r" );
stud_list = list(); # student list
# iterate through lines in file
for l in f :	
	# initialize values
	count = 0;
	avg = 0;
	# split list using ',' delimiter
	stud_list = l.split(',');
	name = stud_list[0]
	# iterate through scores
	for sc in stud_list[1:] :
		avg = avg + int ( sc );
		count = count + 1;
	# calculate average
	avg = avg/count;
	print name, avg;
	
