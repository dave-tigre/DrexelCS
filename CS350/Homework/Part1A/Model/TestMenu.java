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
		currentTest.setName(getResponse());
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
			listTests();
			String choice = getResponse();
			int ch = string2int(choice) - 1;
			
			if(withinRange(availableTests.size(),ch))
			{
				availableTests.get(ch).display();
			}
			
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
				String fileName = listOfFiles.get(i);
				fileName = fileName.replace(".ser", "");
				System.out.println(x +") " + fileName);
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
	
	public void saveTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no tests to save. Create a new test to save.");
		
		}
		else{
			
			System.out.println("Select the Test you with to save: ");
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
	
	public void modifyTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no tests to modify. Create or load a new test to modify.");
		
		}
		else{
			
			System.out.println("Select the Test you want to modify: ");
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
	
	public void takeTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no tests to take. Create or load a new test to take.");
		
		}
		else{
			
			System.out.println("Select the Test you want to take: ");
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
	
	public void tabulateTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no tests to tabulate. Create or load a new test to tabulate.");
		
		}
		else{
			
			System.out.println("Select the Test you want to tabulate: ");
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
	
	public void gradeTest()
	{
		if(availableTests.isEmpty())
		{
			System.out.println("There are no tests to grade. Create or load a new test to grade.");
		
		}
		else{
			
			System.out.println("Select the Test you want to grade: ");
			listTests();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableTests.size(),ch))
			{
				availableTests.get(ch).printGrade();
				System.out.println();
			}
		}
	}
	
	public void listTests()
	{
		for(int i = 0; i < availableTests.size(); i++)
		{
			int x = i+1;
			System.out.println(x +") " + availableTests.get(i).getName());
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
