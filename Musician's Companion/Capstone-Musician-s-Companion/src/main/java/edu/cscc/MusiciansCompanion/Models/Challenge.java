package edu.cscc.MusiciansCompanion.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge {
	Note homeNote;
	Mode mode;
	TimeSignature timeSig;
	Mood mood;
	Genre genre;
	
	public String toString() {
		String string = "Note: " + homeNote.toString() + "\nMode: " + mode.getName() + "Time Signature: " + timeSig.getBeatPerMeasure() + '/' + timeSig.getBeatNote()
		+ "Mood: " + mood.getName() + "Genre: " + genre.getName();
		
		return string;
	}
}
