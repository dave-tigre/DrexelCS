
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
    private HashMap<String, Answer>  correctAnswers = new HashMap<String, Answer>();
    private double grade;

    public void setTestName(String testName)
    {
    	this.testName = testName;
    }
    
    public String getTestName()
    {
    	return testName;
    }

    /**
     * @param question 
     * @param answer
     */
    public void setCorrectAnswer(Question question, Answer answer) {
        // TODO implement here
    }

    /**
     * @param question 
     * @param answer 
     * @param response 
     * @return
     */
    public boolean compareAnswer(Question question, Answer answer, Response response) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void editAnswer() {
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
     * @param testMap 
     * @param answers 
     * @param grade
     */
    public void serialize(HashMap<String, Response>  testMap, HashMap<String, Answer>  answers, double grade) {
        // TODO implement here
    }

    /**
     * @param question 
     * @param response
     */
    public void addResponse(Question question, Response response) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Test createTest() {
        // TODO implement here
        return null;
    }

}