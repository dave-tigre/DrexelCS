import java.util.ArrayList;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Multiple Choice Question
 */
public class MultipleChoice extends Question {

	public ArrayList<String> choices = new ArrayList<String>();
    private Response userResponse;
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
     * 
     */
    private void editChoices() {
        // TODO implement here
    }

    /**
     * 
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());
    	String alpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
    	System.out.print(alpha[0] + ") " + choices.get(0));
    	for(int i = 1; i < choices.size(); i++)
    	{
    		System.out.print("	" +alpha[i] + ") " + choices.get(i));
    	}
    }

    /**
     * @return
     */
    public MultipleChoice createQuestion() {
        // TODO implement here
        return null;
    }

	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Multiple Choice";
	}

}