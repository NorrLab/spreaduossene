
app.controller("MissionCtrl",["$scope","message","$location","$timeout","$mdDialog","UserService","ToolBarService","$translate","$http","MissionService", function($scope,message,$location,$timeout,$mdDialog,UserService,ToolBarService,$translate,$http,MissionService) {

//app.controller("MissionCtrl",["$scope","$location","$timeout","MissionService", "$mdDialog","$translate", function($scope,message,$location,$timeout,
//		MissionService, $mdDialog,$translate) {
	$scope.getPhoneNumber = function($scope,$timeout) {

		var myEl = angular.element( document.querySelector( '#my_phone_class' ) );

		if(myEl.hasClass('layout-align-center-stretch')){
			 myEl.removeClass('layout-align-center-stretch');
			 
			 setTimeout( function() {

					var myEl = angular.element( document.querySelector( '#techno_icon_li2' ) );
					myEl.removeAttr('hidden');
				},0);
			 
		}else{
			 myEl.addClass('layout-align-center-stretch');
			 
			 setTimeout( function() {
					var myEl = angular.element( document.querySelector( '#techno_icon_li2' ) );
					myEl.attr('hidden',"yes");
				},0);
			 
		}
	}
//	console.log(MissionService)
}])