/**
 *
 */

window.addEventListener('load', function(){

let checkbox = document.querySelectorAll('input[type="checkbox"]');
let button = document.querySelector('input[type="submit"]');
checkbox.forEach(function(check) {
	check.onchange = checkValue;
})

function checkValue(event) {
	let checked = document.querySelectorAll('input[type="checkbox"]:checked');
	if (checkbox.length === checked.length) {
		button.disabled = false;
	} else {
		button.disabled = true;
	}
}
})