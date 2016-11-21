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
    		System.out.println("Enter Choice "+alpha[i-1]+")");
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
    		System.out.println("Input was not a valid integer... Try again..");
    		choiceAmount();
    	}
    }


    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		System.out.println("Choose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Edit Choice","Enter number of input choices", "Quit"};
        	for(int i = 0; i < options.length; i++)
        	{
        		int x = i+1;
        		System.out.println(x+") " +options[i]);
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
        	default: System.out.println("Invalid Input... Try Again..."); cont++;
        	break;
        	}
    	}
    	
    }
    
    public void editChoices()
    {
    	System.out.println("Select the choice option you want to edit: ");
    	for(int i = 0; i < choices.size(); i++)
    	{
    		System.out.println(alpha[i] +") " + choices.get(i));
    	}
    	
    	String choice = getUserResponse();
    	int ch = Arrays.asList(alpha).indexOf(choice);
    	System.out.println("Enter Choice " + choice +")");
    	choices.set(ch, getUserResponse());
    	
    }
    

    public void setNumOfResponseOptions()
    {
    	System.out.println("Enter number of options taker needs to enter: ");
    	String numCh = getUserResponse();
    	try
    	{
    		numOfResponseOptions = Integer.parseInt(numCh);
    	}
    	catch(NumberFormatException nfe)
    	{
    		System.out.println("Input was not a valid integer... Try again..");
    		setNumOfResponseOptions();
    	}
    	
    }
    
    public void displayResponse()
    {
    	String response[] = getResponse().getResponse().split(" ");
    	for(int i = 0; i < response.length; i++)
    	{
    		System.out.println(response[i]);
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
    	System.out.println(getQuestionFormat()+" Question"); 
    	System.out.println(getPrompt());
    	System.out.print(alpha[0] + ") " + choices.get(0));
    	for(int i = 1; i < choices.size(); i++)
    	{
    		System.out.print("	" +alpha[i] + ") " + choices.get(i));
    	}
    	if(numOfResponseOptions > 1)
    		System.out.println("\nPlease enter "+ numOfResponseOptions + " choices:");
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
    			System.out.println("Enter Choice #" + (i+1));
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