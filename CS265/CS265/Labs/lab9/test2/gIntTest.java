import junit.framework.*;

public class gIntTest extends TestCase
{
	    public static void main(String[] args)
			 	{
					        String[] caseName = { gIntTest.class.getName() };
							  		junit.textui.TestRunner.main( caseName );
									    }

		     public gIntTest( String name )
				  	{
							  super( name );
							  	}

			  	private gInt gInt1;
					private gInt gInt2;
						protected void setUp()
								{
										  gInt1= new gInt(3,4);
										  	  gInt2= new gInt(9,16);
											  	}

							public void testEquals()
									{
											  gInt expected = new gInt( 3,4 );
											  	  assertEquals( expected,gInt1 );
												  	  assertEquals( gInt1, gInt1
															  );
													  	  assertNotSame( expected,
																  gInt1 );
														  	  assertFalse(
																	  gInt1.equals( gInt2 ));
															  	  assertFalse(
																		  expected.equals(
																			  gInt2 ));
																  	}

								public void testAdd()
										{
												  gInt expected= new gInt( 12, 20 );
												  	  gInt result = gInt1.add( gInt2 );
													  	  assertEquals( expected,
																  result );
														  	}

									public void testMultiply()
											{
													  gInt expected= new gInt( -37, 84 );
													  	  gInt result = gInt1.multiply(
																  gInt2 );
														  	  assertEquals(
																	  expected, result );
															  	}

										public void testNorm()
												{
														  float expected = 5;
														  	  float result = gInt1.norm();
															  	  assertEquals(
																		  expected, result );
																  	}

											public static Test suite()
													{
															  TestSuite suite= new
																  TestSuite();
															  	  suite.addTest( new
																		  gIntTest(
																			  "testEquals" ));
																  	  suite.addTest( new
																			  gIntTest(
																				  "testAdd" ));
																	  	  suite.addTest( new
																				  gIntTest(
																					  "testMultiply"
																					  ));
																		  	  suite.addTest(
																					  new
																					  gIntTest(
																						  "testNorm"
																						  ));
																			  	  return suite;
																				  	}




}
