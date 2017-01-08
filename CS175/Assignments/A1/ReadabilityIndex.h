#pragma once
#ifndef READABILITY_INDEX_H
#define READABILITY_INDEX_H

#include <stdio.h>
#include <string>
#include <iostream>
#include <fstream>

using namespace std;

class Readability_Index
{
public:

	/**
		Readability Index constructor
	*/
	Readability_Index();

	/**
		Method to input file from user
	*/
	void Readability_Index::input_file(const char * fn);

	/**
		Method to read and analyze text file
	*/
	void read_textfile(istream & in) const;

	/**
		Method to print analyzation result to user
	*/
	void print_result() const;

	/**
		Method to display usage message
	*/
	void usage_message();

	/**
		Method to calculate the Flesch Reading Ease Score (FRES)
	*/
	void FRES_calc(int words, int syllables, int sentences);

	/**
		Method to calculate the Flesch-Kincaid Reading Age (FKRA) 
	*/
	void FKRA_calc(int words, int syllables, int sentences);

	

private:
	float FRES_score;
	string FRES_grade;
	float FKRA_value;
	string FKRA_grade;
	int num_words;
	int num_syllables;
	int num_sentences;
	string file_name;
	
	
};

#endif READABILITY_INDEX_H
