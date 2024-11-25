class Metronome {

    constructor(tempo = 120, beatsPerBar = 4) {
        this.audioContext = null;

        this.notesInQueue = [];

        this.currentBeatInBar = 0;
        this.beatsPerBar = beatsPerBar;
        this.emphasizedBeats = this.getEmphasizedBeats();
        this.tempo = tempo;

        this.lookAhead = 25;
        this.scheduleAheadTime = 0.1;
        this.nextNoteTime = 0.0;

        this.isRunning = false;

        this.intervalID = null;
    }
    
    getEmphasizedBeats() {
		var emphasizedBeats = [];
		var emphasisCheckboxes = document.querySelectorAll('#emphasis-container input[type="checkbox"]');
		
		emphasisCheckboxes.forEach(function(checkbox) {
			if(checkbox.checked) {
				emphasizedBeats.push(parseInt(checkbox.dataset.beat));
			}
		});
		
		return emphasizedBeats;
	}

    nextNote() {
        var secondsPerBeat = 60.0 / this.tempo;
        this.nextNoteTime += secondsPerBeat;

        this.currentBeatInBar++;
        if(this.currentBeatInBar == this.beatsPerBar) {
            this.currentBeatInBar = 0;
        }
    }

    scheduleNote(beatNumber, time) {
        this.notesInQueue.push({note: beatNumber, time: time});

        const osc = this.audioContext.createOscillator();
        const envelope = this.audioContext.createGain();

		this.emphasizedBeats = this.getEmphasizedBeats();
        osc.frequency.value = (this.emphasizedBeats.includes(beatNumber)) ? 1000 : 800;
        envelope.gain.value = 1;
        envelope.gain.exponentialRampToValueAtTime(1, time + 0.001);
        envelope.gain.exponentialRampToValueAtTime(0.001, time + 0.02);

        osc.connect(envelope);
        envelope.connect(this.audioContext.destination);

        osc.start(time);
        osc.stop(time + 0.03);
    }

    scheduler() {
        while (this.nextNoteTime < this.audioContext.currentTime + this.scheduleAheadTime) {
            this.scheduleNote(this.currentBeatInBar, this.nextNoteTime);
            this.nextNote();
        }
    }

    start() {
        if (this.isRunning) return;

        if (this.audioContext == null) {
            this.audioContext = new (window.AudioContext || window.AudioContext) ();
        }

        this.isRunning = true;

        this.currentBeatInBar = 0;
        this.nextNoteTime = this.audioContext.currentTime + 0.05;

        this.intervalID = setInterval(() => this.scheduler(), this.lookAhead);
    }

    stop() {
        this.isRunning = false;

        clearInterval(this.intervalID);
    }

    startStop() {
        if (this.isRunning) {
            this.stop();
        }
        else {
            this.start();
        }
    }

}