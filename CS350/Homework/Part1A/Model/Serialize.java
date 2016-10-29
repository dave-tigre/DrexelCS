import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Serialization Class
 */
public class Serialize {

	private String fileName;
    //private String storageLocation;
    
    
    /**
     * Default constructor
     */
    public Serialize() {
    }
    
    /**
     * 
     */
    public void Serialize() {
        // TODO implement here
    }

    /**
     * @param surveyMap
     */
    public void serialize(Survey current) {
        // TODO implement here
    	fileName = "saved_surveys/"+ current.getSurveyName()+ ".ser";
    	try{
    		FileOutputStream fileOut = new FileOutputStream(fileName);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(current);
    		out.close();
    		fileOut.close();
    		System.out.println("The " +current.getSurveyName() +" survey has been serialized and saved in " + fileName);
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with serialization... Try again....");
    		i.printStackTrace();
    	}
    }

    public Survey deserializeSurvey(String fileName)
    {
    	Survey loadSurvey = null;
    	try{
    		FileInputStream fileIn = new FileInputStream(fileName);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		loadSurvey = (Survey) in.readObject();
    		in.close();
    		fileIn.close();
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with serialization... Try again....");
    	}
    	catch(ClassNotFoundException c)
    	{
    		System.out.println("Survey not found");
    	}
    	System.out.println("The " + loadSurvey.getSurveyName() +" Survey has been loaded...");
    	return loadSurvey;
    }

    /**
     * 
     */
    public void serializeSurvey() {
        // TODO implement here
    }

    /**
     * 
     */
    public void serializeTest() {
        // TODO implement here
    }

}