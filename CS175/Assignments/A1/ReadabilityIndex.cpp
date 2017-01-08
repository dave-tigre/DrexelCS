#include "ReadabilityIndex.h"
using namespace std;

Readability_Index::Readability_Index()
{
	FRES_score = 100.0f;
	FKRA_value = 1.0f;
	num_words = 0;
	num_syllables = 0;
	num_sentences = 0;
	usage_message();
}


void Readability_Index::usage_message()
{
	string file_name;
	cout << "Please enter a file name (or QUIT to exit): \n" << endl;
	cin >> file_name;
	this->file_name = file_name;
	if (file_name == "QUIT")
	{
		cout << "Program Terminated..." << endl;
		terminate();
	}
	else
	{
		input_file(file_name.c_str());
	}
	

}
void Readability_Index::input_file(const char * fn)
{
	string file_name = fn;
	if (file_name.substr(file_name.find_last_of(".") + 1) != "txt")
	{
		cout << "I'm sorry, the file \"" << file_name << "\" has an invalid extension." << endl;
		usage_message();
	}
	
	ifstream database_file;
	database_file.open(file_name.c_str());
	if (database_file.fail())
	{
		cout << "I'm sorry, the file \"" << file_name << "\" cannot be found." << endl;
		cout << "The file must be in the same directory as this program." << endl;
		usage_message();
	}
	else {
		cout << "File Found...\n" << "Analyzing..." << endl;
		read_textfile(database_file);
	}
}
void Readability_Index::read_textfile(istream& in) const
{
	string current_line = "";
	string current_word = "";
	
	while (!in.eof())
	{
		if (in.eof())
			break;
		getline(in, current_line);
		

	}

}

void Readability_Index::print_result() const
{
	cout << "The file \"" << file_name
		<< "\" has Flesch Reading Ease Score index of " << FRES_score << endl;
	cout << "It requires an " << FRES_grade << " grade education to read" << endl;
	cout << "It's Flesch - Kincaid Grade Level Formula value is " << FKRA_value
		<< ", indication it is an " << FKRA_grade << " grade level." << endl;
}

void Readability_Index::FRES_calc(int words, int syllables, int sentences)
{
	FRES_score = 206.835 - 84.6 * (syllables) / (words)-1.015 * (words) / (sentences);
}

void Readability_Index::FKRA_calc(int words, int syllables, int sentences)
{
	FKRA_value = 11.8* (syllables) / (words)+0.39 * (words) / (sentences)-15.59;
}

