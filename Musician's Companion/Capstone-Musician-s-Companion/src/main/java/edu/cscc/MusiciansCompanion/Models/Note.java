package edu.cscc.MusiciansCompanion.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Entity
public class Note {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private char noteLetter;
	private boolean isSharp;
	private boolean isFlat;
	
	public char getNoteLetter() {
		return noteLetter;
	}
	public void setNoteLetter(char noteLetter) {
		this.noteLetter = noteLetter;
	}
	public boolean isSharp() {
		return isSharp;
	}
	public void setSharp(boolean isSharp) {
		this.isSharp = isSharp;
	}
	public boolean isFlat() {
		return isFlat;
	}
	public void setFlat(boolean isFlat) {
		this.isFlat = isFlat;
	}
	
	public long getId() {
		return id;
	}
	
	public String toString() {
		char addOn;
		if(isFlat) {
			addOn = 'b';
		} else if(isSharp) {
			addOn = '#';
		} else {
			addOn = ' ';
		}
		
		return String.valueOf(noteLetter) + String.valueOf(addOn);
	}
	
}
