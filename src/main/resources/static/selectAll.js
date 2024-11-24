var buttons = document.getElementsByClassName('SelectAll');

for(var i = 0; i < buttons.length; i++) {

	buttons[i].addEventListener('click', function() {
		if(this.dataset.state === "Off") {
			this.textContent = "Deselect All";
			this.dataset.state = "On";
			selectAll(this.dataset.targetClass);
		} else {
			this.textContent = "Select All";
			this.dataset.state = "Off";
			deselectAll(this.dataset.targetClass);
		}
	});
}


function selectAll(target) {
	var targets = document.getElementsByClassName(target);
	
	for(var i = 0; i < targets.length; i++) {
		targets[i].checked = true;
	}
}


function deselectAll(target) {
	var targets = document.getElementsByClassName(target);
	
	for(var i = 0; i < targets.length; i++) {
		targets[i].checked = false;
	}
}
