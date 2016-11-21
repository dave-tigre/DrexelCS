
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * True of False Question
 */

public class TrueFalse extends MultipleChoice {

	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor
     */
    public TrueFalse() {
    	choices.add("True");
    	choices.add("False");
    }
    
    @Override
    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		System.out.println("Choose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Quit"};
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
        	case "2": cont = 10;
        	break;
        	default: System.out.println("Invalid Input... Try Again..."); cont++;
        	break;
        	}
    	}
    	
    }
    /*
     * (non-Javadoc)
     * @see MultipleChoice#getQuestionFormat()
     */
    @Override
    public String getQuestionFormat() {
    	return "True/False";
    }

}