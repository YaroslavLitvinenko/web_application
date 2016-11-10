document.getElementById('name').onblur = outFocus;
document.getElementById('name').onfocus = onFocus;
			
document.body.onmouseover = document.body.onmouseout = handler;


function onFocus() {
	infname.innerHTML = "Name of category";
}

function outFocus() {
	if (document.getElementById('name') == document.activeElement) {				
		
	} else {
		infname.innerHTML = "";
	}
}


function handler(event) {
	if (event.type == 'mouseover') {
		if (event.target.id == 'name') {
			onFocus();
		}
	}
			
	if (event.type == 'mouseout') {
		if (event.target.id == 'name') {
			outFocus();
		}
	}
}