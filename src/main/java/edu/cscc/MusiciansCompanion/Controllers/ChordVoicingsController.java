package edu.cscc.MusiciansCompanion.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.Chord;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.ChordVoicingAlgorithm;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.ChordVoicingAlgorithmSettings;
import edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm.Fretboard;

@Controller
public class ChordVoicingsController {

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
		
		ChordVoicingAlgorithm cva = new ChordVoicingAlgorithm(chord, fretboard, settings.getMaxDistance());	
				
		System.out.println(cva.getVoicings().size());
		
		redirectAttrbs.addFlashAttribute("cva", cva);
		
		return "redirect:/MusiciansCompanion/ChordVoicings";
	}
	
	@GetMapping("/MusiciansCompanion/ChordVoicings")
	public String getChordVoicingPage(@ModelAttribute("cva") ChordVoicingAlgorithm cva, Model model) {
		
		List<Chord> chords = cva.getVoicings();
		
		String[] tuning = cva.getFretboard().getTuning();

		
		model.addAttribute("chords", chords);
		
		model.addAttribute("tuning", tuning);
		
		return "chordVoicings";
	}
	
}
