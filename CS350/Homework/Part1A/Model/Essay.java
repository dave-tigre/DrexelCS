
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Essay Class
 * This class is a child of the Question class for Essay Questions
 */
public class Essay extends Question {

	private static final long serialVersionUID = 1L; //for serialization
	public int wordCount; //word count of essay
	
    /**
     * Default constructor
     */
    public Essay() {
    }

    /**
     * Display the essay Question as you would the super class
     */
    public void display() {
        super.display();
    }

    /**
     * To be used when tabulating data
     */
    public void getWordCount() {
        // TODO implement here
    }

    /*
     * returns the string of the question format
     * @see Question#getQuestionFormat()
     */
	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Essay";
	}

}