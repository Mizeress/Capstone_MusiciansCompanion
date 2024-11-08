package edu.cscc.MusiciansCompanion.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//Create a random challenge based off of settings defined by the user
	@PostMapping("/MusiciansCompanion/Challenge")
	public String createChallenge(@ModelAttribute("settings") ChallengeSettings settings, RedirectAttributes redirectAttrs) {
		//Get the options for each field
		Genre[] genres = settings.getGenres();
		Mode[] modes = settings.getModes();
		Mood[] moods = settings.getMoods();
		Note[] notes = settings.getHomeNotes();
		TimeSignature[] timeSigs = settings.getTimeSigs(); 
		
		//Randomly pick from the option
		Genre genre = genres[(int)(Math.random() * genres.length)];
		Mode mode = modes[(int)(Math.random() * modes.length)];
		Mood mood = moods[(int)(Math.random() * moods.length)];
		Note note = notes[(int)(Math.random() * notes.length)];
		TimeSignature timeSig = timeSigs[(int)(Math.random() * timeSigs.length)];
		
		//Create challenge
		Challenge challenge = new Challenge(note, mode, timeSig, mood, genre);
		
		//Pass challenge to the GetChallenge endpoint
		redirectAttrs.addFlashAttribute("challenge", challenge);
		

		
		return "redirect:/MusiciansCompanion/Challenge";
	}
	
	@GetMapping("/MusiciansCompanion/Challenge")
	public String getChallenge(@ModelAttribute("challenge") Challenge challenge, Model model) {
		
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
