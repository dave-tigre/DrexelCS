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
	public void editPrompt(String prompt)
	{
		this.prompt = prompt;
	}
	
    /**
     * Method to display the question.
     */
    public void display(){
    	System.out.println(prompt);
    }
    
    /*
     * Method to return the question format of each question.
     */
    public abstract String getQuestionFormat();
    
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
    
    /*
     * Method to set the response to a question.
     */
    public void setResponse()
    {
    	qResponse = new Response();
    	qResponse.setUserResponse();
    }
    
    /*
     * @return the response to a question.
     */
    public Response getResponse()
    {
    	return qResponse;
    }

}