function validate(form, options) {
	for (key in options) {
		if (options[key] instanceof Array) {
			for (var i = 0; i<options[key].length; i+=2) {
				if (!options[key][i](form.elements[key])) {
					alert (options[key][i + 1]);
					return false;
				}
			}
		} else {
			for (internalKey in options[key]) {
				var newKey = key + '.' + internalKey;
				for (var i = 0; i<options[key][internalKey].length; i+=2) {
					if (!options[key][internalKey][i](form.elements[newKey])) {
						alert (options[key][internalKey][i + 1]);
						return false;
					}
				}
			}
		}
	}
	
	return true;
}

function validate_category(form) {
	var validCategory = {
		name: [
			function(obj) {
				var text = obj.value;
				if (text == null || text == undefined || text === '') {
					return false;
				} else {
					return true;
				}
			}, 'Please enter a name.',
			function(obj) {
				var text = obj.value;
				var Reg61 = new RegExp("^[A-Z]{1}[a-z]{1,19}$");
				if (!Reg61.test(text)) {
					return false;
				} else {
					return true;
					}
			}, 'The name can contain only English characters. The first character of the title.'
		]
	}
	
	return validate(form, validCategory);
}

function validate_client(form) {
	var validClient = {
		firstName: [
			function(obj) {
				var text = obj.value;
				if (text == null || text == undefined || text === '') {
					return false;
				} else {
					return true;
				}
			}, 'Please enter a first name.',
			function(obj) {
				var text = obj.value;
				var Reg61 = new RegExp("^[A-Z]{1}[a-z]{1,19}$");
				if (!Reg61.test(text)) {
					return false;
				} else {
					return true;
				}
			}, 'The first name can contain only English characters. The first character of the title.'
		],
		lastName: [
			function(obj) {
				var text = obj.value;
				if (text == null || text == undefined || text === '') {
					return false;
				} else {
					return true;
				}
			}, 'Please enter a last name.',
			function(obj) {
				var text = obj.value;
				var Reg61 = new RegExp("^[A-Z]{1}[a-z]{1,19}$");
				if (!Reg61.test(text)) {
					return false;
				} else {
					return true;
				}
			}, 'The last name can contain only English characters. The first character of the title.'
		],
		phoneNumber: [
		    function(obj) {
		    	var text = obj.value;
			    if (text == null || text == undefined || text === '') {
			    	return false;
			    } else {
			    	return true;
			    }
			}, 'Please enter a phone number.',
			function(obj) {
				var text = obj.value;
			    var Reg61 = new RegExp("^[0]{1}[1-9]{9}$");
			    if (!Reg61.test(text)) {
			    	return false;
			    } else {
			   		return true;
			   	}
			}, 'Entered an incorrect phone number.'
		],
		user: validUser
	}
	
	return validate(form, validClient);
}

function validate_admin(form) {
	var validAdmin = {
		firstName: [
		    function(obj) {
			    var text = obj.value;
			    if (text == null || text == undefined || text === '') {
			    	return false;
			    } else {
			    	return true;
			    }
		}, 'Please enter a first name.',
			function(obj) {
				var text = obj.value;
			    var Reg61 = new RegExp("^[A-Z]{1}[a-z]{1,19}$");
			    if (!Reg61.test(text)) {
			    	return false;
			    } else {
		    	return true;
			    }
			}, 'The first name can contain only English characters. The first character of the title.'
		],
		lastName: [
		    function(obj) {
		    	var text = obj.value;
		    	if (text == null || text == undefined || text === '') {
		    		return false;
		    	} else {
		    		return true;
		    	}
			}, 'Please enter a last name.',
			function(obj) {
				var text = obj.value;
			    var Reg61 = new RegExp("^[A-Z]{1}[a-z]{1,19}$");
			    if (!Reg61.test(text)) {
			    	return false;
			    } else {
			    	return true;
			    }
			}, 'The last name can contain only English characters. The first character of the title.'
		],
		middleName: [
		    function(obj) {
		    	var text = obj.value;
		    	if (text == null || text == undefined || text === '') {
		    		return false;
		    	} else {
		    		return true;
		    	}
		    }, 'Please enter a middle name.',
		   	function(obj) {
		   		var text = obj.value;
		   		var Reg61 = new RegExp("^[A-Z]{1}[a-z]{1,19}$");
		   		if (!Reg61.test(text)) {
		   			return false;
		   		} else {
		   			return true;
		   		}
		    }, 'The middle name can contain only English characters. The first character of the title.'
		],
		user: validUser
	}
	
	return validate(form, validAdmin);
}

var validUser = {
	nickname: [
		function(obj) {
			var text = obj.value;
			if (text == null || text == undefined || text === '') {
				return false;
			} else {
				return true;
			}
		}, 'Please enter a nickname.',
		function(obj) {
			var text = obj.value;
			var Reg61 = new RegExp("^[a-zA-Z][a-zA-Z0-9-_\.]{7,20}$");
			if (!Reg61.test(text)) {
				return false;
			} else {
				return true;
			}
		}, 'Nickname must be at least seven English letters or Arabic numbers.'
	],
	password: [
		function(obj) {
			var text = obj.value;
			if (text == null || text == undefined || text === '') {
				return false;
			} else {
				return true;
			}
		}, 'Please enter a password.',
		function(obj) {
			var text = obj.value;
			var Reg61 = new RegExp("(?=^.{8,20}$)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$");
			if (!Reg61.test(text)) {
				return false;
			} else {
				return true;
			}
		}, 'Password should consist of eight letters, and contain at least one number and one capital letter.'
	]
}

