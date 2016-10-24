
import java.util.*;

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

    /**
     * Default constructor
     */
    public MultipleChoice() {
    	
    } 

    /**
     * @param choices
     */
    public void addChoices(String ch) {
        // TODO implement here
    	
    	String chs[] = ch.split(",");
    	for(String choice : chs)
    	{
    		choices.add(choice);
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
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());
    	for(int i = 0; i < choices.size(); i++)
    	{
    		System.out.println(i + ") " + choices.get(i));
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
    public MultipleChoice createQuestion() {
        // TODO implement here
        return null;
    }

}