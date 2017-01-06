# CS-260 Section-003
# Dr. Nowak
# 8/26/2016
# Programming Assingment 3
# Group 10:
#	David Tigreros
#	William Fligor
#	Tyler Reynolds
# Makefile

.PHONY: clean
PI=python
CC = g++
CFLAGS = -g -Wall

openhash:
	@chmod 755 .
	$(PI) openhash.py

closedhash:
	@chmod 755 .
	$(PI) closedhash.py

bst:
	@chmod 755 .
	$(PI) bst.py

trie:
	@chmod 755 .
	$(PI) trie.py < alice30.txt

dijkstra: dijkstra.cpp
	$(CC) $(CFLAGS) dijkstra.cpp -o dijkstra
	@./dijkstra
floyd:
	@chmod 755 .
	$(PI) floyd.py

dfs:
	@chmod 755 .
	$(PI) dfs.py

clean:
	@rm -f *.pyc dijkstra
