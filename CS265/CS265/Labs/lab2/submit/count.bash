#!/bin/bash
# Author: David Tigreros
# CS265 Section003 Lab2
# count.bash

# This script prints the filename, the number of lines, and the number of
# words to stdout

for file in *
do
	echo "$file $(wc -lw <$file) "
done
