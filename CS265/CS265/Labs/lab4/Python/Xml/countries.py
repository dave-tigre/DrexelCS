#!/usr/bin/env python
#
# countries - example parsing XMl using xml.etree
#   taken right from
#   http://docs.python.org/2.7/library/xml.etree.elementtree.html
#
# Kurt Schmidt
# JAN 2014
#
# Python 2.6.5 on
# CYGWIN_NT-6.1 1.7.9(0.237/5/3) 2011-03-29 10:10 i686 Cygwin
#
# EDITOR:  tabstop=2, cols=80
#

import xml.etree.ElementTree as ET
import sys

filename = 'countries.xml'

def printElement( el, ind, of=sys.stdout, indent_string='   ' ) :
	'''prints various atributes of an element,
	recursively calls itself on child elements.
	ind - level of indent (uses indent_string)'''

	of.write( indent_string*ind +
		"Tag:  " + el.tag + "\n" )

	atts = el.attrib
	if len( atts ) > 0 :
		of.write( indent_string*ind +
			"Attributes:  " + str(atts) + "\n" )
	
	text = el.text
	if text is not None and len( text.strip() ) > 0 :
		of.write( indent_string*ind +
			"Text:  " + text.strip() + "\n" )

	# visit child elements
	for c in el :
		printElement( c, ind+1 )

	of.write( indent_string*ind +
		"-----------------\n" )

def main( args=sys.argv ) :

	fout = sys.stdout

	tree = ET.parse( filename )
	root = tree.getroot()   # root is an element

	fout.write( "Here's the tree:\n" )
	printElement( root, 1, fout )

	fout.write( "Use find to get the first child of a type:\n" )
	sc = root.find( 'country' )

	fout.write( "Use get(key) to access attributes:\n" )
	name = sc.get( 'name' )
	fout.write( '\tName is: ' + name + '\n\n' )

	fout.write( "Use findall to get all children of a type:\n" )
	for n in sc.findall( 'neighbor' ) :
		fout.write( '\t\tNeighbor: ' + n.get('name') +
								', Direction: ' + n.get('direction') + '\n' )
	fout.write( '\n' )

	fout.write( "We can also search recursively for interesting elements:\n" )
	for y in root.getiterator( 'year' ) :
		fout.write( y.text.strip() + '\n' )


if __name__ == '__main__' :
	sys.exit( main())
