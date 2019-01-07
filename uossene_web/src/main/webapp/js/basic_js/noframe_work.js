/**
 * 
 */

	var $inner__nav = $('.inner__nav');
	var $btn__scroll = $('.btn-scroll');
	var $btn_scroll_top = $('.md-fab-bottom-right');
	var $footer = $('.main_footer');
	var $waypoint = new Waypoint({
		element: $inner__nav[0],
		handler: function(dir) {
			
			var $large__nav = $('.large__nav')
			if('down' === dir){
				$large__nav.removeClass('hide');
				$btn_scroll_top.addClass('scrolling');
				
				$footer.removeClass('hide_footer')
			}
			else{
				$large__nav.addClass('hide');
				$btn_scroll_top.removeClass('scrolling');
				$footer.addClass('hide_footer')
			}
		},
		offset: function() {
			 return -($(this.element).height())
		}
	})
  
