import java.util.ArrayList;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Matching Questions
 *
 */
public class Matching extends Question {

	private static final long serialVersionUID = 1L; //for serialization
    public ArrayList<String> choices = new ArrayList<String>(); // array list of choices
    public ArrayList<String> premises = new ArrayList<String>(); //array list of premises
    protected int numOfprch; // number of premises/choices
    
    
    /**
     * Default constructor
     */
    public Matching() {
  
    }
    
    /*
     * Add premises to array list one at a time
     */
    public void addPremises()
    {
    	for(int i = 1; i <= numOfprch; i++)
    	{
    		System.out.println("Enter Premise #"+i);
    		premises.add(getUserResponse());
    	}
    }
    
    /*
     * Add choices to array list one at a time
     */
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
     * Display a matching question
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());

    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.println("____ " + premises.get(i-1));
    	}
    	
    	System.out.print(alpha[0] + ") " + choices.get(0));
    	for(int i = 1; i < choices.size(); i++)
    	{
    		System.out.print("	" +alpha[i] + ") " + choices.get(i));
    	}
    }

    /*
     * (non-Javadoc)
     * @see Question#setResponse()
     */
    @Override
    public void setResponse()
    {
    	String rankingOrder = "Matching Order From top to bottom: ";
    	//loop through to obtain matching choice to each premise
    	for(int i = 0; i< premises.size(); i++)
    	{
    		int x = i+1;
    		System.out.println("Enter Matching Answer of Premise #" +x + " "+premises.get(i) +": ");
    		rankingOrder +=getUserResponse()+" ";
    	}
    	qResponse = new Response();
    	qResponse.setUserResponse(rankingOrder);
    }
    
    /*
     * (non-Javadoc)
     * @see Question#getResponse()
     */
    @Override
    public Response getResponse()
    {
    	return qResponse;
    }

    /*
     * (non-Javadoc)
     * @see Question#getQuestionFormat()
     */
	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Matching";
	}

}