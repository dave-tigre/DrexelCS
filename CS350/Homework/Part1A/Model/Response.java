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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String response;

    /**
     * Default constructor
     */
    public Response() {
    }

    /**
     * @param inputResponse
     */
    @SuppressWarnings("resource")
	public void setUserResponse() {
        // TODO implement here
    	Scanner input = new Scanner(System.in);
    	String resp = input.nextLine();
    	this.response = resp;
    }
    
    /**
     * @param inputResponse
     */
    public void setUserResponse(String response) {
    	this.response = response;
    }
    
    public String getResponse()
    {
    	return response;
    }

    /**
     * 
     */
    public void display() {
        // TODO implement here
    	System.out.println(response);
    }

}