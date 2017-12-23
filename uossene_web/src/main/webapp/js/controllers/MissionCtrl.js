app.controller("MissionCtrl",["$scope","$location","$timeout","$mdDialog","$translate", function($scope,message,$location,$timeout,
		$mdDialog,$translate) {
	
	$scope.getPhoneNumber = function($scope,$timeout) {

		var myEl = angular.element( document.querySelector( '#my_phone_class' ) );

		if(myEl.hasClass('layout-align-center-stretch')){
			 myEl.removeClass('layout-align-center-stretch');
		}else{
			 myEl.addClass('layout-align-center-stretch');
		}
	}
	
}])