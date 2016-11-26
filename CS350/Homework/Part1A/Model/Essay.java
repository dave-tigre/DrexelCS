import java.util.ArrayList;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Essay Class
 * This class is a child of the Question class for Essay Questions
 */
public class Essay extends Question {

	private static final long serialVersionUID = 1L; //for serialization
	public int wordCount; //word count of essay
	//protected ArrayList<String> prompts = new ArrayList<String>();
	protected int numOfResponses;
	
    /**
     * Default constructor
     */
    public Essay() {
    }

    /**
     * Display the essay Question as you would the super class
     */
    @Override
    public void display() {
    	
    	if(numOfResponses > 1)
    	{
    		voice.printOutput(getQuestionFormat()+" Question"); 
    		voice.printOutput("\n"+getPrompt());
    		for(int i = 0; i < numOfResponses; i++)
    		{
    			voice.printOutput("\n"+alpha[i] + ") ");
    		}
    	}
    	else
    		super.display();
    	
    }
    
    public void audio() {
    	
    	if(numOfResponses > 1)
    	{
    		voice.voiceOutput(getQuestionFormat()+" Question"); 
    		voice.voiceOutput("\n"+getPrompt());
    		for(int i = 0; i < numOfResponses; i++)
    		{
    			voice.voiceOutput("\n"+alpha[i] + ") ");
    		}
    	}
    	else
    		super.audio();
    	
    }
    
    public void displayResponse()
    {
    	voice.printOutput("\n"+getResponse().getResponse());
    }

    /**
     * To be used when tabulating data
     */
    public void getWordCount() {
        // TODO implement here
    }
    
    public void numOfResponses()
    {
    	voice.printOutput("\nEnter number of responses: ");
    	String numCh = getUserResponse();
    	try
    	{
    		numOfResponses = Integer.parseInt(numCh);
    	}
    	catch(NumberFormatException nfe)
    	{
    		voice.printOutput("\nInput was not a valid integer... Try again..");
    		numOfResponses();
    	}
    }
    
   @Override
    public void editPrompt()
    {
	   super.editPrompt();
	  
    }
    
    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		voice.printOutput("\nChoose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Edit number of responses","Quit"};
        	for(int i = 0; i < options.length; i++)
        	{
        		int x = i+1;
        		voice.printOutput("\n"+x+") " +options[i]);
        	}
    		String choice = getUserResponse();
    		switch(choice)
        	{
        	case "1": editPrompt();
        	break;
        	case "2": numOfResponses();
        	break;
        	case "3": cont = 10;
        	break;
        	default: voice.printOutput("\nInvalid Input...Try again..."); cont++;
        	break;
        	}
    	}
    	
    }
    
   
    /*
     * Method to set the response to a question.
     */
    @Override
    public void setResponse()
    {
    	
    	if(numOfResponses > 1)
    	{
    		String response = "";
    		qResponse = new Response();
    		for(int i = 0; i< numOfResponses; i++)
    		{
    			voice.printOutput("\n"+alpha[i] + ") ");
    			response +=getUserResponse() + "\n" ;
    			
    		}
    		qResponse.setUserResponse(response);
    	}
    	else
    	{
    		super.setResponse();
    	}
    	
    }
    
    public void audioResponse()
    {
    	
    	if(numOfResponses > 1)
    	{
    		String response = "";
    		qResponse = new Response();
    		for(int i = 0; i< numOfResponses; i++)
    		{
    			voice.voiceOutput("\n"+alpha[i] + ") ");
    			response +=getUserResponse() + "\n" ;
    			
    		}
    		qResponse.setUserResponse(response);
    	}
    	else
    	{
    		super.setResponse();
    	}
    	
    }

    /*
     * returns the string of the question format
     * @see Question#getQuestionFormat()
     */
	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Essay";
	}

}