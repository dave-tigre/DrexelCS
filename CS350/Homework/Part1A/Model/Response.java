 import java.io.Serializable;
import java.util.Scanner;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Response Class
 */
public class Response implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String response;

    /**
     * Default constructor
     */
    public Response() {
    }

    /**
     * Set the user response from the console.
     */
    @SuppressWarnings("resource")
	public void setUserResponse() {
        // TODO implement here
    	Scanner input = new Scanner(System.in);
    	String resp = input.nextLine();
    	this.response = resp;
    }
    
    /**
     * Set the user response from a given string
     * @param response
     */
    public void setUserResponse(String response) {
    	this.response = response;
    }

    
    /*
     * @return the response
     */
    public String getResponse()
    {
    	return response;
    }

    /**
     * method to display response
     */
    public void display() {
        // TODO implement here
    	System.out.println(response);
    }

}