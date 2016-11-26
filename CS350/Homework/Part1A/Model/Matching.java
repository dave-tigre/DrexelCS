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
    		voice.printOutput("\nEnter Premise "+alpha[i-1]+") ");
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
    		voice.printOutput("\nEnter Choice "+i+")");
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
    		voice.printOutput("\nInput was not a valid integer... Try again..");
    		prchAmount();
    	}
    }

    /**
     * Display a matching question
     */
    @Override
    public void display() {
        // TODO implement here
    	voice.printOutput(getQuestionFormat()+" Question"); 
    	voice.printOutput("\n"+getPrompt());
    	System.out.println();
    	
    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.printf("%s) %-30s  %d) %s%n",alpha[i-1],premises.get(i-1),i,choices.get(i-1));
    	}
    }
    
    /**
     * speak a matching question
     */
    public void audio() {
        // TODO implement here
    	voice.voiceOutput(getQuestionFormat()+" Question"); 
    	voice.voiceOutput("\n"+getPrompt());
    	System.out.println();
    	
    	for(int i = 1; i <= premises.size(); i++)
    	{
    		System.out.printf("%s) %-30s  %d) %s%n",alpha[i-1],premises.get(i-1),i,choices.get(i-1));
    	}
    	voice.voicePremises(premises);
    	voice.voiceChoices(choices);
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
    		voice.printOutput("\nEnter Matching Answer of " +alpha[i] + ") "+premises.get(i) +": ");
    		rankingOrder +=getUserResponse()+" ";
    	}
    	qResponse = new Response();
    	qResponse.setUserResponse(rankingOrder);
    }
    
    public void audioResponse()
    {
    	String rankingOrder = "";// = "Matching Order From top to bottom: ";
    	//loop through to obtain matching choice to each premise
    	for(int i = 0; i< premises.size(); i++)
    	{
    		voice.voiceOutput("\nEnter Matching Answer of " +alpha[i] + ") "+premises.get(i) +": ");
    		rankingOrder +=getUserResponse()+" ";
    	}
    	qResponse = new Response();
    	qResponse.setUserResponse(rankingOrder);
    }
    
    /*
     * (non-Javadoc)
     * @see Question#displayResponse()
     */
    public void displayResponse()
    {
    	String response[] = getResponse().getResponse().split(" ");
    	for(int i = 0; i < response.length; i++)
    	{
    		voice.printOutput("\n"+alpha[i] +" " + response[i]);
    	}
    	System.out.println();
    	
    }
    
    /*
     * (non-Javadoc)
     * @see Question#editQuestion()
     */
    public void editQuestion()
    {
    	int cont = 0;
    	while(cont < 3)
    	{
    		voice.printOutput("\nChoose what you would like to edit:");
        	String options[] = {"Edit Prompt", "Edit Premise",  "Edit Choice", "Quit"};
        	for(int i = 0; i < options.length; i++)
        	{
        		int x = i+1;
        		voice.printOutput("\n"+x+") " +options[i]);
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
        	case "4": cont = 10;
        	break;
        	default: voice.printOutput("\nInvalid Input...Try again..."); cont++;
        	break;
        	}
    	}
    	
    }
    
    /*
     * Method to edit choices
     */
    public void editChoices()
    {
    	voice.printOutput("\nSelect the choice option you want to edit: ");
    	for(int i = 0; i < choices.size(); i++)
    	{
    		voice.printOutput("\n"+alpha[i] +") " + choices.get(i));
    	}
    	
    	String choice = getUserResponse();
    	if(Arrays.asList(alpha).contains(choice))
    	{
    		int ch = Arrays.asList(alpha).indexOf(choice);
    		if(ch < choices.size())
    		{
    			voice.printOutput("\nEnter Choice " + choice +")");
            	choices.set(ch, getUserResponse());
    		}
    		else
        	{
        		voice.printOutput("\nInvalid input... ");
        	}
    	}
    	else
    	{
    		voice.printOutput("\nInvalid input... ");
    	}
    	
    	
    }
    
    /*
     * Edit premises
     */
    public void editPremises()
    {
    	voice.printOutput("\nSelect the premise option you want to edit: ");
    	for(int i = 0; i < premises.size(); i++)
    	{
    		voice.printOutput("\n"+alpha[i] +") " + premises.get(i));
    	}
    	
    	String premise = getUserResponse();
    	if(Arrays.asList(alpha).contains(premise))
    	{
    		int ch = Arrays.asList(alpha).indexOf(premise);
    		if(ch < premises.size())
    		{
    			voice.printOutput("\nEnter Choice " + premise +")");
            	premises.set(ch, getUserResponse());
    		}
    		else
        	{
        		voice.printOutput("\nInvalid input... ");
        	}
    	}
    	else
    	{
    		voice.printOutput("\nInvalid input... ");
    	}
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