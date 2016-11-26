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
	
	public static Output voice = new Output();
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
    		voice.printOutput("\nThe '" +current.getName() +"' survey has been serialized and saved in the '" + folderName +"' folder.");
    	}
    	catch(IOException i)
    	{
    		voice.printOutput("\nError with saving survey... Try again....");
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
    		voice.printOutput("\nThe " + loadSurvey.getName() +" survey has been loaded...");
    	}
    	catch(IOException i)
    	{
    		voice.printOutput("\nError with loading survey... Try again....");
    		//i.printStackTrace();
    	}
    	catch(ClassNotFoundException c)
    	{
    		voice.printOutput("\nSurvey not found");
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
    		voice.printOutput("\nThe '" +current.getName() +"' test has been serialized and saved in the '" + folderName +"' folder.");
    	}
    	catch(IOException i)
    	{
    		voice.printOutput("\nError with saving test... Try again....");
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
    		voice.printOutput("\nThe " + loadTest.getName() +" test has been loaded...");
    	}
    	catch(IOException i)
    	{
    		voice.printOutput("\nError with laoding test... Try again....");
    	}
    	catch(ClassNotFoundException c)
    	{
    		voice.printOutput("\nTest not found");
    	}
    	return loadTest;
    	
    }

}