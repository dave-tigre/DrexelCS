import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

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
			"3) Load a Survey","4) Save a Survey", "5) Quit"};
	
	private ArrayList<Survey> availableSurveys = new ArrayList<Survey>();
	
	public Survey currentSurvey;
	Serialize serializeObj = new Serialize();
	private final String surveyFolder = "saved_surveys";
	/**
	 * 
	 */
	public SurveyMenu() {
		// TODO Auto-generated constructor stub
		surveyMenu();
	}
	
	public void surveyMenu()
	{
		
		
		int invalid_count = 0;
		while(invalid_count < 3)
		{
			System.out.println("Survey Menu");
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
	
	public void createNewSurvey()
	{
		currentSurvey = new Survey();
		System.out.println("Name this Survey: ");
		currentSurvey.setSurveyName(getResponse());
		availableSurveys.add(currentSurvey);
		creationMenu();
	}
	
	public void displaySurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to display. Create or load a new survey to display");
			
		}
		else{
			
		
			System.out.println("Select the Survey you wish to display: ");
			for(int i = 0; i < availableSurveys.size(); i++)
			{
				System.out.println(i +") " + availableSurveys.get(i).getSurveyName());
			}
			String choice = getResponse();
			availableSurveys.get(Integer.parseInt(choice)).display();
			
		}
	}
	
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
				System.out.println(x +") " + listOfFiles.get(i));
			}
			String choice = getResponse();
			int ch = Integer.parseInt(choice) - 1;
			String filePath = surveyFolder + "/" + listOfFiles.get(ch);
			Survey loadedSurvey = serializeObj.deserializeSurvey(filePath);
			availableSurveys.add(loadedSurvey);
			surveyMenu();
		}
		

		
	}
	
	public void saveSurvey()
	{
		if(availableSurveys.isEmpty())
		{
			System.out.println("There are no surveys to save. Create a new survey to save.");
		
		}
		else{
			
			System.out.println("Select the Survey you with to save: ");
			for(int i = 0; i < availableSurveys.size(); i++)
			{
				System.out.println(i +") " + availableSurveys.get(i).getSurveyName());
			}
			String choice = getResponse();
			Survey savedSurvey = availableSurveys.get(Integer.parseInt(choice));
			
			serializeObj.serializeSurvey(savedSurvey,surveyFolder);
			System.out.println();
			surveyMenu();
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
						currentSurvey.addQuestion(newTF);
						creationMenu();
			case "2": MultipleChoice newMC = new MultipleChoice();
						createNewQuestion(newMC);
						System.out.println("Enter number of choices for your multiple choice question: ");
						newMC.choiceAmount();
						newMC.addChoices();
						currentSurvey.addQuestion(newMC);
						creationMenu();
			case "3": ShortAnswer newSA = new ShortAnswer();
						createNewQuestion(newSA);
						currentSurvey.addQuestion(newSA);
						creationMenu();
			case "4": Essay newEssay = new Essay();
						createNewQuestion(newEssay);
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
