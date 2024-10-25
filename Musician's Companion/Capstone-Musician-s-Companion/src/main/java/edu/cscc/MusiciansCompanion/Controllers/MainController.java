package edu.cscc.MusiciansCompanion.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.cscc.MusiciansCompanion.Models.Challenge;
import edu.cscc.MusiciansCompanion.Models.ChallengeSettings;
import edu.cscc.MusiciansCompanion.Repositories.*;
import edu.cscc.MusiciansCompanion.Models.*;

@Controller
public class MainController {

	
	//Repositories for Challenge Generator
	@Autowired 
	GenreRepository genreRepo;
	@Autowired
	ModeRepository modeRepo;
	@Autowired
	MoodRepository moodRepo;
	@Autowired
	NoteRepository noteRepo;
	@Autowired
	TimeSignatureRepository timeSigRepo;
	
	@GetMapping("/MusiciansCompanion")
	public String getMainPage() {
		 
		return "musiciansCompanion";
	}
	
	@GetMapping("/MusiciansCompanion/ChallengeGenerator")
	public String getChallengeGenerator(Model model) {
		
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("modes", modeRepo.findAll());
		model.addAttribute("moods", moodRepo.findAll());
		model.addAttribute("notes", noteRepo.findAll());
		model.addAttribute("timeSigs", timeSigRepo.findAll());
		
		model.addAttribute("ChallengeSettings", new ChallengeSettings());
		
		return "challengeGenerator";
	}
	
	@PostMapping("/MusiciansCompanion/Challenge")
	public String createChallenge(@ModelAttribute("settings") ChallengeSettings settings, Model model) {
		Genre[] genres = settings.getGenres();
		
		Genre genre = genres[(int)(Math.random() * genres.length)];

		
		return "redirect:/MusiciansCompanion/Challenge";
	}
	
	@GetMapping("/MusiciansCompanion/Challenge")
	public String getChallenge(@ModelAttribute("Challenge") Challenge challenge, Model model) {
		
		return "challenge";
	}
	
	
	@GetMapping("/MusiciansCompanion/Metronome")
	public String getMetronome() {
		 
		
		return "temp";
	}
	
	@GetMapping("/MusiciansCompanion/ChordChallenge")
	public String getChordChallenge() {
		 
		
		return "temp";
	}
	
	@GetMapping("/MusiciansCompanion/DrumMachine")
	public String getDrumMachine() {
		 
		
		return "temp";
	}
	
	@GetMapping("/MusiciansCompanion/FindChordVoicings")
	public String getChordVoicings() {
		 
		
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
