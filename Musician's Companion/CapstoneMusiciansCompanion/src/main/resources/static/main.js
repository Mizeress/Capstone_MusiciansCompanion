var metronome = new Metronome();
var tempo = document.getElementById('tempo-slider');
tempo.value = metronome.tempo;

var tempoDisplay = document.getElementById("tempo-display");
tempoDisplay.innerText = tempo.value + " BPM";

var playButton = document.getElementById("start-stop");
playButton.addEventListener("click", function() {
    metronome.startStop();
});

tempo.addEventListener("input", function() {
    metronome.tempo = parseInt(tempo.value);
    tempoDisplay.innerText = tempo.value + " BPM";
});

var tempoChangeButtons = document.getElementsByClassName("tempo-change");
for (var i = 0; i < tempoChangeButtons.length; i++) {
    tempoChangeButtons[i].addEventListener("click", function() {
        var changeAmount = parseInt(this.dataset.change);
        metronome.tempo += changeAmount;

        metronome.tempo = Math.max(30, Math.min(300, metronome.tempo));

        tempo.value = metronome.tempo;
        tempoDisplay.innerText = metronome.tempo + " BPM";
    });
}


