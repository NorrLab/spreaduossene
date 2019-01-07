
var $originalWidth = $(window).width();

$( document ).ready(function() {
	 
	function goToTns() {
			window.location.href='http://www.technologyandstrategy.com/';
		};
		
	
	$(window).resize( function() {
		var $winWidth =$(window).width();
		if(74>($winWidth/$originalWidth)*100){
			$('#inner_nav_links').hide();
			$('#inner_nav_').hide();
		}else{
			$('#inner_nav_links').show();
			$('#inner_nav_').show();
		}
	});
	
	$('.list_tns').click( function() {
		window.location.href='http://www.technologyandstrategy.com/';
	})
	
	
	
});