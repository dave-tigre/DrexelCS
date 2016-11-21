
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
    	System.out.println(getQuestionFormat()+" Question"); 
    	System.out.println(getPrompt());

    	// loop through to display premises first.
    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.printf("%s) %-30s  %d) %d%n",alpha[i-1],premises.get(i-1),i,i);
    	}
    }

    /*
     * (non-Javadoc)
     * @see Matching#setResponse()
     */
    @Override
    public void setResponse()
    {
    	String rankingOrder =  "";// = "Ranking Order From top to bottom: ";
    	for(int i = 0; i< premises.size(); i++)
    	{
    		//loop through to input ranking to each option
    		int x = i+1;
    		System.out.println("Enter ranking of " +alpha[i] + ") "+premises.get(i) +": ");
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
    
    /*
     * (non-Javadoc)
     * @see Matching#editQuestion()
     */
    @Override
    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		System.out.println("Choose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Edit Premise", "Quit"};
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
        	case "2": editPremises();
        	break;
        	case "3": cont = 10;
        	break;
        	default: System.out.println("Invalid Input...Try again..."); cont++;
        	break;
        	}
    	}
    	
    }

}