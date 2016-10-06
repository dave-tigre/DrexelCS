#!/usr/bin/python
#
# Author: David Tigreros
# CS265 Section003 Lab4
# 4/23/2016
# id.py
# Stores entries in a dictionary (ID and Name).
# Outputs into 2 columns, sorted by ID

import sys
# import first argument
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
