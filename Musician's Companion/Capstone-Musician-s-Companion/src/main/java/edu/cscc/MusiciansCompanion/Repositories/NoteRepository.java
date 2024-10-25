package edu.cscc.MusiciansCompanion.Repositories;

import org.springframework.data.repository.CrudRepository;

import edu.cscc.MusiciansCompanion.Models.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
