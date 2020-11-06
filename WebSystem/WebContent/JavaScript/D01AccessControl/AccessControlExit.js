/**
 *
 */

window.addEventListener('load', function() {

	var checkbox = document.querySelectorAll('input[type="checkbox"]');
	var button = document.querySelector('input[type="submit"]');
	checkbox.forEach(function(check) {
		check.onchange = checkValue;
	})

	function checkValue(event) {
		var checked = document
				.querySelectorAll('input[type="checkbox"]:checked');
		if (checkbox.length === checked.length) {
			button.disabled = false;
		} else {
			button.disabled = true;
		}
	}
})