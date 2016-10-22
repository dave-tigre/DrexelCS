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
 * Main Menu
 */
public class Menu {

	public String options[] = {"1) Survey Menu", "2) Test Menu"};
	public String creationOptions[] = {"1) Add a new T/F question", "2) Add new multiple choice questions",
			"3) Add a new short answer question","4) Add a new essay question", 
			"5) Add a new ranking question", "6) Add a new matching question",
			"7) Quit"};
	
	public Menu(){
	}
	
	public void startMenu()
	{
		for(String option: options)
		{
			System.out.println(option);
		}
		getNextMenu();
	}
	
	public void display(String[] options)
	{
		for(String option: options)
		{
			System.out.println(option);
		}
	}
	
	public Menu getNextMenu()
	{
		String choice = getResponse();
		switch(choice)
		{
		case "1": SurveyMenu sMenu = new SurveyMenu();
				return sMenu;
		case "2": TestMenu tMenu = new TestMenu();
				return tMenu;
		}
		SurveyMenu safeMenu = new SurveyMenu();
		return safeMenu;
	}
	
	public String getResponse()
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		return choice;
	
	}
	
	public void creationMenu()
	{
		
		display(creationOptions);
		String choice = getResponse();
		switch(choice)
		{
			case "1" : TrueFalse newTF = new TrueFalse();
						createNewQuestion(newTF);
						break;
			case "2": MultipleChoice newMC = new MultipleChoice();
						createNewQuestion(newMC);
						break;
			case "3": ShortAnswer newSA = new ShortAnswer();
						createNewQuestion(newSA);
						break;
			case "4": Essay newEssay = new Essay();
						createNewQuestion(newEssay);
						break;
			case "5": Ranking newRank = new Ranking();
						createNewQuestion(newRank);
						break;
			case "6":  Matching newMatch = new Matching();
						createNewQuestion(newMatch);
						break;
			case "7": System.out.println("Terminating Survey Maker...");
						break;
			default: System.out.println("Invalid Input please Try again");
						creationMenu();
						break;
		}
	}
	
	public void createNewQuestion(Question q)
	{
		System.out.println("Input Question prompt: ");
		q.setPrompt(getResponse());
	}
	
	public void loadMenu()
	{
		//method for loading previously created survey's or tests
	}
	
	public void saveMenu()
	{
		
	}
	
}