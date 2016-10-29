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
		System.out.println("Enter the file path of the survey you wish to load: ");
		Scanner in = new Scanner(System.in);
		String path = in.nextLine();
		if(path.contains("\\"))
		{
			
		}
		else
		{
			System.out.println("Invalid input... File Does not exist.");
			
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
						newMC.choiceAmount(Integer.parseInt(getResponse()));
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
						currentSurvey.addQuestion(newRank);
						break;
			case "6":  Matching newMatch = new Matching();
						createNewQuestion(newMatch);
						currentSurvey.addQuestion(newMatch);
						creationMenu();
			case "7": System.out.println("Terminating Survey Maker...");
						surveyMenu();
						break;
			default: System.out.println("Invalid Input please Try again");
						creationMenu();
						break;
		}
	}
	

}
