$(document).ready(function(){

$surface = $('.surface');
$car = $('.car');
$img = $('.car img');
let flag = true;

const cars = ['resources/slike/autoSvetlo.png','resources/slike/autoBezSvetla.png'];

$(document).on('keypress',function(e){

	if (e.which == 13) {
		$($surface).toggleClass('moveRight');
		$($car).toggleClass('suspension');
	}
})

$(document).on('keypress',function(e){

	if (e.which == 70) {
		if (flag) {
			flag = false;
			$img.attr('src',cars[0]);
		}else{
			flag =true;
			$img.attr('src',cars[1]);
		}
	}

})
});