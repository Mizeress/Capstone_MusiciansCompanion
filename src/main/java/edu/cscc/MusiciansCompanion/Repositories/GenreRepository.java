package edu.cscc.MusiciansCompanion.Repositories;

import org.springframework.data.repository.CrudRepository;

import edu.cscc.MusiciansCompanion.Models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}
