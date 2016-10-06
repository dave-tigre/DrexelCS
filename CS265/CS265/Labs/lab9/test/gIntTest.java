import junit.framework.*;

public class gIntTest extends TestCase {

		public static void main(String[] args) {
					junit.textui.TestRunner.run( suite() );
						}

			public gIntTest( String name ) {
						super(name);
							}

				private gInt gInt_1;
					private gInt gInt_2;

						protected void setUp() {
									gInt_1 = new gInt(5,5);
											gInt_2 = new gInt(7,-3);
												}

							public void testEquals() {
										gInt expected = new gInt(5,5);
												Assert.assertEquals( expected, gInt_1 );
														Assert.assertEquals( gInt_1,
																gInt_1 );
																Assert.assertNotSame(
																		expected, gInt_1 );
																		Assert.assertFalse(gInt_1.equals(
																					gInt_2));
																				Assert.assertFalse(expected.equals(
																							gInt_2));
																					}

								public void testAdd() {
											gInt expected = new gInt(12,2);
													gInt sum = gInt_1.add(gInt_2);
															Assert.assertEquals( expected,
																	sum );
																}

									public void testMultiply() {
												gInt expected = new gInt(50,20);
														gInt product =
															gInt_1.multiply(gInt_2);
																Assert.assertEquals(
																		expected, product );
																	}

										public void testNorm() {
													float expected_1 =
														(float)Math.sqrt(50);
															float expected_2 =
																(float)Math.sqrt(58);
																	float result_1 =
																		gInt_1.norm();
																			float result_2 =
																				gInt_2.norm();
																				}

											public static Test suite() {
														TestSuite suite = new TestSuite();
																suite.addTest( new gIntTest(
																			"testEquals" ));
																		suite.addTest( new
																				gIntTest(
																					"testAdd" ));
																				suite.addTest(
																						new
																						gIntTest(
																							"testMultiply"
																							));
																						suite.addTest(
																								new
																								gIntTest(
																									"testNorm"
																									));
																								return
																									suite;
																									}

}
