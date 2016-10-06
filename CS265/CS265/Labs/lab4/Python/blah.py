#!/usr/bin/python

import sys

args = sys.argv

if len( args ) < 2 :
	print "using stdin\n"
	f = sys.stdin
else :
	print "using %s\n" % args[1]
	f = open( args[1] )

for l in f :
	print l.rstrip()

