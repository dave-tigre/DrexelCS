import junit.framework.*;
/**
 * @author David Tigreros
 *	CS265 Section003 Lab9
 *	5/30/2016
 * gIntTest.java
 * Test class for the gInt program.
 */

public class gIntTest extends TestCase{
	
	private gInt test1; // test object 1
	private gInt test2; // test object 2

	// constructor
	public gIntTest ( String name ){
		super( name );
	}
	
	// set up the test objects
	protected void setUp(){
		test1 = new gInt(4,3);
		test2 = new gInt(9,1);
	}

	// test if the equals method is true
	public void testEquals(){
		gInt expect = new gInt(4,3);
		assertEquals( expect, test1 );
		assertEquals( test1, test1);
		assertNotSame( expect, test1);
		assertFalse( test1.equals(test2));
		assertFalse( expect.equals(test2));
	}

	// test if the add method works
	public void testAdd(){
		gInt expect = new gInt(13,4);
		gInt result = test1.add(test2);
		assertEquals(expect, result);
	}

	// test if the multiply method works
	public void testMultiply(){
		gInt expect = new gInt(33,23);
		gInt result = test1.multiply( test2 );
		assertEquals( expect, result );
	}
	
	// test if the norm method works
	public void testNorm(){
		float expect = 5;
		float result = test1.norm();
		assertEquals(expect, result);
	}

	public static Test suite() {
		return new TestSuite( gIntTest.class );
	}

	// main method
	public static void main(String[] args){
		String[] caseName = { gIntTest.class.getName() };
				junit.textui.TestRunner.main( caseName );
	}

}
