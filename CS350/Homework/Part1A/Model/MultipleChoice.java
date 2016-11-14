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
    	System.out.println("Choose what you would like to edit:");
    	String options[] = {"Edit Prompt", "Edit Choice", "Quit"};
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
    	case "3": return;
    	default: System.out.println("Invalid Input...");
    	break;
    	}
    }
    
    public void editChoices()
    {
    	System.out.println("Select the choice option you want to edit: ");
    	for(int i = 0; i < choices.size(); i++)
    	{
    		System.out.println(alpha[i] +")" + choices.get(i));
    	}
    	
    	String choice = getUserResponse();
    	int ch = Arrays.asList(alpha).indexOf(choice);
    	System.out.println("Enter Choice" + choice +")");
    	choices.set(ch, getUserResponse());
    	
    }
    
    public void displayResponse()
    {
    	System.out.println(getResponse().getResponse());
    }

    /*
     * (non-Javadoc)
     * @see Question#display()
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());
    	System.out.print(alpha[0] + ") " + choices.get(0));
    	for(int i = 1; i < choices.size(); i++)
    	{
    		System.out.print("	" +alpha[i] + ") " + choices.get(i));
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