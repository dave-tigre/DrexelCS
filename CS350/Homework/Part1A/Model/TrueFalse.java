
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * True of False Question
 */

public class TrueFalse extends MultipleChoice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    	System.out.println("A) " + choices[0]);
    	System.out.println("B) " + choices[1]);

    }

    /**
     * @return
     */
    public TrueFalse createQuestion() {
        // TODO implement here
        return null;
    }
    
    @Override
    public String getQuestionFormat() {
    	return "True/False";
    }

}