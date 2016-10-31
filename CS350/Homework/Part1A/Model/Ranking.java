
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Ranking Question
 */
public class Ranking extends Matching {

	private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public Ranking() {
    }

    /*
     * (non-Javadoc)
     * @see Matching#display()
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());

    	// loop through to display premises first.
    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.println("____ " + premises.get(i-1));
    	}
    	
    	/*
    	 * loop through to display the choices, since it is ranking, just display number options
    	 */
    	System.out.print(alpha[0] + ") " + 1);
    	for(int i = 1; i < premises.size(); i++)
    	{
    		int x = i+1;
    		System.out.print("	" +alpha[i] + ") "  + x);
    	}
    }

    /*
     * (non-Javadoc)
     * @see Matching#setResponse()
     */
    @Override
    public void setResponse()
    {
    	String rankingOrder = "Ranking Order From top to bottom: ";
    	for(int i = 0; i< premises.size(); i++)
    	{
    		//loop through to input ranking to each option
    		int x = i+1;
    		System.out.println("Enter ranking of Premise #" +x + " "+premises.get(i) +": ");
    		rankingOrder +=getUserResponse()+" ";
    	}
    	qResponse = new Response();
    	qResponse.setUserResponse(rankingOrder);
    }
    
    /*
     * (non-Javadoc)
     * @see Matching#getResponse()
     */
    @Override
    public Response getResponse()
    {
    	return qResponse;
    }
    
    /*
     * (non-Javadoc)
     * @see Matching#getQuestionFormat()
     */
    @Override
    public String getQuestionFormat() {
    	return "Ranking";
    }

}