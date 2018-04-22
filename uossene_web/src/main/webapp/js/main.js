var app = angular.module("uosApp", ["jkAngularCarousel","pascalprecht.translate","ngRoute","ui-notification","ngMaterial","ngAnimate","services","ui.tree","LocalStorageModule"],["SERVICES","COMPONENTS","DEMOS","PAGES","$routeProvider","$locationProvider","$mdThemingProvider","$mdIconProvider", function(e,t,a,n,o,l,i,s) {
	
}]);
app.config(['$routeProvider', function($routeProvider) {
	
	$routeProvider.when('/home', {
		templateUrl:'partials/home.html',
		controller: 'UosCtrl'
	});// <version>3.6.1</version>
	$routeProvider.when('/myCv', {
		templateUrl:'partials/my_cv.html',
		controller: 'UosCtrl'
	});
	$routeProvider.when('/competences',{
		templateUrl:'partials/competences.html',
		controller:'UosCtrl'
	});
	$routeProvider.when('/about', {
		templateUrl: 'partials/about.html',
		controller: 'UosCrtl'
	});
	$routeProvider.when('/:userId/videos', {
		templateUrl: 'partials/user/videos.html',
        controller: 'UosCtrl'
    });
	$routeProvider.when('/missionDetail/:missionId', {
		templateUrl: 'partials/missionDetail.html',
        controller: 'MissionCtrl'
    });
	$routeProvider.otherwise({
        redirectTo: '/home',
        controller: 'UosCtrl'
    });
    
    $routeProvider.otherwise({
        redirectTo: '/test',
        templateUrl:'partials/test-carousel.html',
        controller: 'UosCtrl'
    });
	
	
	
}])

app.config(["messageProvider", function(messageProvider) {
	messageProvider.setText('hello millionnaire TX')
}])

app.config(['$translateProvider', function ($translateProvider) {
    $translateProvider.preferredLanguage('en_EN');
    $translateProvider.determinePreferredLanguage();
    $translateProvider.fallbackLanguage('en_EN');
    $translateProvider.useSanitizeValueStrategy('escapeParameters');
    $translateProvider.useStaticFilesLoader({
    	prefix: './languages/',
        suffix: '.json'
    });
}])

angular.module("uosApp").constant("DEMOS",[{
	
}])
angular.module("uosApp").constant("PAGES",[{
	
}])
angular.module("uosApp").constant("COMPONENTS",[{
	name: "material.components.autocomplete",
	type: "module",
	outputPath: "partials/api/material.components.autocomplete/index.html",
	url: "api/material.components.autocomplete",
	label: "material.components.autocomplete",
	module: "material.components",
	githubUrl: "https://github.com/angular/material/blob/master/src/components/autocomplete/autocomplete.js",
	docs:[{
		name: "mdAutocomplete",
		type: "directive",
		restrict: {
			element: !0,
			attribute: !0,
			cssCalss: !1,
			comment: !1
		},
		outputPath:	"",
		url: "",
		label: "",
		module: "",
		githubUrl:	"",
		hasDemo: !0
	},{
		
	}],
	hasDemo: !1
}])
angular.module("uosApp").constant("SERVICES",[{
	name: "$mdMedia",
	type: "services",
	outputPath: "partials/api/material.core/service/$mdMedia.html",
	url: "api/service/$mdMedia",
	label:"$mdMedia",
	module: "material.core",
	githubUrl: "https://github.com/angular/material/blob/master/src/core/util/media.js",
	hasDemo: !1
}])