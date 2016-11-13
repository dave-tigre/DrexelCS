import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Survey Class
 */
public class Survey implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<Question> Questions = new ArrayList<Question>();
	public ArrayList<Response> Responses;
    protected HashMap<Question, ArrayList<Response>> userResponses = new HashMap<Question, ArrayList<Response>>();
    protected HashMap<Question, Response> currentResponses = new HashMap<Question, Response>();
    public String name;
    public int numberOfQuestions;
    
	/**
     * Default constructor
     */
    public Survey() {
    }
    
    /*
     * Set survey name.
     */
    public void setName(String name)
    {
    	this.name = name;
    }
    
    /*
     * return survey name
     */
    public String getName()
    {
    	return name;
    }

    /**
     * Method to add question to survey
     * @param q : given question to add to survey
     */
    public void addQuestion(Question q) {
        Questions.add(q);
        Responses = new ArrayList<Response>();
        userResponses.put(q, Responses);
        
    }


    /**
     * 
     */
    public void removeQuestion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void editQuestion() {
        // TODO implement here
    }

    /**
     * Method to display a survey
     */
    public void display() {
        // TODO implement here
    	if(Questions.size() < 1)
    	{
    		System.out.println("This survey has no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		System.out.print(x + ") ");
    		Questions.get(i).display();
    		System.out.println("\n");
    	}
    	System.out.println("\n");
    }

    /**
     * Method to display a survey
     */
    public void takeSurvey() {
        // TODO implement here
    	if(Questions.size() < 1)
    	{
    		System.out.println("There are no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		System.out.print(x + ") ");
    		Questions.get(i).display();
    		System.out.println("\nEnter Your Response: ");
    		Questions.get(i).setResponse();
        	Response userResponse = Questions.get(i).getResponse();
    		addResponse(Questions.get(i), userResponse);
    		System.out.println("\n");
    	}
    	System.out.println("\n");
    }
    /**
     * Method to be used to take in survey taker response
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    	userResponses.get(question).add(response);
    	if(currentResponses.isEmpty())
    		currentResponses.put(question, response);
    	else
    	{
    		if(currentResponses.containsKey(question))
    			currentResponses.replace(question, response);
    		else
    			currentResponses.put(question, response);
    	}
    }


    /**
     * Method to be used to tabulate data 
     */
    public void tabulateData() {
        // TODO implement here
    	int count = 1;
    	for(Question q : userResponses.keySet())
    	{
    		System.out.println("Question #"+count+":");
    		q.display();
    		System.out.println("\n\nReplies: ");
    		for(Response r : userResponses.get(q))
    		{
    			System.out.println(r.getResponse());
    		}
    		
    		System.out.println("Tabulation:");
    		System.out.println();
    		count++;
    	}
    	
    	
    }
    
    public void tabulate()
    {
    	for(Question q : userResponses.keySet())
    	{
    		for(Response r : userResponses.get(q))
    		{
    			String response[] = r.getResponse().split(" ");
    			
    		}
    	}
    }
    
    public void modifySurvey()
    {
    	int count = 1;
    	System.out.println("What question do you want to modify?");
    	for(Question q : Questions)
    	{
    		System.out.println("\nQuestion " +count+")");
    		q.display();
    		System.out.println();
    		count++;
    		
    	}
    	System.out.println();
    	String choice = getUserResponse();
    	int ch = string2int(choice) - 1;
    	Questions.get(ch).editQuestion();
    	
    }
    
    /*
     * Method used to obtain user input response from console.
     */
    @SuppressWarnings("resource")
	public String getUserResponse()
    {
    	Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		return choice;
    }
    
    public Response getCurrentResponse(Question q)
    {
    	return currentResponses.get(q);
    	
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

}