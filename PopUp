import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;


public class PopUp {


	//attributes
	private int channel;
	private int volume;
	private int duration;

	//constructor
	public PopUp(){
		channel = 9;
		volume = 127;
		duration = 1;			
	}

	public void play(){
		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			MidiChannel[] channels = synth.getChannels();
			int pitch=72;
			playNote(pitch, channels, 500);

			synth.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public void playNote(int pitch, MidiChannel[] channels, int m) throws InterruptedException{
		channels[channel].noteOn(pitch, volume);
		Thread.sleep(duration*m);
		channels[channel].noteOff(pitch);	
		}

	}

