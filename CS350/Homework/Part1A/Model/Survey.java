
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Survey Class
 */
public class Survey {

    /**
     * Default constructor
     */
    public Survey() {
    }

    public ArrayList<Question> Questions = new ArrayList<Question>();
    private HashMap<String, Response> userResponses = new HashMap<String, Response>();
    public String surveyName;
    int numberOfQuestions;


    public void setSurveyName(String testName)
    {
    	this.surveyName = testName;
    }
    
    public String getSurveyName()
    {
    	return surveyName;
    

    }

    /**
     * 
     */
    public void addQuestion(Question q) {
        Questions.add(q);
    }

    /**
     * @param questionNumber 
     * @return
     */
    public Question getQuestion(int questionNumber) {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void removeQuestion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void editQuestion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void display() {
        // TODO implement here
    	Response response = new Response();
    	for(int i = 0; i < Questions.size();i++)
    	{
    		Questions.get(i).display();
    		response.setUserResponse();
    		addResponse(Questions.get(i), response);
    	}
    	System.out.println("End of the Survey... Thank you!");
    	
    }

    /**
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getUserResponse() 
    {
    	
    	
    	}

    /**
     * @param surveyMap
     */
    public void serialize(HashMap<String, Response> surveyMap) {
        // TODO implement here
    }

    /**
     * 
     */
    public void tabulateData() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Survey createSurvey() {
        // TODO implement here
        return null;
    }

}