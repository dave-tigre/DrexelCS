import java.util.ArrayList;
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
	private ArrayList<Test> availableTests = new ArrayList<Test>();
	
	public Test currentTest;
	
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
	
	public void creationMenu()
	{
		
		display(creationOptions);
		String choice = getResponse();
		switch(choice)
		{
			case "1" : TrueFalse newTF = new TrueFalse();
						createNewQuestion(newTF);
						currentTest.addQuestion(newTF);
						creationMenu();
			case "2": MultipleChoice newMC = new MultipleChoice();
						createNewQuestion(newMC);
						System.out.println("Enter the choices, place a comma after each choice: ");
						newMC.addChoices(getResponse());
						currentTest.addQuestion(newMC);
						creationMenu();
			case "3": ShortAnswer newSA = new ShortAnswer();
						createNewQuestion(newSA);
						currentTest.addQuestion(newSA);
						creationMenu();
			case "4": Essay newEssay = new Essay();
						createNewQuestion(newEssay);
						currentTest.addQuestion(newEssay);
						creationMenu();
			case "5": Ranking newRank = new Ranking();
						createNewQuestion(newRank);
						currentTest.addQuestion(newRank);
						break;
			case "6":  Matching newMatch = new Matching();
						createNewQuestion(newMatch);
						currentTest.addQuestion(newMatch);
						creationMenu();
			case "7": System.out.println("Terminating Survey Maker...");
						break;
			default: System.out.println("Invalid Input please Try again");
						creationMenu();
						break;
		}
	}

}
