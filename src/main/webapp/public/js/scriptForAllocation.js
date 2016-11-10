function backlight() {
	var elem = this.parentNode;
	if (elem.style.background == 'blue') {
		elem.style.background = '';
	} else {
		elem.style.background = 'blue';
	}
}

function alocation(table) {
	var lines = table.getElementsByTagName('td');
	for (var i = 0; i < lines.length; ++i) {
		lines[i].onclick = backlight;
	}
}