import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author David Tigreros
 * 10/15/2016
 * Survey Maker
 * 
 * Serialization Class
 */
public class Serialize {
    
    /**
     * Default constructor
     */
    public Serialize() {
    }

    /**
     * Method to serialize surveys
     * @param current : current survey using the method
     * @param folderName : folder that survey will be saved to
     */
    public void serializeSurvey(Survey current, final String folderName) {
        // TODO implement here
    	String fileName = folderName + "/"+ current.getName()+ ".ser";
    	try{
    		FileOutputStream fileOut = new FileOutputStream(fileName);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(current);
    		out.close();
    		fileOut.close();
    		System.out.println("The '" +current.getName() +"' survey has been serialized and saved in the '" + folderName +"' folder.");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with saving survey... Try again....");
    		return;
    	}
    }

    /*
     * Method to deserialize survey
     * @param fileName : file location and name of file being deserialized.
     */
    public Survey deserializeSurvey(final String fileName)
    {
    	Survey loadSurvey = null;
    	try{
    		FileInputStream fileIn = new FileInputStream(fileName);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		loadSurvey = (Survey) in.readObject();
    		in.close();
    		fileIn.close();
    		System.out.println("The " + loadSurvey.getName() +" survey has been loaded...");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with loading survey... Try again....");
    		//i.printStackTrace();
    	}
    	catch(ClassNotFoundException c)
    	{
    		System.out.println("Survey not found");
    	}
    	
    	return loadSurvey;
    }
    
    /**
     * Method to serialize tests
     * @param current : current test using the method
     * @param folderName : folder that test will be saved to
     */
    public void serializeTest(Test current, final String folderName) {
        // TODO implement here
    	String fileName = folderName + "/"+ current.getName()+ ".ser";
    	try{
    		FileOutputStream fileOut = new FileOutputStream(fileName);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(current);
    		out.close();
    		fileOut.close();
    		System.out.println("The '" +current.getName() +"' test has been serialized and saved in the '" + folderName +"' folder.");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with saving test... Try again....");
    		//i.printStackTrace();
    	}
    }
    
    /*
     * Method to deserialize test
     * @param fileName : file location and name of file being deserialized.
     */
    public Test deserializeTest(final String fileName)
    {
    	Test loadTest = null;
    	try{
    		FileInputStream fileIn = new FileInputStream(fileName);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		loadTest = (Test) in.readObject();
    		in.close();
    		fileIn.close();
    		System.out.println("The " + loadTest.getName() +" test has been loaded...");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with laoding test... Try again....");
    	}
    	catch(ClassNotFoundException c)
    	{
    		System.out.println("Survey not found");
    	}
    	return loadTest;
    	
    }

}