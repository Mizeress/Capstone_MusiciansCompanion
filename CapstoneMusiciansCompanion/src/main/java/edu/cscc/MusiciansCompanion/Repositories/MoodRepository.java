package edu.cscc.MusiciansCompanion.Repositories;

import org.springframework.data.repository.CrudRepository;

import edu.cscc.MusiciansCompanion.Models.Mood;

public interface MoodRepository extends CrudRepository<Mood, Long> {

}
