
import java.io.Serializable;
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Test Class
 */
public class Test extends Survey {

    /**
     * Default constructor
     */
    public Test() {
    }

    private HashMap<String, Response>  userReponses = new HashMap<String, Response>();
    public String testName;
    private HashMap<String, Response>  correctResponses = new HashMap<String, Response>();
    private double grade;

    public void setTestName(String testName)
    {
    	this.testName = testName;
    }
    
    public String getTestName()
    {
    	return testName;
    }
    
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
     * @param question 
     * @param Response
     */
    public void setCorrectResponse(Question question) {
        // TODO implement here
    	System.out.println("Correct Response: ");
    	question.setResponse();
    	Response correctResponse = question.getResponse();
    	correctResponses.put(question.getPrompt(), correctResponse);
    	
    }

    /**
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
     * 
     */
    public void editResponse() {
        // TODO implement here
    }

    /**
     * @param grade
     */
    public void setGrade(double grade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public double getGrade() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    }

}