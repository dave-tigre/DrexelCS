import java.text.DecimalFormat;
import java.text.NumberFormat;
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
    		voice.voiceOutput("\nThis test has no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		voice.voiceOutput(x + ") ");
    		Questions.get(i).audio();		
    		voice.voiceOutput("\n\nThe Correct Response: " + correctResponses.get(Questions.get(i)).getResponse());
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
    	voice.printOutput("\n\nEnter Correct Response: ");
    	question.setResponse();
    	Response correctResponse = question.getResponse();
    	correctResponses.put(question, correctResponse);
    	
    }
    
    /*
     * Method to edit correct response
     */
    public void editCorrectResponse(Question q)
    {
    	voice.printOutput("\nEnter Correct Response: ");
    	q.setResponse();
    	Response correctResponse = q.getResponse();
    	//correctResponse.setUserResponse(getUserResponse());
    	correctResponses.replace(q, correctResponse);
    }
    
    /*
     * (non-Javadoc)
     * @see Survey#modifySurvey()
     */
    @Override
    public void modifySurvey()
    {
    	int count = 1;
    	voice.printOutput("\nWhat question do you want to modify?");
    	for(Question q : Questions)
    	{
    		voice.printOutput(count+") ");
    		q.display();
    		voice.printOutput("\n\nThe Correct Response: " + correctResponses.get(q).getResponse());
    		System.out.println("\n");
    		count++;
    		
    	}
    	voice.printOutput("\nEnter the number of the question you want to modify: ");
    	System.out.println();
    	String choice = getUserResponse();
    	int ch = string2int(choice) - 1;
    	if(withinRange(Questions.size(),ch))
    	{
    		Questions.get(ch).editQuestion();
    		voice.printOutput("\nDo you want to edit the Correct Response? Enter (y) for yes or (n) for no: ");
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
    		voice.voiceOutput("\nThere are no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		voice.voiceOutput(x + ") ");
    		Questions.get(i).audio();
    		voice.voiceOutput("\n\nEnter Your Response: ");
    		Questions.get(i).audioResponse();
        	Response userResponse = Questions.get(i).getResponse();
    		addResponse(Questions.get(i), userResponse);
    		System.out.println("\n");
    	}
    	NumberFormat formatter = new DecimalFormat("#0.00");   
    	voice.voiceOutput("\nGrade: "+formatter.format(calculateGrade()) +"%");
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
    
    /*
     * Method to print grade to console
     */
    public void printGrade()
    {
    	NumberFormat formatter = new DecimalFormat("#0.00");
    	voice.printOutput("\nGrade: "+formatter.format(grade) +"%");
    }
}