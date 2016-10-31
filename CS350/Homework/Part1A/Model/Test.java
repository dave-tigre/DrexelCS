import java.util.HashMap;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Test Class
 */
public class Test extends Survey {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public Test() {
    }

    private HashMap<String, Response>  userReponses = new HashMap<String, Response>(); //responses of test taker
    public String testName;
    private HashMap<String, Response>  correctResponses = new HashMap<String, Response>(); //responses of test creator
    private double grade; // grading score when test is taken
    
    /*
     * (non-Javadoc)
     * @see Survey#display()
     */
    @Override
    public void display()
    {
    	 // TODO implement here
    	if(Questions.size() < 1)
    	{
    		System.out.println("This test has no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		System.out.print(x + ") ");
    		Questions.get(i).display();		
    		System.out.println("\nThe Correct Response: " + correctResponses.get(Questions.get(i).getPrompt()).getResponse());
    		System.out.println("\n");
    	}
    	System.out.println();
    }

    /**
     * Method for test creator to set the correct response to a question
     * @param question 
     * @param Response
     */
    public void setCorrectResponse(Question question) {
        // TODO implement here
    	System.out.println("Enter Correct Response: ");
    	question.setResponse();
    	Response correctResponse = question.getResponse();
    	correctResponses.put(question.getPrompt(), correctResponse);
    	
    }

    /**
     * Method to be used to compare responses
     * @param question 
     * @param Response 
     * @param response 
     * @return
     */
    public boolean compareResponse(Question question, Response userResponse, Response correctResponse) {
        // TODO implement here
        return false;
    }

    /**
     * method to be used to edit responses
     */
    public void editResponse() {
        // TODO implement here
    }

    /**
     * Method to be used to grade test
     * @param grade
     */
    public void setGrade(double grade) {
        // TODO implement here
    }

    /**
     * Method to be used to return test grade
     * @return test grade
     */
    public double getGrade() {
        // TODO implement here
        return 0.0;
    }

    /**
     * Method to be used to add test taker response 
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    }

}