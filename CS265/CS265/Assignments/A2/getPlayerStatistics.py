#!/usr/local/bin/python
#----------------------
# Author: David Tigreros
# 05/04/2016
# CS265 Section003 Assignment2
#
# getPlayerStatistics
#
# This program reads in Baseball statistics for players on various teams
# from a CSV file and display statistical information for a specified
# player.
# User can find a player, then the statistics will be displayed.

import sys 
import re

# main function parses data and initializes lists
def main() : 	
	# check if number of arguments is valid
	if len( sys.argv ) < 2 :
		print "Error: need to enter an argument!" 
		sys.exit();
	elif len ( sys.argv) > 2 :
		print "Error: cannot have more than one argument!"
		sys.exit();
	else :
		stats_file = sys.argv[1]

	# initialize lists
	teams = []
	roster = {}
	player_stats = {}

	# read and iterate through input file
	team_data = open( stats_file, "r" )
	for l in team_data :
		l = l.strip() 
		col = l.split(',') 
		team = col[2] 
		# check if team is already in map key list, if not then add it and
		# sort, then initiate roster values
		if team not in roster.keys():	
			if team not in teams:
				teams.append(team)
				teams.sort()
			roster[team] = [] 
		team_players = roster[team] 
		last_name = col[0]
		# check if last name is in list, if not then add it and sort
		if last_name not in team_players:
			team_players.append(last_name)
			team_players.sort()
		roster[team] = team_players 
		player_stats[col[0]] = col 
	return(teams, roster, player_stats)

# navigate function creates 'interface' for user to navigate team list and
# 	find players
def navigate(teams, roster, player_stats):
	# iterate though team list and display interface for user 
	print '\nID Teams\n----------'
	for i in range(len(teams)):
		print '%s %s' %(i,teams[i])
	idx = input('\nEnter ID of team you want to view: ')
	# ensure only valid arguments are entered
	while idx  not in range(len(roster)):
		print "\nInvalid input! Input number from the list."
		idx = input('\nEnter ID of team you want to view: ')
	player_idx = teams[idx]
	player_list = roster[player_idx]
	
	# iterate through user chosen team roster, display inteface for
	# 	navigation
	print '\nID Player\n-----------'
	for i in range(len(player_list)):
		print '%s %s' %(i,player_list[i])
	idx = input('\nEnter ID of player you want to view: ')
	# ensure only a valid argurment is entered
	while idx  not in range(len(player_list)):
		print "\nInvalid input! Input number from the list."
		idx = input('\nEnter ID of player you want to view: ')
	# when user chooses player, stats for player are displayed
	stats_idx = player_list[idx] 
	p_stat = player_stats[stats_idx]
        print '\nLast Name: %s\nFirst Name: %s\nTeam: %s\nPosition: %s\nAt Bats: %s\nBase Hits: %s\nDoubles: %s\nTriples: %s\nHome Runs: %s\nRBI: %s\nBatting Avg: %s' %(p_stat[0], p_stat[1], p_stat[2], p_stat[3], p_stat[4], p_stat[5], p_stat[6],p_stat[7], p_stat[8], p_stat[9], p_stat[10])
	# ask user if they want to continue searching for players, else terminate
	# 	program
	continue_search = raw_input('\nDo you want to continue searching for other players? (y/n): ')
	if continue_search == ('y' or 'Y') :
		navigate(teams, roster, player_stats)
	else:
		print "\nProgram Terminated.."
		sys.exit()
# Run Program
(teams, roster, player_stats) = main();	
navigate(teams, roster, player_stats);
