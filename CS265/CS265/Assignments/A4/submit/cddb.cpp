/*
* Author: David Tigreros
* 6/4/2016
* CS265 Section003 Assignment4
* cddb.cpp
* This program is a command-line utilty to maintain a flat-file database
* of album information.
* Users are able to view album info, add a new entry, or delete an
* entry.
* Entries consist of an artist, album name, release date, and a track
* list.
*/

#include "cddb.h"
bool deleteAlbum = false;
bool command_line = false;
string current_artist = "";

/** constructor **/
cddb::cddb(){
}
/** deconstructor **/
cddb::~cddb(){
	cout << "Program Terminated" << endl;
}

/** method to print usage message **/
void cddb::usage_message(){
	cout << "The commands for this program are: " << endl;
	cout << "-l : List Albums" << endl;
	cout << "-d : Delete Albums" << endl;
	cout << "-a : Add Album" << endl;
	cout << "-h : View Usage Message and Quit Program" << endl;
}

/** method to write to file **/
void cddb::write_file( void ){
	// create or overwrite file with new info
	ofstream database_file("cddb.txt");
	// iterate through artist_data to input to file
	for(map<string, vector<Album> >::iterator art_it = artist_data.begin();
			art_it != artist_data.end(); art_it++){
		for(vector<Album>::iterator alb_it = art_it->second.begin(); alb_it !=
				art_it->second.end(); alb_it++){
			database_file << "\n";
			database_file << art_it->first << endl;
			database_file << alb_it->year << " " << alb_it->title << endl;
			for(vector<string>::iterator song_it = alb_it->tracklist.begin();
					song_it != alb_it->tracklist.end(); song_it++){
				database_file << "-" << *song_it << endl;
			}
		}
	}
	database_file.close();
}

/** method to read from file **/
void cddb::read_file( void ){
	string line;
	string artist;
	int year;
	string title;
	vector<Album> albums;
	Album read_album;
	// read from database file if it exist
	ifstream database_file;
	database_file.open("cddb.txt");
	if(database_file.is_open()){
		//parse until the end of file to obtain data
		while(!database_file.eof()){
			if(database_file.eof())
				break;
			getline(database_file,line);
			if(line.empty())
				continue;
			artist = line;
			artist_exist(artist);
			vector<string> tracklist;
			getline(database_file,line);
			year = atoi(line.substr(0,4).c_str());
			title = line.substr(5,line.size()-1);
			getline(database_file,line);
			char file_dash = line.at(0);
			char dash[] = "-";
			while(file_dash == dash[0]){
				if(file_dash != dash[0])
					break;
				tracklist.push_back(line.substr(1,line.size()-1));
				getline(database_file,line);
				if(line.empty())
					break;
				file_dash = line.at(0);
			}
			// create albums and map to artist
			read_album.year = year;
			read_album.title = title;
			read_album.tracklist = tracklist;
			artist_data[artist].push_back(read_album);
		}
		database_file.close();
	}
}

/** method to determine if album exists **/
bool cddb::album_exist(string album, int release_year, vector<Album> albums){
	bool exist = false;
	for(vector<Album>::iterator alb_it = albums.begin(); alb_it !=
			albums.end(); alb_it++){
		// if album exists return true
		if(alb_it->title.compare(album) == 0 ){
			if(alb_it->year == release_year){
				exist = true;
				break;
			}
		}
	}
	return exist;
}

/** determine if artist is already in database **/
void cddb::artist_exist( string artist ){
	bool exist = false;
	for(map<string, vector<Album> >::iterator art_it = artist_data.begin();
			art_it != artist_data.end(); art_it++){
		// if artist exist return true
		if(art_it->first.compare(artist) == 0){
			exist = true;
			break;
		}
	}
	// if artist does not already exist, add to database
	if(!exist){
		vector<Album> albums;
		artist_data[artist] = albums;
	}
}

/** method to list artist **/
void cddb::list_artist( void ){
	// check if artist data base is empty
	if(artist_data.empty())
		cout << "There are currently no artists in database" << endl;
	else{
		cout << "\nEnter 'q' to quit " << endl;
		cout << "Enter number to select artist: " << endl;
		int i = 0;
		string input;
		int choice;
		vector<string> artists;
		// iterate database to list artists
		for(map<string, vector<Album> >::iterator art_it =  artist_data.begin();
				art_it != artist_data.end(); art_it++){
			cout << i << " " << art_it->first << endl;
			i++;
			artists.push_back(art_it->first);
		}
		cin >> input;
		if(input.compare("q") == 0)
			cout << "Returning to main menu..." << endl;
		else{
			choice = atoi(input.c_str());
			string choice_artist = artists.at(choice);
			current_artist = choice_artist;
			list_album(choice_artist);
		}
	}
}

