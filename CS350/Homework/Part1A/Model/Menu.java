import java.io.File;
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
 * Main menu is the main driver of the program and the super class of the survey and test menus.
 */
public class Menu {

	/*
	 * Option choices for main menu and creation of new question menu.
	 */
	public String options[] = {"1) Survey Menu", "2) Test Menu", "3) Quit"};
	public String creationOptions[] = {"1) Add a new T/F question", "2) Add new multiple choice questions",
			"3) Add a new short answer question","4) Add a new essay question", 
			"5) Add a new ranking question", "6) Add a new matching question",
			"7) Quit"};
	
	public static SurveyMenu sMenu = new SurveyMenu(); //instantiated survey menu
	public static TestMenu tMenu = new TestMenu(); //instantiated test menu
	
	/*
	 * Default Constructor
	 */
	public Menu(){
		
	}
	
	/*
	 * Starting Menu
	 */
	public void startMenu()
	{
		System.out.println("\nMain Menu");
		for(String option: options)
		{
			System.out.println(option);
		}
		String choice = getResponse();
		int ch = string2int(choice);
		switch(ch)
		{
		case 1: sMenu.surveyMenu();
		case 2: tMenu.testMenu();
		case 3: System.out.println("Terminating Survey System..."); System.exit(0);
		default: System.out.println("Invalid Input...."); startMenu();
		}
	}
	
	/*
	 * Method to display given set of options
	 */
	public void display(String[] options)
	{
		for(String option: options)
		{
			System.out.println(option);
		}
	}
	
	/*
	 * Method to obtain user response from console.
	 * @return the string from console.
	 */
	@SuppressWarnings("resource")
	public String getResponse()
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		return choice;
	
	}
	
	/*
	 * Method to create a new question and set prompt
	 * @param q : given question
	 */
	public void createNewQuestion(Question q)
	{
		System.out.println("Enter the prompt for your "+q.getQuestionFormat() + " question: ");
		q.setPrompt(getResponse());
	}
	
	/*
	 * Method to display files in given directory
	 * Used for loading/saving tests and surveys
	 */
	public ArrayList<String> listFiles(final String filePath)
	{
		File folder = new File(filePath);
		File listOfFiles[] = folder.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		
		if(listOfFiles.length > 0)
		{
			for(int i = 0; i < listOfFiles.length; i++)
			{
				if(listOfFiles[i].isFile())
				{
					fileNames.add(listOfFiles[i].getName());			
				}
			}
		}
		
		return fileNames;
	}
	
	/*
	 * Method to convert input string to integer and catch for exception.
	 * Used for error handling.
	 */
	public int string2int(String string)
	{
		int number = 99; //test number, should never leave as 99, unless input is invalid..
		try
    	{
    		number = Integer.parseInt(string);
    		if(number < 1)
    		{
    			number = 99;
    		}
    		
    	}
    	catch(NumberFormatException nfe)
    	{
    		System.out.println("Input was not a valid integer... Try again..");
    	}
		
		return number;
	}
	
	/*
	 * Error handling to check whether a number is in range of options
	 */
	public boolean withinRange(int arrayListSize, int num)
	{
		if(num < arrayListSize)
		{
			return true;
		}
		else
		{
			System.out.println("Input was not a valid integer...");
			return false;
		}
	}
		
	
	 /**
	  * Main Driver for program
     * @return
     */
    public static void main(String[] args) {
        // TODO implement here
    	
    	System.out.println("Starting Survey Maker...");
    	Menu test = new Menu();
    	test.startMenu();
       
    }
	
}
