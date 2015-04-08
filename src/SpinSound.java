import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;

public class SpinSound {
	//attributes
	private int channel;
	private int volume;
	private int duration;

	//constructor
	public SpinSound(){
		channel = 9;
		volume = 127;
		duration = 1;			
	}

	public void play(){
		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			MidiChannel[] channels = synth.getChannels();

			int pitch=60;
			//loop though melody string
			for(int i=30;i<100;i++){
				//alternates between C and D
				if(i%2==0){
					pitch=60;
					playNote(pitch, channels, i);
				}	
				
				else{
					pitch=62;
					playNote(pitch, channels, i);
				}
				
			}
			
			for(int i=1;i<20;i++ ){
				if(i%2==0){
					pitch=60;
					playNote(pitch, channels, 100+i*4);
				}	
				
				else{
					pitch=62;
					playNote(pitch, channels, 100+i*4);
				}
			}


			synth.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	//method to play notes
	public void playNote(int pitch, MidiChannel[] channels, int m) throws InterruptedException{
		channels[channel].noteOn(pitch, volume);
		Thread.sleep(duration*m);
		channels[channel].noteOff(pitch);	
	}
	

}
