import java.util.ArrayList;

/**
 * @author David Tigreros
 * 10/15/2016
 * Test Maker
 * 
 * Test Menu
 */

public class TestMenu extends Menu {

	public String options1[] = {"1) Create a new Test","2) Display a Test",
			"3) Load a Test","4) Save a Test","5) Modify an existing Test","6) Take a Test",
			"7) Tabulate a Test","8) Grade a Test", "9) Quit"};
	
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
			voice.printOutput("\n\nTest Menu");
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
			case "5": modifyTest();
			break;
			case "6": takeTest();
			break;
			case "7": tabulateTest();
			break;
			case "8": gradeTest();
			break;
			case "9": invalid_count = 10;
			break;
			default: voice.printOutput("\nInvalid Input");
			invalid_count++;
			break;
			}
		}
		voice.printOutput("\nReturning to Main Menu..."); 
		startMenu();
	}
	
	/*
	 * Method to create a new test
	 */
	public void createNewTest()
	{
		currentTest = new Test();
		voice.printOutput("\nName this Test: ");
		currentTest.setName(getResponse());
		availableTests.add(currentTest);
		creationMenu();
	}
	
	/*
	 * Method to display a test
	 */
	public void displayTest()
	{
		if(availableTests.isEmpty())
		{
			voice.printOutput("\nThere are no Tests to display. Create or load a new Test to display");
			
		}
		else{
			
		
			voice.printOutput("\nSelect the Test you wish to display: ");
			listTests();
			String choice = getResponse();
			int ch = string2int(choice) - 1;
			
			if(withinRange(availableTests.size(),ch))
			{
				availableTests.get(ch).display();
			}
			
		}
	}
	
	/*
	 * Method to load test
	 */
	public void loadTest()
	{
		ArrayList<String> listOfFiles = listFiles(testFolder);
		if(listOfFiles.size() < 1)
		{
			voice.printOutput("\nThere are no tests to load...");
			return;
		}
		else{
			voice.printOutput("\nSelect the test you want to load: ");
			
			for(int i = 0; i < listOfFiles.size(); i++)
			{
				int x = i+1;
				String fileName = listOfFiles.get(i);
				fileName = fileName.replace(".ser", "");
				voice.printOutput("\n"+x +") " + fileName);
			}
			String choice = getResponse();
			int ch = string2int(choice) - 1;
			if(withinRange(listOfFiles.size(),ch))
			{
				String filePath = testFolder + "/" + listOfFiles.get(ch);
				Test loadedTest = serializeObj.deserializeTest(filePath);
				availableTests.add(loadedTest);
			}
		}
		

		
	}
	
	/*
	 * Method to save test
	 */
	public void saveTest()
	{
		if(availableTests.isEmpty())
		{
			voice.printOutput("\nThere are no tests to save. Create a new test to save.");
		
		}
		else{
			
			voice.printOutput("\nSelect the Test you with to save: ");
			listTests();
			String choice = getResponse();
			int ch = string2int(choice) - 1;
			if(withinRange(availableTests.size(),ch))
			{
				Test savedTest = availableTests.get(ch);
				
				serializeObj.serializeTest(savedTest,testFolder);
				System.out.println();
			}
			
		}
	}
	
	/*
	 * Method to modify test
	 */
	public void modifyTest()
	{
		if(availableTests.isEmpty())
		{
			voice.printOutput("\nThere are no tests to modify. Create or load a new test to modify.");
		
		}
		else{
			
			voice.printOutput("\nSelect the Test you want to modify: ");
			listTests();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableTests.size(),ch))
			{
				availableTests.get(ch).modifySurvey();
				System.out.println();
			}
		}
	}
	
	/*
	 * Method to take test
	 */
	public void takeTest()
	{
		if(availableTests.isEmpty())
		{
			voice.printOutput("\nThere are no tests to take. Create or load a new test to take.");
		
		}
		else{
			
			voice.printOutput("\nSelect the Test you want to take: ");
			listTests();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableTests.size(),ch))
			{
				availableTests.get(ch).takeSurvey();
				System.out.println();
			}
		}
	}
	
	/*
	 * Method to tabulate test
	 */
	public void tabulateTest()
	{
		if(availableTests.isEmpty())
		{
			voice.printOutput("\nThere are no tests to tabulate. Create or load a new test to tabulate.");
		
		}
		else{
			
			voice.printOutput("\nSelect the Test you want to tabulate: ");
			listTests();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableTests.size(),ch))
			{
				availableTests.get(ch).tabulateData();
				System.out.println();
			}
		}
	}
	
	/*
	 * Method to return grade test from last known taken test
	 */
	public void gradeTest()
	{
		if(availableTests.isEmpty())
		{
			voice.printOutput("\nThere are no tests to grade. Create or load a new test to grade.");
		
		}
		else{
			
			voice.printOutput("\nSelect the Test you want to grade: ");
			listTests();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableTests.size(),ch))
			{
				if(availableTests.get(ch).getGrade() < 0)
				{
					voice.printOutput("\nThis test has yet to be taken.");
				}				
				else
				{
					voice.printOutput("\nResults from last time this test was taken: ");
					availableTests.get(ch).printGrade();
				}
				
				System.out.println();
			}
		}
	}
	
	/*
	 * Method to list tests
	 */
	public void listTests()
	{
		for(int i = 0; i < availableTests.size(); i++)
		{
			int x = i+1;
			voice.printOutput("\n"+x +") " + availableTests.get(i).getName());
		}
	}
	
	/*
	 * Method used to create new questions and perform tasks based on choice
	 */
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
						voice.printOutput("\nEnter number of choices for your multiple choice question: ");
						newMC.choiceAmount();
						newMC.addChoices();
						newMC.setNumOfResponseOptions();
						currentTest.addQuestion(newMC);
						currentTest.setCorrectResponse(newMC);
						creationMenu();
			case "3": ShortAnswer newSA = new ShortAnswer();
						createNewQuestion(newSA);
						newSA.numOfResponses();
						currentTest.addQuestion(newSA);
						currentTest.setCorrectResponse(newSA);
						creationMenu();
			case "4": Essay newEssay = new Essay();
						createNewQuestion(newEssay);
						newEssay.numOfResponses();
						currentTest.addQuestion(newEssay);
						currentTest.setCorrectResponse(newEssay);
						creationMenu();
			case "5": Ranking newRank = new Ranking();
						createNewQuestion(newRank);
						voice.printOutput("\nEnter the number of premises for your ranking question");
						newRank.prchAmount();
						newRank.addPremises();
						currentTest.addQuestion(newRank);
						currentTest.setCorrectResponse(newRank);
						creationMenu();
			case "6":  Matching newMatch = new Matching();
						createNewQuestion(newMatch);
						voice.printOutput("\nEnter the number of premises for your matching question");
						newMatch.prchAmount();
						newMatch.addPremises();
						newMatch.addChoices();
						currentTest.addQuestion(newMatch);
						currentTest.setCorrectResponse(newMatch);
						creationMenu();
			case "7": voice.printOutput("\nTerminating Test Maker...");
						testMenu();
			default: voice.printOutput("\nInvalid Input please Try again");
						creationMenu();
		}
		
	}

}