/** method to list albums **/
void cddb::list_album( string artist ){
	cout << "\nEnter 'a' to return back to artist." << endl;
	cout << "Enter number to select album: " << endl;
	map< int, string > album_map;
	string input;
	int choice;
	int i = 0;
	vector<string> titles;
	for(vector<Album>::iterator alb_it = artist_data[artist].begin();
			alb_it != artist_data[artist].end(); alb_it++){
		album_map[alb_it->year] = alb_it->title;
	}
	// iterate to display albums, keep track of order by year
	for(map<int, string >::iterator alb_map_it = album_map.begin();
		alb_map_it != album_map.end(); alb_map_it++){
		cout << i <<  " " << alb_map_it->first << " " << alb_map_it->second << endl;
		i++;
		titles.push_back(alb_map_it->second);
	}
	if(!deleteAlbum){
		cin >> input;
		if(input.compare("a") == 0){
			cout << "Returning to artist..." << endl;
			list_artist();
		}
		else{
			choice = atoi(input.c_str());
			string album_choice = titles.at(choice);
			Album choice_album;
			for(vector<Album>::iterator title_it = artist_data[artist].begin();
					title_it != artist_data[artist].end(); title_it++){
				if(title_it->title.compare(album_choice) == 0){
					choice_album = *title_it;
				}
			}
			list_song(artist, choice_album);
		}
	}
}

/** method to list songs **/
void cddb::list_song(string artist, Album album ){
	cout << "\n" << album.title << " Tracklist: " << endl;
	// iterate to display songs
	for(vector<string>::iterator song_it = album.tracklist.begin(); song_it
			!= album.tracklist.end(); song_it++){
		cout <<"-" << *song_it << endl;
	}
	cout << "Enter 'r' to return to albums" << endl;
	cout << "Enter 'q' to quit" << endl;
	string input;
	cin >>input;
	if(input.compare("r") == 0){
		cout << "Returning to albums..." << endl;
		list_album(artist);
	}
	else if (input.compare("q") == 0)
		cout << "Returning to main menu..." << endl;
}

/** method to add albums **/
void cddb::add_album(){
	deleteAlbum = false;
	string artist_name;
	Album new_album;
	int year_release;
	string album_title;
	char name[256];
	char song[256];
	char title[256];
	vector<string> tracks;
	string track;
	cout << "Enter 'q' to return to main menu." << endl;
	cout << "Enter name of artist: " << endl;
	cin.clear();
	if(!command_line)
		cin.ignore();
	cin.getline(name, 256);
	artist_name = name;
	artist_exist(artist_name);
	
	// add album to artist directory
	cout << "Enter release year of album: " << endl;
	cin >> year_release;
	cout << "Enter album title: " << endl;
	cin.clear();
	cin.ignore();
	cin.getline(title,256);
	album_title = title;
	if(album_exist(album_title, year_release, artist_data[artist_name]))
	{
		cout << "Album already exists!" << endl;
		cout << "Returning to main menu..." << endl;
	}
	else{
		// enter tracks one by one, use '0' to break loop
		cout << "Enter tracks one by one. When done enter '0': " << endl;
		while(track.compare("0") != 0){
			cin.clear();
			cin.getline(song,256);
			track = song;
			if(track.compare("0") == 0)
				break;
			tracks.push_back(track);
		}
		cout << "Album has been added." << endl;
		new_album.year = year_release;
		new_album.title = album_title;
		new_album.tracklist = tracks;
		artist_data[artist_name].push_back(new_album);
		// update the database file
		write_file();
	}
}

/** method to delete album **/
void cddb::delete_album( void ){
	if(artist_data.empty())
		cout << "No albums in database to delete" << endl;
	else{
		deleteAlbum = true;
		list_artist();
		string input;
		int choice;
		cout << "Enter 'q' to quit" << endl;
		cout << "Enter number of album to delete: " << endl;
		cin >> input;
		if(input.compare("q") == 0)
			cout << "Returning to main menu..." << endl;
		else{
			choice = atoi(input.c_str());
			string artist = current_artist;
			artist_data[artist].erase(artist_data[artist].begin()+choice);
			cout << "Album has been erased." << endl;
			if(artist_data[artist].empty())
				artist_data.erase(artist);
			// update the database file
			write_file();
		}
	}
}

/** main program **/
int main(int argc, char *argv[]){
	// create cddb object
	cddb test;
	//load data from database file
	test.read_file();
	string command;
	// accept arguments if they are input
	if(argv[1] != NULL){
		command = argv[1];
		if(argv[2] != NULL){
			test.usage_message();
			return 0;
		}
		else if(command.compare("-l") == 0)
			test.list_artist();
		else if(command.compare("-d") == 0)
			test.delete_album();
		else if(command.compare("-a") == 0){
			command_line = true;
			test.add_album();
		}
		else if(command.compare("-h") == 0){
			test.usage_message();
			//update database file
			test.write_file();
			return 0;
		}
		else{
			test.usage_message();
			return 0;
		}
	}
	else{
		test.usage_message();
		return 0;
	}
	// accept arguments until user ends program
	bool end_program = false;
	while(!end_program){
		test.usage_message();
		cout << "Enter Command: " << endl;
		cin >> command;
		if(command.compare("-l") == 0)
			test.list_artist();
		else if(command.compare("-d") == 0)
			test.delete_album();
		else if(command.compare("-a") == 0){
			command_line = false;
			test.add_album();
		}	
		else if(command.compare("-h") == 0){
			test.usage_message();
			//update database file
			test.write_file();
			end_program = true;
			return 0;
		}
		else{
			test.usage_message();
		}
	}
	return 0;
}
