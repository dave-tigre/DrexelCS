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

    public String testName;
    private HashMap<Question, Response>  correctResponses = new HashMap<Question, Response>(); //responses of test creator
    private double grade = 0; // grading score when test is taken
    
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
    		System.out.println("\nThe Correct Response: " + correctResponses.get(Questions.get(i)).getResponse());
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
    	question.display();
    	System.out.println("\nEnter Correct Response: ");
    	question.setResponse();
    	Response correctResponse = question.getResponse();
    	correctResponses.put(question, correctResponse);
    	
    }
    
    public void editCorrectResponse(Question q)
    {
    	System.out.println("Enter Correct Response: ");
    	q.setResponse();
    	Response correctResponse = q.getResponse();
    	//correctResponse.setUserResponse(getUserResponse());
    	correctResponses.replace(q, correctResponse);
    }
    
    @Override
    public void modifySurvey()
    {
    	int count = 1;
    	System.out.println("What question do you want to modify?");
    	for(Question q : Questions)
    	{
    		System.out.print(count+") ");
    		q.display();
    		System.out.println("\nThe Correct Response: " + correctResponses.get(q).getResponse());
    		System.out.println("\n");
    		count++;
    		
    	}
    	System.out.println("Enter the number of the question you want to modify: ");
    	System.out.println();
    	String choice = getUserResponse();
    	int ch = string2int(choice) - 1;
    	if(withinRange(Questions.size(),ch))
    	{
    		Questions.get(ch).editQuestion();
        	System.out.println("Do you want to edit the Correct Response (y/n)? ");
        	choice = getUserResponse();
        	if(choice.equals("y") || choice.equals("Y"))
        		editCorrectResponse(Questions.get(ch));
    	}
    	
    	
    	
    }

    /**
     * Method to be used to compare responses
     * @param question 
     * @param Response 
     * @param response 
     * @return
     */
    public boolean compareResponse(Question question, Response userResponse) {
        // TODO implement here
    	String correctResponse = correctResponses.get(question).getResponse();
    	String user = getCurrentResponse(question).getResponse();
    	if(user.equals(correctResponse))
    	{
    		return true;
    	}
    	
        return false;
    }

    /**
     * Method to be used to grade test
     * @param grade
     */
    public double calculateGrade() {
        // TODO implement here
    	double total = Questions.size();
    	double user = 0;
    	for(Question q : currentResponses.keySet())
    	{
    		if(compareResponse(q,currentResponses.get(q)) == true)
				user++;

    	}
    	grade = (user/total)*100;
    	return (user/total)*100;
    	
    }
    
    /**
     * Method to display a survey
     */
    public void takeSurvey() {
        // TODO implement here
    	if(Questions.size() < 1)
    	{
    		System.out.println("There are no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		System.out.print(x + ") ");
    		Questions.get(i).display();
    		System.out.println("\nEnter Your Response: ");
    		Questions.get(i).setResponse();
        	Response userResponse = Questions.get(i).getResponse();
    		addResponse(Questions.get(i), userResponse);
    		System.out.println("\n");
    	}
    	System.out.println("Grade: "+calculateGrade() +"%");
    	System.out.println("\n");
    }

    /**
     * Method to be used to return test grade
     * @return test grade
     */
    public double getGrade() {
        // TODO implement here
        return grade;
    }
    
    public void printGrade()
    {
    	System.out.println("Grade: "+grade +"%");
    }
}