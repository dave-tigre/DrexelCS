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
    public ArrayList<String> choices;
    
    
    /**
     * Default constructor
     */
    public Matching() {
  
    }

    /**
     * 
     */
    public void display() {
        // TODO implement here
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