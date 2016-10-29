import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author David Tigreros
 * 10/15/2016
 * Test Maker
 * 
 * Test Menu
 */

public class TestMenu extends Menu {

	public String options1[] = {"1) Create a new Test","2) Display a Test",
			"3) Load a Test","4) Save a Test", "5) Quit"};
	
	private ArrayList<Test> availableTests = new ArrayList<Test>();
	
	public Test currentTest;
	Serialize serializeObj = new Serialize();
	private final String testFolder = "saved_tests";
	/**
	 * 
	 */
	public TestMenu() {

	}
	
	public void testMenu()
	{
		int invalid_count = 0;
		while(invalid_count < 3)
		{
			System.out.println("\nTest Menu");
			display(options1);
			System.out.println();
			String choice = getResponse();
			switch(choice)
			{
			case "1": createNewTest();
			break;
			case "2": displayTest();
			break;
			case "3": loadTest();
			break;
			case "4": saveTest();
			break;
			case "5": invalid_count = 10;
			break;
			default: System.out.println("Invalid Input");
			invalid_count++;
			break;
			}
		}
		System.out.println("Returning to Main Menu..."); 
		startMenu();
	}
	
	public void createNewTest()
	{
		currentTest = new Test();
		System.out.println("Name this Test: ");
		currentTest.setTestName(getResponse());
		availableTests.add(currentTest);
		creationMenu();
	}
	
	public void displayTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no Tests to display. Create or load a new Test to display");
			
		}
		else{
			
		
			System.out.println("Select the Test you wish to display: ");
			for(int i = 0; i < availableTests.size(); i++)
			{
				int x = i+1;
				System.out.println(x +") " + availableTests.get(i).getTestName());
			}
			String choice = getResponse();
			availableTests.get(Integer.parseInt(choice)-1).display();
			
		}
	}
	
	public void loadTest()
	{
		ArrayList<String> listOfFiles = listFiles(testFolder);
		if(listOfFiles.size() < 1)
		{
			System.out.println("There are no tests to load...");
			return;
		}
		else{
			System.out.println("Select the test you want to load: ");
			
			for(int i = 0; i < listOfFiles.size(); i++)
			{
				int x = i+1;
				System.out.println(x +") " + listOfFiles.get(i));
			}
			String choice = getResponse();
			int ch = Integer.parseInt(choice) - 1;
			String filePath = testFolder + "/" + listOfFiles.get(ch);
			Test loadedTest = serializeObj.deserializeTest(filePath);
			availableTests.add(loadedTest);
			testMenu();
		}
		

		
	}
	
	public void saveTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no tests to save. Create a new test to save.");
		
		}
		else{
			
			System.out.println("Select the Test you with to save: ");
			for(int i = 0; i < availableTests.size(); i++)
			{
				int x = i+1;
				System.out.println(x +") " + availableTests.get(i).getTestName());
			}
			String choice = getResponse();
			Test savedTest = availableTests.get(Integer.parseInt(choice)-1);
			
			serializeObj.serializeTest(savedTest,testFolder);
			System.out.println();
			testMenu();
		}
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
						currentTest.setCorrectResponse(newTF);
						creationMenu();
			case "2": MultipleChoice newMC = new MultipleChoice();
						createNewQuestion(newMC);
						System.out.println("Enter number of choices for your multiple choice question: ");
						newMC.choiceAmount();
						newMC.addChoices();
						currentTest.addQuestion(newMC);
						currentTest.setCorrectResponse(newMC);
						creationMenu();
			case "3": ShortAnswer newSA = new ShortAnswer();
						createNewQuestion(newSA);
						currentTest.addQuestion(newSA);
						currentTest.setCorrectResponse(newSA);
						creationMenu();
			case "4": Essay newEssay = new Essay();
						createNewQuestion(newEssay);
						currentTest.addQuestion(newEssay);
						currentTest.setCorrectResponse(newEssay);
						creationMenu();
			case "5": Ranking newRank = new Ranking();
						createNewQuestion(newRank);
						System.out.println("Enter the number of premises for your ranking question");
						newRank.prchAmount();
						newRank.addPremises();
						currentTest.addQuestion(newRank);
						currentTest.setCorrectResponse(newRank);
						creationMenu();
			case "6":  Matching newMatch = new Matching();
						createNewQuestion(newMatch);
						System.out.println("Enter the number of premises for your matching question");
						newMatch.prchAmount();
						newMatch.addPremises();
						newMatch.addChoices();
						currentTest.addQuestion(newMatch);
						currentTest.setCorrectResponse(newMatch);
						creationMenu();
			case "7": System.out.println("Terminating Test Maker...");
						testMenu();
			default: System.out.println("Invalid Input please Try again");
						creationMenu();
		}
		
	}

}
