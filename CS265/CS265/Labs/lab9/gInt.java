import java.lang.Math;
/**
 * @author David Tigreros
 * CS265 Section003 Lab9
 * 5/30/2016
 * gInt.java
 * This program implements a java class gInt.
 */

public class gInt {
	public int a = 0; // real part of complex #
	public int b = 0; // imaginary part of complex #
	
	// real num contructor
	public gInt( int r ){
		a = r;
	}

	// complex num constructor
	public gInt( int r, int i ){
		a = r;
		b = i;
	}

	// method to return real part of complex num
	public int real(){
		return a;
	}

	// method to return imaginary part of complex num
	public int imag(){
		return b;
	}

	// method to add this complex num with rhs complex num
	public gInt add( gInt rhs ){
		gInt result = new gInt(0,0); // initialize new gInt object
		result.a = (rhs.a + a); // add this real with param real
		result.b = (rhs.b + b); // add this imag with param imag
		return result;
	}

	// method to multiply this complex num with rhs complex num
	public gInt multiply( gInt rhs ){
		gInt result = new gInt(0,0); 
		result.a = (rhs.a * a); // multiply this real with param real
		result.b = (rhs.b * b); // mulitply this imag with param imag
		return result;
	}

	// method to get norm (magnitude) of complex num
	public float norm(){
		float result = (float)  Math.sqrt((a*a) * (b*b));
		return result;
	}
	
	// override equals for junit testing
	public boolean equals( Object o ){
		// check if param object is of gInt object
		if ( o instanceof gInt ){
			gInt test = (gInt) o;
			if(test.real() == real() && test.imag() == imag()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}

