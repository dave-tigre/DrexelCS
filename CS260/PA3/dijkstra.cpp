/* 
* Programming Assignment 3
* CS-260 Section-003
* 8/24/2016
*
* Dijkstra Adjacency Matrix
*/

#include <stdio.h>
#include <iostream>
#include <ostream>

#define MAX 100

using namespace std;

// function for the dijkstra adjacency matrix
int main(){
	int r = 7; //graph range 0-6 => 7
	int A[r][r]; // initialize graph
	
	// populate graph
	for(int i = 0; i < r; i++){
		for(int j = 0; j < r; j++){
			A[i][j] = MAX;
		}
	}
	
	// graph values from problem 6 of review exam pdf
	A[1][2] = 4; A[1][3] = 1; A[1][4] = 5; A[1][5] = 8; A[1][6] = 10;
	A[3][2] = 2;
	A[4][5] = 2;
	A[5][6] = 1;

	int S[r]; //source vertex
	int D[r]; //array for length of shortest special path
	int P[r]; // array of vertices
	int temp[r]; // temp array
	
	S[1] = 1; // init S vector

	// populate D
	for(int i = 1; i < r; i++){
		D[i] = A[1][i];
		P[i] = 1;
	}
	
	// dijkstra algorithm 
	for(int k = 1; k < (r-1); k++){
		int w = MAX;
		for(int l = 1; l < r; l++){
			temp[l] = D[l];
		}

		for(int h = 1; h <= k; h++){
			int t = S[h];
			temp[t] = MAX;
		}
	
		for(int c = 2; c < r; c++){
			if(temp[c] < w){
				w = c;
			}
		}

		S[k+1] = w;
	
		for(int u = 1; u < r; u++){
			if(D[u] > D[w]+A[w][u]){
				D[u] = D[w] + A[w][u];
				P[u] = w;
			}
		}
	}
	
	// print each vector 
	
	cout << endl;
	for(int i = 1; i < r; i++){
		cout << "D[" << i << "] = ";
		if(D[i] < 10)
		 	cout<< D[i] << endl;
		else
			cout<< "-" << endl;
	}	
	cout << endl;
	for(int j = 1; j < r; j++){
		cout <<"P[" << j << "] = " << P[j] << endl;
	}
	cout <<endl;
	for(int k = 1; k < r; k++){
		cout <<"S[" << k << "] = " << S[k] << endl;
	}
	return 0;
}


