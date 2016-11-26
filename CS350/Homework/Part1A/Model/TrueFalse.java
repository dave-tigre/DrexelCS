
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
    
    /*
     * (non-Javadoc)
     * @see MultipleChoice#editQuestion()
     */
    @Override
    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		voice.printOutput("\nChoose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Quit"};
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
        	case "2": cont = 10;
        	break;
        	default: voice.printOutput("\nInvalid Input... Try Again..."); cont++;
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
    	return "True or False";
    }

}