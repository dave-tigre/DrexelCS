
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Multiple Choice Question
 */
public class MultipleChoice extends Question {

	public ArrayList<String> choices;
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
    	choices.add(ch);
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