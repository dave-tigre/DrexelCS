
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
     * @see MultipleChoice#getQuestionFormat()
     */
    @Override
    public String getQuestionFormat() {
    	return "True/False";
    }

}