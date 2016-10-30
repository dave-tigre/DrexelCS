
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Short Answer Question
 */
public class ShortAnswer extends Essay {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int maxWordCount;
    /**
     * Default constructor
     */
    public ShortAnswer() {
    }

    /**
     * @return
     */
    public ShortAnswer createQuestion() {
        // TODO implement here
        return null;
    }
    
    @Override
    public String getQuestionFormat() {
    	return "Short Answer";
    }

}