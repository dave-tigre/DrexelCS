#!/bin/bash
# Author: David Tigreros
# CS265 Section003 Lab2
# reextend.bash

# This script accepts two file extensions as command line arguments and
# renames all files with the first extention within the current working
# directory to have the second extension instead


if (( $# < 1)) ; then  # This if statement makes sure there are some args
	echo -e "\n Need to input arguments!\n"
	exit
fi

if (($# > 2)) ; then # this makes sure theres no more than 2 args
	echo -e  "\nThis only accepts 2 arguments!\n"
	exit
fi

# Lets the user know what files are being changed to what
echo -e "\nThe $1 files in this folder have change to $2 files\n"

# goes through the directory and looks for files matching the first arg
for file in *$1
do
	mv "$file" "${file%$1}$2" # uses the mv command to rename the files to arg 2
done

