import java.lang.Math;

class gInt {

		// Initialize a and b for complex number ax + b
		public int a = 0;
			public int b = 0;

				// Initialize gInt for complex number with only real part
				public gInt( int r) {
							a = r;
								}

					// Initialize gInt for complex number with real and imaginary
					// parts
					public gInt( int r, int i) {
								a = r;
										b = i;
											}
						
						// Return real part of complex number
						public int real() {
									return a;
										}

							// Return imaginary part of complex number
							public int imag() {
										return b;
											}

								// Add 2 complex numbers and return sum
								public gInt add( gInt rhs) {
											gInt sum = new gInt(0,0);
													sum.a = rhs.a + a;
															sum.b = rhs.b + b;
																	return sum;
																		}

									// Multiply 2 complex numbers and return product
									public gInt multiply( gInt rhs) {
												gInt product = new gInt(0,0);
														product.a = (rhs.a * a) - (rhs.b *
																b);
																product.b = (rhs.a * b) +
																	(rhs.b * a);
																		return product;
																			}

										// Return floating point L2-norm of complex
										// number
										public float norm() {
													float a_f = (float)a;
															float b_f = (float)b;
																	float asq =
																		(float)Math.pow(a_f,
																				2);
																			float bsq =
																				(float)Math.pow(b_f,
																						2);
																					float sqr =
																						(float)Math.sqrt(asq
																								+
																								bsq);
																							return
																								(float)sqr;
																								}

											// Override Equals needed for gIntTest
											// taken from notes
											public boolean equals( Object anObject) {
														if (anObject instanceof gInt) {
																		gInt ex_gInt =
																			(gInt)anObject;
																					return 
																										ex_gInt.real()
																										==
																										real() 
																														&&
																														ex_gInt.imag()
																														==
																														imag();
																							}
																return false;
																	}
}
