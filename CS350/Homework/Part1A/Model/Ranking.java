
/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Ranking Question
 */
public class Ranking extends Matching {

	private Response userResponse;
    /**
     * Default constructor
     */
    public Ranking() {
    }

    /**
     * 
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());

    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.println("____ " + premises.get(i-1));
    	}
    	
    	String alpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
    	System.out.print(alpha[0] + ") " + 1);
    	for(int i = 1; i < premises.size(); i++)
    	{
    		int x = i+1;
    		System.out.print("	" +alpha[i] + ") "  + x);
    	}
    }


    /**
     * @return
     */
    public Ranking createQuestion() {
        // TODO implement here
        return null;
    }
    
    @Override
    public String getQuestionFormat() {
    	return "Ranking";
    }

}