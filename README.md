# Musicians Companion
## Description
Capstone Project for Associates of Applied Science at Columbus State Community College. This app contains what I could finish in a single semester and nothing more. Also, note that this project is old and is not representative of my current abilities!

This is a Musician's Utility App. It contains features like a random musical challenge generator, a random chord & inversion generator, a metronome w/customizable beats per bar and beat emphasis, and a feature that accepts a guitar tuning and a chord and shows every way you could play a chord with those notes across the fretboard of a guitar.

## Technologies/Workflows Used
- Spring Boot
- MVC Architecture
- HTML/CSS/JS
- Thymeleaf
- H2 Database
- Lomboc
- Maven
- Kanban Board w/cards and prioritized features

## Note: Main App endpoint is at http://localhost:8080/MusiciansCompanion

## TODO: 
- Add form validation
- Make ChallengeSettings pass to the client so the challenge page can reload and generate another challenge rather than creating an error

Low priority
- Create a login and a way to save user preferences. 
- Create a way (incorporating metronome functionality) to follow a chord progression as it plays. E.G 4 bars of Amaj, 2 bars of Dmaj. Show the current chord, how long it's played, and what's coming up. Possibly use this format: Amaj | Amaj | Amaj | Amaj | Dmaj | Dmaj
- Add Chord Diagrams on Chord Voicing Page
