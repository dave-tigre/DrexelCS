import java.util.Scanner;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Test Menu
 */

public class TestMenu extends Menu {

	public String options1[] = {"1) Create a new Test","2) Display a Test",
			"3) Load a Test","4) Save a Test", "5) Quit"};
	
	/**
	 * 
	 */
	public TestMenu() {
		// TODO Auto-generated constructor stub
		System.out.println("Test Menu");
		display(options1);
		System.out.println();
		String choice = getResponse();
		
		switch(choice)
		{
		case "1": createNewTest();
				break;
		default: System.out.println("Invalid Input");
				break;
		}
	}
	
	public void createNewTest()
	{
		Test newTest = new Test();
		System.out.println("Name this Test: ");
		newTest.setTestName(getResponse());
		creationMenu();
	}

}
