#!/usr/bin/python
#
# enum.py - Idiom for enum types in Python 2
#
# Kurt Schmidt
# 7/15
#
#	Demonstrates: 
#
# Note:
#		There is an Enum module
#


def enum( *sequential, **named ) :
	enums = dict( zip( sequential, range( len( sequential ))), **named )
	return type( 'Enum', (), enums )

Colors = enum( 'RED', 'GREEN', 'BLUE' )
WkDays = enum( 'SUN', 'MON', 'TUES', 'WED', 'THURS', 'FRI', 'SAT' )

def main() :

	today = WkDays.TUES

	if today is WkDays.WED :
		print "It's Wednesday"
	
	c = Colors.BLUE

	if today is Colors.BLUE :
		print "Hmmm, not type safe"


if __name__ == '__main__' :
	main()
