import java.util.ArrayList;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Matching Questions
 */
public class Matching extends Question {

	private Response userResponse;
    public ArrayList<String> choices = new ArrayList<String>();
    public ArrayList<String> premises = new ArrayList<String>();
    protected int numOfprch;
    
    
    /**
     * Default constructor
     */
    public Matching() {
  
    }
    
    public void addPremises()
    {
    	for(int i = 1; i <= numOfprch; i++)
    	{
    		System.out.println("Enter Premise #"+i);
    		premises.add(getUserResponse());
    	}
    }
    
    public void addChoices()
    {
    	for(int i = 1; i <= numOfprch; i++)
    	{
    		System.out.println("Enter Choice #"+i);
    		choices.add(getUserResponse());
    	}
    }
    
    /*
     * Premise/Choices Amount
     */
    public void prchAmount()
    {
    	String prch = getUserResponse();
    	try
    	{
    		numOfprch = Integer.parseInt(prch);
    	}
    	catch(NumberFormatException nfe)
    	{
    		System.out.println("Input was not a valid integer... Try again..");
    		prchAmount();
    	}
    }

    /**
     * 
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());

    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.println("____ " + premises.get(i-1));
    	}
    	
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
    public Matching createQuestion() {
        // TODO implement here
        return null;
    }

	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Matching";
	}

}