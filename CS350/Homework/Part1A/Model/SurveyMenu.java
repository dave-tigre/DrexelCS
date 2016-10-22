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
	
	public Survey currentSurvey;
	/**
	 * 
	 */
	public SurveyMenu() {
		// TODO Auto-generated constructor stub
		System.out.println("Survey Menu");
		display(options1);
		System.out.println();
		String choice = getResponse();
		
		switch(choice)
		{
		case "1": createNewSurvey();
				break;
		case "2": //display survey
				break;
		case "3": // load survey
				break;
		default: System.out.println("Invalid Input");
				break;
		}
	}
	
	public void createNewSurvey()
	{
		currentSurvey = new Survey();
		System.out.println("Name this Survey: ");
		currentSurvey.setSurveyName(getResponse());
		creationMenu();
	}
	
	
	

}