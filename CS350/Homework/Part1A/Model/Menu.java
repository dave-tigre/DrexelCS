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
 */
public class Menu {

	public String options[] = {"1) Survey Menu", "2) Test Menu", "3) Quit"};
	public String creationOptions[] = {"1) Add a new T/F question", "2) Add new multiple choice questions",
			"3) Add a new short answer question","4) Add a new essay question", 
			"5) Add a new ranking question", "6) Add a new matching question",
			"7) Quit"};
	
	public static SurveyMenu sMenu = new SurveyMenu();
	public static TestMenu tMenu = new TestMenu();
	
	public Menu(){
		
	}
	
	public void startMenu()
	{
		System.out.println("\nMain Menu");
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
	
	public void getNextMenu()
	{
		String choice = getResponse();
		switch(choice)
		{
		case "1": sMenu.surveyMenu();
		case "2": tMenu.testMenu();
		case "3": System.out.println("Terminating Survey System..."); System.exit(0);
		}
	}
	
	@SuppressWarnings("resource")
	public String getResponse()
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		return choice;
	
	}
	
	public void createNewQuestion(Question q)
	{
		System.out.println("Enter the prompt for your "+q.getQuestionFormat() + " question: ");
		q.setPrompt(getResponse());
	}
	
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
	
	 /**
     * @return
     */
    public static void main(String[] args) {
        // TODO implement here
    	
    	System.out.println("Starting Survey Maker...");
    	Menu test = new Menu();
    	test.startMenu();
       
    }
	
}
