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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String prompt;
	protected Response qResponse; //response to this question
	
	public Question()
	{
		//System.out.println("Constructing a Question");
	}

	public void setPrompt(String prompt)
	{
		this.prompt = prompt;
	}
	
	
	public String getPrompt()
	{
		return this.prompt;
	}
	
	public void editPrompt(String prompt)
	{
		this.prompt = prompt;
	}
	
    /**
     * 
     */
    public void display(){
    	System.out.println(prompt);
    }
    
    public abstract String getQuestionFormat();
    
    @SuppressWarnings("resource")
	public String getUserResponse()
    {
    	Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		return choice;
    }
    
    public void setResponse()
    {
    	qResponse = new Response();
    	qResponse.setUserResponse();
    }
    
    public Response getResponse()
    {
    	return qResponse;
    }

}