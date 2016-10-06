#!/usr/bin/python
#
# Author: David Tigreros
# CS265 Section003 Lab4
# 4/23/2016
# id2.py
# Stores entries in a dictionary (ID and Name).
# Outputs into 2 columns, sorted by ID
# Either takes file argument or allows user to stdin

import sys
# initialize data
if len( sys.argv ) < 2 :
	data = sys.stdin;
else :
	data = file( sys.argv[1], "r" );
id_dict = dict(); # initialize dictionary
# iterate through data lines
for l in data :
	name = ''; # initialize id name
	row = l.split(); 
	# iterate through each line
	for j in row[1:] :
		# create name for id
		name = name +' ' + j;
	# place id key and name in dictionary
	id_dict[ row[0] ] = name;
# iterate through dictionary
for i in id_dict :
	print i, id_dict[i]
