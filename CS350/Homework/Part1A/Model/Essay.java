
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Essay Class
 */
public class Essay extends Question {

	public int wordCount;
	private Response userResponse;
    /**
     * Default constructor
     */
    public Essay() {
    }

    /**
     * 
     */
    public void display() {
        super.display();
    }

    /**
     * 
     */
    public void getWordCount() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Essay createQuestion() {
        // TODO implement here
        return null;
    }

	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Essay";
	}

}