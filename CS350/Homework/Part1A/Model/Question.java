
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Abstract Question Class
 */
public abstract class Question {
	
	public String prompt;
	private Response userResponse;
	
	public Question()
	{
		System.out.println("Constructing a Question");
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
    
    public void setQuestionFormat(String type)
    {
    	
    }
    
    public String getQuestionFormat()
    {
    	return null;
    }
    
    public void getUserReponse()
    {
    	
    }

}