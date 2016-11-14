import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Matching Questions
 *
 */
public class Matching extends Question {

	private static final long serialVersionUID = 1L; //for serialization
    public ArrayList<String> choices = new ArrayList<String>(); // array list of choices
    public ArrayList<String> premises = new ArrayList<String>(); //array list of premises
    protected int numOfprch; // number of premises/choices
    
    
    /**
     * Default constructor
     */
    public Matching() {
  
    }
    
    /*
     * Add premises to array list one at a time
     */
    public void addPremises()
    {
    	for(int i = 1; i <= numOfprch; i++)
    	{
    		System.out.println("Enter Premise #"+i);
    		premises.add(getUserResponse());
    	}
    }
    
    /*
     * Add choices to array list one at a time
     */
    public void addChoices()
    {
    	for(int i = 1; i <= numOfprch; i++)
    	{
    		System.out.println("Enter Choice "+alpha[i-1]+")");
    		choices.add(getUserResponse());
    	}
    }
    
    /*
     * Premise/Choices Amount
     */
    public void prchAmount()
    {
    	String prch = getUserResponse();
    	try
    	{
    		numOfprch = Integer.parseInt(prch);
    	}
    	catch(NumberFormatException nfe)
    	{
    		System.out.println("Input was not a valid integer... Try again..");
    		prchAmount();
    	}
    }

    /**
     * Display a matching question
     */
    @Override
    public void display() {
        // TODO implement here
    	System.out.println(getPrompt());
    	int space = 0;
    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.printf("%s) %-6s  %6d) %s%n",alpha[i-1],premises.get(i-1),i,choices.get(i-1));
    	}
    }

    /*
     * (non-Javadoc)
     * @see Question#setResponse()
     */
    @Override
    public void setResponse()
    {
    	String rankingOrder = "";// = "Matching Order From top to bottom: ";
    	//loop through to obtain matching choice to each premise
    	for(int i = 0; i< premises.size(); i++)
    	{
    		System.out.println("Enter Matching Answer of " +alpha[i] + ") "+premises.get(i) +": ");
    		rankingOrder +=getUserResponse()+" ";
    	}
    	qResponse = new Response();
    	qResponse.setUserResponse(rankingOrder);
    }
    
    public void displayResponse()
    {
    	String response[] = getResponse().getResponse().split(" ");
    	for(int i = 0; i < response.length; i++)
    	{
    		System.out.println(alpha[i] +" " + response[i]);
    	}
    	System.out.println();
    	
    }
    
    public void editQuestion()
    {
    	System.out.println("Choose what you would like to edit:");
    	String options[] = {"Edit Prompt", "Edit Premise",  "Edit Choice", "Quit"};
    	for(int i = 0; i < options.length; i++)
    	{
    		int x = i+1;
    		System.out.println(x+") " +options[i]);
    	}
    	String choice = getUserResponse();
    	switch(choice)
    	{
    	case "1": editPrompt();
    	break;
    	case "2": editPremises();
    	break;
    	case "3": editChoices();
    	break;
    	case "4": return;
    	default: System.out.println("Invalid Input...");
    	break;
    	}
    }
    
    public void editChoices()
    {
    	System.out.println("Select the choice option you want to edit: ");
    	for(int i = 0; i < choices.size(); i++)
    	{
    		System.out.println(alpha[i] +") " + choices.get(i));
    	}
    	
    	String choice = getUserResponse();
    	int ch = Arrays.asList(alpha).indexOf(choice);
    	System.out.println("Enter Choice " + choice +")");
    	choices.set(ch, getUserResponse());
    	
    }
    
    public void editPremises()
    {
    	System.out.println("Select the premise option you want to edit: ");
    	for(int i = 0; i < premises.size(); i++)
    	{
    		System.out.println(alpha[i] +") " + premises.get(i));
    	}
    	
    	String premise = getUserResponse();
    	int ch = Arrays.asList(alpha).indexOf(premise);
    	System.out.println("Enter Choice " + premise +")");
    	premises.set(ch, getUserResponse());
    }

    /*
     * (non-Javadoc)
     * @see Question#getQuestionFormat()
     */
	@Override
	public String getQuestionFormat() {
		// TODO Auto-generated method stub
		return "Matching";
	}

}