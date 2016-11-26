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
    public static Output voice = new Output();
    
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
     * Method to display a survey
     */
    public void display() {
        // TODO implement here
    	if(Questions.size() < 1)
    	{
    		voice.voiceOutput("\nThis survey has no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		voice.voiceOutput(x + ") ");
    		Questions.get(i).audio();
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
    		voice.voiceOutput("\nThere are no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		voice.voiceOutput(x + ") ");
    		Questions.get(i).audio();
    		voice.voiceOutput("\n\nEnter Your Response: ");
    		Questions.get(i).audioResponse();
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
    	for(int i = 0; i < Questions.size();i++)
    	{
    		voice.printOutput("\n"+count + ") ");
    		Questions.get(i).display();
    		voice.printOutput("\n\nReplies: ");
    		for(Response r : userResponses.get(Questions.get(i)))
    		{
    			Questions.get(i).setReponse(r);
    			Questions.get(i).displayResponse();
    		}
    		voice.printOutput("\n\nTabulation:");
    		tabulate(Questions.get(i));
    		System.out.println();
    		
    		count++;
    	}
    }
    
    public void tabulate(Question q)
    {
    	HashMap<String,Integer> responseCount = new HashMap<String,Integer>();
    	int count = 1;
		for(Response r : userResponses.get(q))
		{
			if(responseCount.containsKey(r.getResponse()))
			{
				count++;
				responseCount.put(r.getResponse(), count);
			}
			else
			{
				responseCount.put(r.getResponse(), count);
			}
			
		}
		for(String re : responseCount.keySet())
		{
			Response tabResponse = new Response();
			tabResponse.setUserResponse(re);
			q.setReponse(tabResponse);
			voice.printOutput("\nThis reponse was given: " + responseCount.get(re).intValue()+" time(s):");
			q.displayResponse();
			System.out.println();
    	}
    	
    }
    
    public void modifySurvey()
    {
    	int count = 1;
    	voice.printOutput("\nWhat question do you want to modify?\n");
    	for(Question q : Questions)
    	{
    		voice.printOutput(count+") ");
    		q.display();
    		System.out.println("\n");
    		count++;
    		
    	}
    	voice.printOutput("\nEnter the number of the question you want to modify: ");
    	System.out.println();
    	String choice = getUserResponse();
    	int ch = string2int(choice) - 1;
    	if(withinRange(Questions.size(),ch))
    	{
    		Questions.get(ch).editQuestion();
    	}
    	
    	
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
    		voice.printOutput("\nInput was not a valid integer... Try again..");
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
			voice.printOutput("\nInput was not a valid integer...");
			return false;
		}
	}

}