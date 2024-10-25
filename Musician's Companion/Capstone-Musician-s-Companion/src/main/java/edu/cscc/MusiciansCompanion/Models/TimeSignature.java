package edu.cscc.MusiciansCompanion.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Entity
public class TimeSignature {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int beatNote;
	private int beatPerMeasure;
	
	
	public int getBeatNote() {
		return beatNote;
	}
	public void setBeatNote(int beatNote) {
		this.beatNote = beatNote;
	}
	public int getBeatPerMeasure() {
		return beatPerMeasure;
	}
	public void setBeatPerMeasure(int beatPerMeasure) {
		this.beatPerMeasure = beatPerMeasure;
	}
	
	public long getId() {
		return id;
	}
	
}
