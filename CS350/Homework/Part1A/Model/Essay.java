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
    		System.out.println(getQuestionFormat()+" Question"); 
    		System.out.println(getPrompt());
    		for(int i = 0; i < numOfResponses; i++)
    		{
    			System.out.println(alpha[i] + ") ");
    		}
    	}
    	else
    		super.display();
    	
    }
    
    public void displayResponse()
    {
    	System.out.println(getResponse().getResponse());
    }

    /**
     * To be used when tabulating data
     */
    public void getWordCount() {
        // TODO implement here
    }
    
    public void numOfResponses()
    {
    	System.out.println("Enter number of responses: ");
    	String numCh = getUserResponse();
    	try
    	{
    		numOfResponses = Integer.parseInt(numCh);
    	}
    	catch(NumberFormatException nfe)
    	{
    		System.out.println("Input was not a valid integer... Try again..");
    		numOfResponses();
    	}
    }
    
   @Override
    public void editPrompt()
    {
	   super.editPrompt();
	  
    }
   
   /*public void editResponseNum()
   {
	   System.out.println("Enter number of ");
		String choice = getUserResponse();
		if(choice.equals("Y") || choice.equals("y"))
		{
			System.out.println("Enter number of responses:\n");
			String numCh = getUserResponse();
			try
			{
				numOfResponses = Integer.parseInt(numCh);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Input was not a valid integer... Try again..");
				editResponseNum();
			}
		}
   }*/
    
    public void editQuestion()
    {
    	System.out.println("Choose what you would like to edit:");
    	String options[] = {"Edit Prompt", "Edit number of responses","Quit"};
    	for(int i = 0; i < options.length; i++)
    	{
    		int x = i+1;
    		System.out.println(x+") " +options[i]);
    	}
    	
    	boolean cont = true;
    	while(cont)
    	{
    		String choice = getUserResponse();
    		switch(choice)
        	{
        	case "1": editPrompt();
        	editQuestion();
        	break;
        	case "2": numOfResponses();
        	editQuestion();
        	break;
        	case "3": cont = false;
        	break;
        	default: System.out.println("Invalid Input...Try again..."); 
        	editQuestion();
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
    			System.out.println(alpha[i] + ") ");
    			response +=getUserResponse();
    			
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