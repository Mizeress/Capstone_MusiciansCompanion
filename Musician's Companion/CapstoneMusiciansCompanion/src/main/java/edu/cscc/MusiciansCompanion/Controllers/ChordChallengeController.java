package edu.cscc.MusiciansCompanion.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cscc.MusiciansCompanion.Models.ChordChallenge;
import edu.cscc.MusiciansCompanion.Models.ChordChallengeSettings;
import edu.cscc.MusiciansCompanion.Models.ChordType;
import edu.cscc.MusiciansCompanion.Models.Note;
import edu.cscc.MusiciansCompanion.Repositories.ChordTypeRepository;
import edu.cscc.MusiciansCompanion.Repositories.NoteRepository;

@Controller
public class ChordChallengeController {
	
	@Autowired
	NoteRepository noteRepo;
	@Autowired
	ChordTypeRepository chordTypeRepo;
	
	
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
}
