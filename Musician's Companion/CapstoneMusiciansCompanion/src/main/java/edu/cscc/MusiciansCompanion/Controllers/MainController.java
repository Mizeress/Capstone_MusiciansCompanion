package edu.cscc.MusiciansCompanion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cscc.MusiciansCompanion.Repositories.*;
import lombok.extern.slf4j.Slf4j;
import edu.cscc.MusiciansCompanion.Models.*;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.Chord;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.ChordVoicingAlgorithm;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.ChordVoicingAlgorithmSettings;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.Fretboard;

@Controller
@Slf4j
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
	@Autowired
	ChordTypeRepository chordTypeRepo;
	
	
	
	@GetMapping("/MusiciansCompanion")
	public String getMainPage() {
		 
		return "musiciansCompanion";
	}
	
	
	//Endpoint for the Challenge Generator Page
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
	
	//Endpoint for the Challenge Display Page
	@GetMapping("/MusiciansCompanion/Challenge")
	public String getChallenge(@ModelAttribute("challenge") Challenge challenge, Model model) {
		
				
		return "challenge";
	}
	
	
	@GetMapping("/MusiciansCompanion/Metronome")
	public String getMetronome() {
		
		
		return "metronomePage";
	}
	
	//Endpoint to enter settings for the Chord Challenge Feature
	@GetMapping("/MusiciansCompanion/ChordChallengeGenerator")
	public String getChordChallengeGenerator(Model model) {
		model.addAttribute("chordTypes", chordTypeRepo.findAll());
		model.addAttribute("notes", noteRepo.findAll());
		
		model.addAttribute("chordChallengeSettings", new ChordChallengeSettings());
		
		return "chordChallengeGenerator";
	}
	
	//Logic to take Chord Challenge settings and get a specific chord out of it
	@PostMapping("/MusiciansCompanion/ChordChallenge")
	public String createChordChallenge(@ModelAttribute("settings") ChordChallengeSettings settings, Model model, RedirectAttributes redirectAttrbs) {
		Note note = settings.getNotes()[(int)(Math.random() * settings.getNotes().length)];
		ChordType chordType = settings.getChordTypes()[(int)(Math.random() * settings.getChordTypes().length)];
		int inversion = (int)(Math.random() * chordType.getNumNotes());
		int num = (int)(Math.random() * settings.getNum()) + 1;
		
		ChordChallenge chordChallenge = new ChordChallenge(settings.getType(), num, note, chordType, inversion);	
		
		redirectAttrbs.addFlashAttribute("chordChallenge", chordChallenge);
		
		return "redirect:/MusiciansCompanion/ChordChallenge";
	}
	
	//Display results of chord challenge
	@GetMapping("/MusiciansCompanion/ChordChallenge")
	public String getChordChallenge(@ModelAttribute("chordChallenge") ChordChallenge challenge, Model model) { 
		
		return "chordChallenge";
	}
	
	
	@GetMapping("/MusiciansCompanion/DrumMachine")
	public String getDrumMachine() {
		 
		
		return "temp";
	}
	
	@GetMapping("/MusiciansCompanion/FindChordVoicings")
	public String getChordVoicingPage(Model model) {
		ChordVoicingAlgorithmSettings settings = new ChordVoicingAlgorithmSettings();
		
		model.addAttribute("settings", settings);
				
		
		return "getChordVoicings";
	}
	
	@PostMapping("/MusiciansCompanion/ChordVoicing")
	public String getChordVoicings(@ModelAttribute("settings") ChordVoicingAlgorithmSettings settings, Model model, RedirectAttributes redirectAttrbs) {
		
		//TODO Create a chord voicing algorithm
		
				//Get num frets and tuning - instantiate fretboard
				
				//get chord and max distance - instantiate Chord Voicing Algorithm 
		
		String[] tuning = settings.getTuning().replaceAll("\\s", "").split(",");
		
		Fretboard fretboard = new Fretboard(settings.getNumFrets(), tuning);
		
		String[] chord = settings.getChord().replaceAll("\\s", "").split(",");
		
		System.out.println("chord: " + chord);
		ChordVoicingAlgorithm cva = new ChordVoicingAlgorithm(chord, fretboard, settings.getMaxDistance());
		System.out.println("cva: " + cva);
		
		
		
		System.out.println(cva.getVoicings().size());
		
		redirectAttrbs.addFlashAttribute("cva", cva);
		
		return "redirect:/MusiciansCompanion/ChordVoicings";
	}
	
	@GetMapping("/MusiciansCompanion/ChordVoicings")
	public String getChordVoicingPage(@ModelAttribute("cva") ChordVoicingAlgorithm cva, Model model) {
		
		List<Chord> chords = cva.getVoicings();
		
		//System.out.println(cva.voicings.size());
		
		model.addAttribute("chords", chords);
		
		return "chordVoicings";
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
