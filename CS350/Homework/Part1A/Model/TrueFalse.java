
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * True of False Question
 */

public class TrueFalse extends MultipleChoice {

	private Response userResponse;
	private final String choices[] = {"True", "False"};
	
    /**
     * Default constructor
     */
    public TrueFalse() {
    }

    /**
     * 
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());
    	for(int i = 0; i < choices.length; i++)
    	{
    		System.out.println(i + ") " + choices[i]);
    	}
    }

    /**
     * 
     */
    public void getUserResponse() {
        // TODO implement here
    }

    /**
     * @return
     */
    public TrueFalse createQuestion() {
        // TODO implement here
        return null;
    }

}