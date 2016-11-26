import java.util.ArrayList;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * 
 */

/**
 * @author dave-tigre
 * Output
 * Class used to abstract the output text into speech
 *
 */
public class Output {

	public final String alpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
			"P","Q","R","S","T","U","V","W","X","Y","Z"};
	/**
	 * 
	 */
	public Output() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public void voiceOutput(String words)
	{
		String voiceName = "kevin16";
	    
	    VoiceManager voiceManager = VoiceManager.getInstance();
	    Voice voice = voiceManager.getVoice(voiceName);
        System.out.print(words);
        voice.allocate();
        voice.speak(words);
        voice.deallocate();
	}
	
	public void printOutput(String words)
	{
		System.out.print(words);
	}
	
	public void voicePremises(ArrayList<String> premises)
	{
		String voiceName = "kevin16";
	    
	    VoiceManager voiceManager = VoiceManager.getInstance();
	    Voice voice = voiceManager.getVoice(voiceName);
		voice.allocate();
		voice.speak("The Premises are:");
        for(int i = 0; i< premises.size();i++)
        {
        	voice.speak(alpha[i]+") " + premises.get(i));
        }
        voice.deallocate();
	}
	
	public void voiceChoices(ArrayList<String> choices)
	{
		String voiceName = "kevin16";
	    
	    VoiceManager voiceManager = VoiceManager.getInstance();
	    Voice voice = voiceManager.getVoice(voiceName);
		voice.allocate();
		voice.speak("The Choices are:");
        for(int i = 0; i< choices.size();i++)
        {
        	voice.speak((i+1) + choices.get(i));
        }
        voice.deallocate();
	}

}
