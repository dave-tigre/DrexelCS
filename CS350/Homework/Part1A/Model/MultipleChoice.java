import java.util.ArrayList;

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
    		System.out.println("Enter Choice #"+i);
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


    /**
     * Method to be used to edit creator choices
     */
    private void editChoices() {
        // TODO implement here
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