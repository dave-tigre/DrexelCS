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
     * @param surveyMap
     */
    public void serializeSurvey(Survey current, final String folderName) {
        // TODO implement here
    	String fileName = folderName + "/"+ current.getSurveyName()+ ".ser";
    	try{
    		FileOutputStream fileOut = new FileOutputStream(fileName);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(current);
    		out.close();
    		fileOut.close();
    		System.out.println("The '" +current.getSurveyName() +"' survey has been serialized and saved in the '" + folderName +"' folder.");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with saving survey... Try again....");
    		return;
    	}
    }

    public Survey deserializeSurvey(final String fileName)
    {
    	Survey loadSurvey = null;
    	try{
    		FileInputStream fileIn = new FileInputStream(fileName);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		loadSurvey = (Survey) in.readObject();
    		in.close();
    		fileIn.close();
    		System.out.println("The " + loadSurvey.getSurveyName() +" survey has been loaded...");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with loading survey... Try again....");
    		i.printStackTrace();
    	}
    	catch(ClassNotFoundException c)
    	{
    		System.out.println("Survey not found");
    	}
    	
    	return loadSurvey;
    }
    
    public void serializeTest(Test current, final String folderName) {
        // TODO implement here
    	String fileName = folderName + "/"+ current.getTestName()+ ".ser";
    	try{
    		FileOutputStream fileOut = new FileOutputStream(fileName);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(current);
    		out.close();
    		fileOut.close();
    		System.out.println("The '" +current.getTestName() +"' test has been serialized and saved in the '" + folderName +"' folder.");
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error with saving test... Try again....");
    		//i.printStackTrace();
    	}
    }
    
    public Test deserializeTest(final String fileName)
    {
    	Test loadTest = null;
    	try{
    		FileInputStream fileIn = new FileInputStream(fileName);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		loadTest = (Test) in.readObject();
    		in.close();
    		fileIn.close();
    		System.out.println("The " + loadTest.getTestName() +" test has been loaded...");
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