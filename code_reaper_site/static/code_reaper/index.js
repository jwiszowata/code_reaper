$(document).ready(function () {
	var done = $('#fun').data('done');
	var done10 = done % 10;
	var done100 = done % 100;
	var done1000 = done % 1000;
	if (done1000 == 0 && done100 == 0 && done10 == 1) {
		$('#fun').text("funkcja");
	} else if (done100 != 1 && (done10 == 2 || done10 == 3 || done10 == 4)) {
		$('#fun').text("funkcje");
	} else {
		$('#fun').text("funkcji");
	}
});