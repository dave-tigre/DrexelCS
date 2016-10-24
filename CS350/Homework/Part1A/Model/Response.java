
import java.util.*;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Response Class
 */
public class Response {

    /**
     * Default constructor
     */
    public Response() {
    }

    /**
     * 
     */
    private String response;




    /**
     * @param inputResponse
     */
    public void setUserResponse() {
        // TODO implement here
    	Scanner input = new Scanner(System.in);
    	String resp = input.nextLine();
    	this.response = resp;
    }

    /**
     * 
     */
    public void display() {
        // TODO implement here
    	System.out.println(response);
    }

}