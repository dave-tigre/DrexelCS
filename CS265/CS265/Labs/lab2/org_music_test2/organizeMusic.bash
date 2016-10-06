#!/bin/bash
# Author: David Tigreros
# CS265 Section003 Lab2
# organizeMusic.bash

# This script looks in the current directory only for mp3 files, breaks the
# filename out into artist and song title, creates the appropriate directory
# (if it doesnt't a;ready exist), removes the artist and the first '-' from
# the filename, and moves it into the directory

for file in *.mp3
do
	dir=${file%%\ -*}
	if [ -e $dir ]; then # checks to see if directory was already made
		mv "$file" "${file##*-\ }"
		mv "${file##*-\ }" "$dir"
	else
		mkdir -p "$dir"
		mv "$file" "${file##*-\ }"
		mv "${file##*-\ }" "$dir"

	fi
done		


