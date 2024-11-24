package edu.cscc.MusiciansCompanion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


	
	@GetMapping("/MusiciansCompanion")
	public String getMainPage() {
		 
		return "musiciansCompanion";
	}
	
	
	@GetMapping("/MusiciansCompanion/Metronome")
	public String getMetronome() {
		
		
		return "metronomePage";
	}
	
	
	@GetMapping("/MusiciansCompanion/DrumMachine")
	public String getDrumMachine() {
		 
		
		return "temp";
	}
	
	
	
	
	@GetMapping("/MusiciansCompanion/AudioToRhythm")
	public String getAudioToRhythm() {
		 
		
		return "temp";
	}
	
	@GetMapping("/MusiciansCompanion/Notation")
	public String getNotation() {
		 
		
		return "temp";
	}
	
	@GetMapping("/MusiciansCompanion/Looper")
	public String getLooper() {
		 
		
		return "temp";
	}
}
