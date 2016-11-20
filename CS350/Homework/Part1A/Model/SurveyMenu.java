import java.util.ArrayList;

/**
 * 
 */

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Survey Menu
 */
public class SurveyMenu extends Menu{

	public String options1[] = {"1) Create a new Survey","2) Display a Survey",
			"3) Load a Survey","4) Save a Survey","5) Modify an existing Survey",
			"6) Take a Survey", "7) Tabulate a Survey", "8) Quit"};
	
	private ArrayList<Survey> availableSurveys = new ArrayList<Survey>();
	
	public Survey currentSurvey;
	Serialize serializeObj = new Serialize();
	private final String surveyFolder = "saved_surveys";
	
	/**
	 * Default Constructor
	 */
	public SurveyMenu() {

	}
	
	public void surveyMenu()
	{
		int invalid_count = 0;
		while(invalid_count < 3)
		{
			System.out.println("\nSurvey Menu");
			display(options1);
			System.out.println();
			String choice = getResponse();
			switch(choice)
			{
			case "1": createNewSurvey();
			break;
			case "2": displaySurvey();
			break;
			case "3": loadSurvey();
			break;
			case "4": saveSurvey();
			break;
			case "5": modifySurvey();
			break;
			case "6": takeSurvey();
			break;
			case "7": tabulateSurvey();
			break;
			case "8": invalid_count = 10;
			break;
			default: System.out.println("Invalid Input");
			invalid_count++;
			break;
			}
		}
		System.out.println("Returning to Main Menu..."); 
		startMenu();
	}
	
	/*
	 * Method to create a new survey
	 */
	public void createNewSurvey()
	{
		currentSurvey = new Survey();
		System.out.println("Name this Survey: ");
		currentSurvey.setName(getResponse());
		availableSurveys.add(currentSurvey);
		creationMenu();
	}
	
	/*
	 * Method to display a survey
	 */
	public void displaySurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to display. Create or load a new survey to display");
			
		}
		else{
			System.out.println("Select the Survey you want to display: ");
			listSurveys();
			String choice = getResponse();		
			int ch = string2int(choice) - 1;
			
			if(withinRange(availableSurveys.size(),ch))
			{
				availableSurveys.get(ch).display();
			}
			
		}
	}
	
	/*
	 * Method to load a survey
	 */
	public void loadSurvey()
	{
		ArrayList<String> listOfFiles = listFiles(surveyFolder);
		if(listOfFiles.size() < 1)
		{
			System.out.println("There are no surveys to load...");
			return;
		}
		else{
			System.out.println("Select the survey you want to load: ");
			
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
				String filePath = surveyFolder + "/" + listOfFiles.get(ch);
				Survey loadedSurvey = serializeObj.deserializeSurvey(filePath);
				availableSurveys.add(loadedSurvey);
			}
			else
			{
				System.out.println("Input was not a valid integer...");
			}
		}	
	}
	
	/*
	 * Method to save a survey
	 */
	public void saveSurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to save. Create a new survey to save.");
		
		}
		else{
			
			System.out.println("Select the Survey you want to save: ");
			listSurveys();
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableSurveys.size(),ch))
			{
				Survey savedSurvey= availableSurveys.get(ch);
				
				serializeObj.serializeSurvey(savedSurvey,surveyFolder);
				System.out.println();
			}
		}
	}
	
	public void modifySurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to modify. Create or load a new survey to modify.");
		
		}
		else{
			
			System.out.println("Select the Survey you want to modify: ");
			listSurveys();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableSurveys.size(),ch))
			{
				availableSurveys.get(ch).modifySurvey();
				System.out.println();
			}
			
		}
	}
	
	public void takeSurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to take. Create or load a new survey to take.");
		
		}
		else{
			
			System.out.println("Select the Survey you want to take: ");
			listSurveys();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableSurveys.size(),ch))
			{
				availableSurveys.get(ch).takeSurvey();
				System.out.println();
			}
		}
	}
	
	public void tabulateSurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to tabulate. Create or load a new survey to tabulate.");
		
		}
		else{
			
			System.out.println("Select the Survey you want to tabulate: ");
			listSurveys();
			
			String choice = getResponse();
			
			int ch = string2int(choice) - 1;
			if(withinRange(availableSurveys.size(),ch))
			{
				availableSurveys.get(ch).tabulateData();
				System.out.println();
			}
		}
	}
	
	public void listSurveys()
	{
		for(int i = 0; i < availableSurveys.size(); i++)
		{
			int x = i+1;
			System.out.println(x +") " + availableSurveys.get(i).getName());
		}
	}
	
	/*
	 * Menu used to create new questions and perform tasks based on choice
	 */
	public void creationMenu()
	{
		
		display(creationOptions);
		String choice = getResponse();
		switch(choice)
		{
			case "1" : TrueFalse newTF = new TrueFalse();
						createNewQuestion(newTF);
						currentSurvey.addQuestion(newTF);
						creationMenu();
			case "2": MultipleChoice newMC = new MultipleChoice();
						createNewQuestion(newMC);
						System.out.println("Enter number of choices for your multiple choice question: ");
						newMC.choiceAmount();
						newMC.addChoices();
						newMC.setNumOfResponseOptions();
						currentSurvey.addQuestion(newMC);
						creationMenu();
			case "3": ShortAnswer newSA = new ShortAnswer();
						createNewQuestion(newSA);
						newSA.numOfResponses();
						currentSurvey.addQuestion(newSA);
						creationMenu();
			case "4": Essay newEssay = new Essay();
						createNewQuestion(newEssay);
						newEssay.numOfResponses();
						currentSurvey.addQuestion(newEssay);
						creationMenu();
			case "5": Ranking newRank = new Ranking();
						createNewQuestion(newRank);
						System.out.println("Enter the number of premises for your ranking question");
						newRank.prchAmount();
						newRank.addPremises();
						currentSurvey.addQuestion(newRank);
						creationMenu();
			case "6":  Matching newMatch = new Matching();
						createNewQuestion(newMatch);
						System.out.println("Enter the number of premises for your matching question");
						newMatch.prchAmount();
						newMatch.addPremises();
						newMatch.addChoices();
						currentSurvey.addQuestion(newMatch);
						creationMenu();
			case "7": System.out.println("Terminating Survey Maker...");
						surveyMenu();
			default: System.out.println("Invalid Input please Try again");
						creationMenu();
		}
	}
	

}
