import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Multiple Choice Question
 */
public class MultipleChoice extends Question {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> choices = new ArrayList<String>();
    private int numOfChoices;
    private int numOfResponseOptions;

    /**
     * Default constructor
     */
    public MultipleChoice() {
    } 

    /**
     * @param choices
     */
    public void addChoices() {
        // TODO implement here
    	
    	for(int i = 1; i <= numOfChoices; i++)
    	{
    		voice.printOutput("\nEnter Choice "+alpha[i-1]+")");
    		choices.add(getUserResponse());
    	}
    	
    }
    
    /*
     * Method for creator to set the amount of choices 
     */
    public void choiceAmount()
    {
    	String numCh = getUserResponse();
    	try
    	{
    		numOfChoices = Integer.parseInt(numCh);
    	}
    	catch(NumberFormatException nfe)
    	{
    		voice.printOutput("\nInput was not a valid integer... Try again..");
    		choiceAmount();
    	}
    }


    /*
     * (non-Javadoc)
     * @see Question#editQuestion()
     */
    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		voice.printOutput("\nChoose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Edit Choice","Enter number of input choices", "Quit"};
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
        	case "2": editChoices();
        	break;
        	case "3": setNumOfResponseOptions();
        	break;
        	case "4": cont = 10;
        	break;
        	default: voice.printOutput("\nInvalid Input... Try Again..."); cont++;
        	break;
        	}
    	}
    	
    }
    
    /*
     * Method to edit chocies
     */
    public void editChoices()
    {
    	voice.printOutput("\nSelect the choice option you want to edit: ");
    	for(int i = 0; i < choices.size(); i++)
    	{
    		voice.printOutput("\n"+alpha[i] +") " + choices.get(i));
    	}
    	
    	String choice = getUserResponse();
    	if(Arrays.asList(alpha).contains(choice))
    	{
    		int ch = Arrays.asList(alpha).indexOf(choice);
    		if(ch < choices.size())
    		{
    			voice.printOutput("\nEnter Choice " + choice +")");
            	choices.set(ch, getUserResponse());
    		}
    		else
        	{
        		voice.printOutput("\nInvalid input... ");
        	}
    	}
    	else
    	{
    		voice.printOutput("\nInvalid input... ");
    	}
    	
    }
    

    /*
     * Method to set the number of responses
     */
    public void setNumOfResponseOptions()
    {
    	voice.printOutput("\nEnter number of options taker needs to enter: ");
    	String numCh = getUserResponse();
    	try
    	{
    		numOfResponseOptions = Integer.parseInt(numCh);
    	}
    	catch(NumberFormatException nfe)
    	{
    		voice.printOutput("\nInput was not a valid integer... Try again..");
    		setNumOfResponseOptions();
    	}
    	
    }
    
    /*
     * (non-Javadoc)
     * @see Question#displayResponse()
     */
    public void displayResponse()
    {
    	String response[] = getResponse().getResponse().split(" ");
    	for(int i = 0; i < response.length; i++)
    	{
    		voice.printOutput("\n"+response[i]);
    	}
    	System.out.println();
    }

    /*
     * (non-Javadoc)
     * @see Question#display()
     */
    @Override
    public void display() {
        // TODO implement here
    	voice.printOutput(getQuestionFormat()+" Question"); 
    	voice.printOutput("\n"+getPrompt());
    	System.out.println();
    	voice.printOutput(alpha[0] + ") " + choices.get(0));
    	for(int i = 1; i < choices.size(); i++)
    	{
    		voice.printOutput("	" +alpha[i] + ") " + choices.get(i));
    	}
    	if(numOfResponseOptions > 1)
    		voice.printOutput("\n\nPlease enter "+ numOfResponseOptions + " choices:");
    }
    
    public void audio() {
        // TODO implement here
    	voice.voiceOutput(getQuestionFormat()+" Question"); 
    	voice.voiceOutput("\n"+getPrompt());
    	System.out.println();
    	voice.voiceOutput(alpha[0] + ") " + choices.get(0));
    	for(int i = 1; i < choices.size(); i++)
    	{
    		voice.voiceOutput("	" +alpha[i] + ") " + choices.get(i));
    	}
    	if(numOfResponseOptions > 1)
    		voice.voiceOutput("\n\nPlease enter "+ numOfResponseOptions + " choices:");
    }
    
    
    /*
     * Method to set the response to a question.
     */
    @Override
    public void setResponse()
    {
    	
    	if(numOfResponseOptions > 1)
    	{
    		String response = "";
    		qResponse = new Response();
    		for(int i = 0; i< numOfResponseOptions; i++)
    		{
    			voice.printOutput("\nEnter Choice #" + (i+1));
    			response +=getUserResponse()+" ";
    			
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
    	
    	if(numOfResponseOptions > 1)
    	{
    		String response = "";
    		qResponse = new Response();
    		for(int i = 0; i< numOfResponseOptions; i++)
    		{
    			voice.voiceOutput("\nEnter Choice #" + (i+1));
    			response +=getUserResponse()+" ";
    			
    		}
    		qResponse.setUserResponse(response);
    	}
    	else
    	{
    		super.setResponse();
    	}
    	
    }
    
    /*
     * (non-Javadoc)
     * @see Question#getQuestionFormat()
     */
	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Multiple Choice";
	}

}