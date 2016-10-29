import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Survey Class
 */
public class Survey implements Serializable {

    /**
     * Default constructor
     */
    public Survey() {
    }

    public ArrayList<Question> Questions = new ArrayList<Question>();
    private HashMap<String, Response> userResponses = new HashMap<String, Response>();
    private String surveyName;
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
    	if(Questions.size() < 1)
    	{
    		System.out.println("This survey has no questions...\n");
    		return;
    	}
    	for(int i = 0; i < Questions.size();i++)
    	{
    		int x = i+1;
    		System.out.print(x + ") ");
    		Questions.get(i).display();
    		System.out.println("\n");
    	}
    	System.out.println("\n");
    }

    /**
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    	userResponses.put(question.getPrompt(), response);
    }

    /**
     * 
     */
    public void getUserResponse() 
    {
    	
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