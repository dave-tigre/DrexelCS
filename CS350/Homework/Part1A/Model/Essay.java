
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Essay Class
 */
public class Essay extends Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int wordCount;
	
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

	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Essay";
	}

}