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

	private static final long serialVersionUID = 1L;
	public ArrayList<Question> Questions = new ArrayList<Question>();
    private HashMap<String, Response> userResponses = new HashMap<String, Response>();
    public String name;
    public int numberOfQuestions;
    
	/**
     * Default constructor
     */
    public Survey() {
    }
    
    /*
     * Set survey name.
     */
    public void setName(String name)
    {
    	this.name = name;
    }
    
    /*
     * return survey name
     */
    public String getName()
    {
    	return name;
    }

    /**
     * Method to add question to survey
     * @param q : given question to add to survey
     */
    public void addQuestion(Question q) {
        Questions.add(q);
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
     * Method to display a survey
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
     * Method to be used to take in survey taker response
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    	userResponses.put(question.getPrompt(), response);
    }


    /**
     * Method to be used to tabulate data 
     */
    public void tabulateData() {
        // TODO implement here
    }

}