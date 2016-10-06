/*
* Author: David Tigreros
* 6/4/2016
* CS265 Section003 Assignment4
* cddb.h
* CDDB
* This program is a command-line utilty to maintain a flat-file database
* of album information.
* Users are able to view album info, add a new entry, or delete an
* entry.
* Entries consist of an artist, album name, release date, and a track
* list.
*/

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <string.h>
using namespace std;

// data structure for albums
struct Album {
	int year;
	string title;
	vector<string> tracklist;
};
 
class cddb{
	private:
		bool album_exist( string album, int release_year, vector<Album> albums);
		void artist_exist( string artist );
	public:
		map<string, vector<Album> > artist_data;
		void list_artist( void );
		void list_album( string artist );
		void delete_album( void );
		void add_album( void );
		void list_song( string artist, Album album );
		void usage_message( void );
		void write_file( void );
		void read_file( void );
		cddb();
		~cddb();	
};
