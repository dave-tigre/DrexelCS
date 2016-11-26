import java.io.Serializable;
import java.util.Scanner;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Abstract Question Class
 */
public abstract class Question implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String prompt;
	protected Response qResponse; //response to this question
	public static Output voice = new Output();
	
	
	public final String alpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
			"P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	public Question()
	{
	}

	/*
	 * Method to set the prompt of questions
	 * @param prompt : the input question prompt
	 */
	public void setPrompt(String prompt)
	{
		this.prompt = prompt;
	}
	
	/*
	 * @return the prompt string
	 */
	public String getPrompt()
	{
		return this.prompt;
	}
	
	/*
	 * Method to edit the question prompt
	 */
	public void editPrompt()
	{
		voice.printOutput("\nEnter the new prompt:\n");
		this.prompt = getUserResponse();
	}
	
    /**
     * Method to display the question.
     */
    public void display(){
    	voice.printOutput(getQuestionFormat()+" Question ");
    	voice.printOutput("\n"+prompt);
    }
    
    
    /**
     * Method to display the question.
     */
    public void audio(){
    	voice.voiceOutput(getQuestionFormat()+" Question ");
    	voice.voiceOutput("\n"+prompt);
    }
    
    /*
     * Method to return the question format of each question.
     */
    public abstract String getQuestionFormat();
    
    /*
     * Abstract method for each question to have its own way to edit
     */
    public abstract void editQuestion();
    
    /*
     * Method used to obtain user input response from console.
     */
    @SuppressWarnings("resource")
	public String getUserResponse()
    {
    	System.out.println();
    	Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		return choice;
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
     * Method to set the response to a question.
     */
    public void setResponse()
    {
    	qResponse = new Response();
    	qResponse.setUserResponse();
    }
    
    public void audioResponse()
    {
    	qResponse = new Response();
    	qResponse.setUserResponse();
    }
    
    /*
     * 
     */
    public void setReponse(Response response)
    {
    	qResponse = response;
    }
    
    public abstract void displayResponse();
    
    /*
     * @return the response to a question.
     */
    public Response getResponse()
    {
    	return qResponse;
    }

}