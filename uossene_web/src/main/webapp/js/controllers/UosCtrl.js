app.controller("UosCtrl",["$scope","message","$location","$timeout","$mdDialog","UserService","ToolBarService","$translate","$http",
	"MissionService",
	function($scope,message,$location,$timeout,$mdDialog,UserService,ToolBarService,$translate,$http,MissionService) {
	var $menuIsClicked = false;
	var $outMenuIsClicked = true;
	
	var $UserLocation;
	$scope.language = ToolBarService.getUserLocale();//"FR";
	navigator.geolocation.getCurrentPosition( function(position){
		$UserLocation = position;
	});
	var $myImg = $('.main__md__img');
	/**
	 * 
	 */
	var $mssTest = $('.missions');
	$mssTest.on('click', function() {
		$mssTest.removeClass('md-active');
		console.log($mssTest.removeClass('md-active'))
	})
	/**
	 * 
	 */
	$('.main__md__img').on("mouseover", function() {
		$myImg.addClass('main__md__img_over'); 
		$myImg.removeClass('main__md__img');
	})
	$('.main__md__img').on("mouseleave", function() {
		$myImg.removeClass('main__md__img_over'); 
		$myImg.addClass('main__md__img'); 
	});
	
	$scope.toTop = function() {
		  $("html, body").animate({
              scrollTop: 0
          }, "slow")
	}
	
	$scope.gotoMyCv = function(seeMyCv) {
		if(seeMyCv)	{
			$mdDialog.show({
	            controller: AboutCtrl,
	            templateUrl: 'partials/pre_about.html',
	            parent: angular.element(document.body),
	            clickOutsideToClose: true
	//            locals: {
	//                device: device,
	//                indexTypes: $scope.indexTypes
	//            }
	        }).then(function () {
	//                $scope.getChartData();
	//        		$location.url('/myCv');
	            }
	        );
			 removeCrossMenu();
		}else{
			$location.url('/myCv');
			$timeout( function() {
//				window.scrollTo(0,0);
				 $("html, body").animate({
		              scrollTop: 0
		          }, "slow");
				 removeCrossMenu();
			},1)
		}
	}
	
	function AboutCtrl($scope,$mdDialog) {
		$scope.validate = function(keepReading) {
			if(keepReading){
				$mdDialog.hide();
//				window.scrollTo(0,0);
				 $("html, body").animate({
		              scrollTop: 0
		          }, "slow")
				$location.url('/about');
			}else{
				$mdDialog.hide();
				$location.url('/myCv');
			} 
		}
		
	}
	/**
	 * redirect to the home page
	 */
	$scope.gotoHome = function() {
		$location.url('/home');
		
		$timeout( function() {
//			window.scrollTo(0,0);
			 $("html, body").animate({
	              scrollTop: 0
	          }, "slow");
			 removeCrossMenu();
		},1)
	}
	/**
	 * 
	 */
	var $home_not_working = $('.home_not_working');
	$home_not_working.on('click', function() {
		$location.url('/home');
		$timeout( function() {
//			window.scrollTo(0,0);
			 $("html, body").animate({
	              scrollTop: 0
	          }, "slow");
			 removeCrossMenu();
		},1)
	})
	/**
	 * 
	 */
	
	var removeCrossMenu = function() {
		 $menuIsClicked = false;
		 
		 $('#nav-toggle').removeClass( "active" );
	}
	
	$scope.toCompetences = function() {
		$location.url('/competences');
		$timeout( function() {
//			window.scrollTo(0,0);
			 $("html, body").animate({
	              scrollTop: 0
	          }, "slow");
			 removeCrossMenu();
		},1);
		
		
		
	}
	/**
	 * scrollTo anchor
	 */
	$scope.scrollTo = function(id) {
		if($location.url()!== '/home'){
			$location.url('/home')
		}
	 $timeout( function() {
			var aTag = $('#'+id);
			$("html, body").animate({
	              scrollTop: aTag.offset().top - 95
			}, "slow");
	 	},1);
	}
	
	$scope.changeLanguage = function() {
		
		$scope.language = ToolBarService.changeLanguage($scope.language);

	}
	
	$scope.competences = [
		  {
			    "id": 1,
			    "title": "COMPETENCES INFORMATIQUES",
			    "nodes": [
			      {
			        "id": 11,
			        "title": "LANGAGES",
			        "nodes": [
			          {
			            "id": 111,
			            "title": "Java",
			            "nodes": []
			          },
			          {
			            "id": 112,
			            "title": "JavaScript",
			            "nodes": []
			          },
			          {
			            "id": 113,
			            "title": "SQL",
			            "nodes": []
			          },
			          {
			            "id": 114,
			            "title": "C++",
			            "nodes": []
			          },
			          {
			            "id": 114,
			            "title": "VHDL",
			            "nodes": []
			          }
			        ]
			      },
			      {
			        "id": 12,
			        "title": "FRAMEWOKS Java/J2EE",
			        "nodes": [
			        	{
			        		"id":121,
			        		"title":"SPRING",
			        		"nodes":[]
				        },
				        {
			        		"id":122,
			        		"title":"HIBERNATE",
			        		"nodes":[]
				        },
				        {
			        		"id":121,
			        		"title":"PLAY",
			        		"nodes":[]
				        },
		        	]
			      },
			      {
			        "id": 13,
			        "title": "Java/J2EE",
			        "nodes": [
			        	{
			        		"id":131,
			        		"title":"JSP",
			        		"nodes":[]
				        },
				        {
			        		"id":132,
			        		"title":"SERVLET",
			        		"nodes":[]
				        },
				        {
			        		"id":133,
			        		"title":"WEBSOCKET",
			        		"nodes":[]
				        } 
		        	]
			      },
			      {
			        "id": 13,
			        "title": "FRAMEWORKS JavaScript",
			        "nodes": [
			        	{
			        		"id":131,
			        		"title":"Angular JS",
			        		"img":"img/abw.jpeg",
			        		"nodes":[]
				        },
				        {
			        		"id":132,
			        		"title":"jQuery",
			        		"nodes":[]
				        },
				        {
			        		"id":133,
			        		"title":"Angular 2",
			        		"nodes":[]
				        } 
		        	]
			      },{
				        "id": 14,
				        "title": "SGBD",
				        "nodes": [
				        	{
				        		"id":141,
				        		"title":"Postgres",
				        		"img":"img/abw.jpeg",
				        		"nodes":[]
					        },
					        {
				        		"id":142,
				        		"title":"MySql",
				        		"nodes":[]
					        },
					        {
				        		"id":143,
				        		"title":"Oracle",
				        		"nodes":[]
					        } 
			        	]
				      }
			      
			    ]
			  },
			  {
			    "id": 2,
			    "title": "MANAGEMENT DE PROJET",
			    "nodrop": true,
			    "nodes": [
			      {
			        "id": 21,
			        "title": "Methode Agile SCRUM",
			        "nodes": []
			      },
			      {
			        "id": 22,
			        "title": "Etablissement de cahier de charges",
			        "nodes": []
			      },
			      {
			        "id": 22,
			        "title": "Etablissement de SFD",
			        "nodes": []
			      },
			      {
			        "id": 22,
			        "title": "Gestion de planning",
			        "nodes": []
			      }
			    ]
			  },
			  {
			    "id": 3,
			    "title": "LANGUES",
			    "nodes": [
			      {
			        "id": 31,
			        "title": "Anglais",
			        "nodes": []
			      },
			      {
			        "id": 32,
			        "title": "Polonais",
			        "nodes": []
			      }
			    ]
			  }
	] 
	
	$scope.contact = function() {
		$mdDialog.show({
            controller: AboutCtrl,
            templateUrl: 'partials/contact.html',
            parent: angular.element(document.body),
            clickOutsideToClose: true
        });
		 removeCrossMenu();
	};
	
	 var $body = $("body");
     $("body").on("click", "[data-scroll]", function(event) {
    	 if($location.url()!="/home")
    		 $location.url('/home');
    	 $timeout( function() {
	    		 var element = $(event.currentTarget)
	             , aid = element.data("scroll")
	             , aTag = $("#" + aid);//
	           $("html, body").animate({
	               scrollTop: aTag.offset().top - 95
	           }, "slow");
	           removeCrossMenu();
	 		},1)
         
     })
	
     $scope.haveAccess = function(logInForComment) {
    	if( UserService.isLogIn()){
    		
    		if (logInForComment){
        		$mdDialog.show({
    	            controller: LoginCtrl,
    	            templateUrl: 'partials/user/user_comment.html',
    	            parent: angular.element(document.body),
    	            clickOutsideToClose: true,
    	            locals:{
    	            	logInForComment : logInForComment
    	    		}
    	        }).then(function () {
    	            }
    	        );
        		removeCrossMenu();
        	}else{
        		
        	} 
    		
    	}else{
    		$mdDialog.show({
	            controller: LoginCtrl,
	            templateUrl: 'partials/user/login.html',
	            parent: angular.element(document.body),
	            clickOutsideToClose: true,
	            locals:{
	            	logInForComment : logInForComment
	    		}
	        }).then(function () {
	            }
	        );
    		removeCrossMenu();
    	}
	};
	
	function LoginCtrl($scope, $mdDialog,logInForComment) {
		$scope.registered;
		$scope.userRegistrate = {
				id:-1,
				firstName:"",
				lastName :"",
				entreprise: "",
				email : "",
				password :"",
				passwordConfirm :""
		}
		console.log($scope)
		$scope.biography="" +
				"ldjkvdvjklhdkvlhfdvkhv" +
				"d;vndvndvnfkvnkfnvk" +
				"dnvfnvkfnvkfnvfnvkfnvknf" +
				"vfnvfknvfkvnfkvnfkvnfknvkfnvf" +
				"";
		$scope.login = function() {
				
				if(!logInForComment && UserService.isLogIn()){
					$mdDialog.hide();
					var $email = $scope.email,
					$password = $scope.password;
					
					var promise = UserService.login($email,$password);
					promise.then( function(res) {
						$location.url('/'+res.data.id+'/videos');
					}, function(err) {
						console.error(err)
					});
				}else if(logInForComment && UserService.isLogIn()){
					$mdDialog.show({
	    	            controller: LoginCtrl,
	    	            templateUrl: 'partials/user/user_comment.html',
	    	            parent: angular.element(document.body),
	    	            clickOutsideToClose: true,
	    	            locals:{
	    	            	logInForComment : logInForComment
	    	    		}
	    	        }).then(function () {
	    	            }
	    	        );
				}else{
					$('#email').css("border-color","red")//addClass("input_error");
					$('#password').css("border-color","red")//.addClass("input_error");
				}
		}
		
		$scope.register = function() {
			$mdDialog.show({
	            controller: LoginCtrl,
	            templateUrl: 'partials/user/register.html',
	            parent: angular.element(document.body),
	            clickOutsideToClose: true,
	            locals:{
	            	logInForComment : logInForComment
	    		}
	        }).then(function () {
	            }
	        );
		};
		
		$scope.validateComment = function() {
			$mdDialog.hide();
		};
		
		$scope.validateRegistration = function() {
			$scope.registered = UserService.userRegistered($scope.userRegistrate); 
		};
		
	}//end LoginCtrl
	
	$scope.goToTnS = function() {
		window.location.href='http://www.technologyandstrategy.com/';
	}
	
	
//	$scope.goToOpen =  function() {
//		window.location.href='https://www.open.global/fr';
//	}
	
	$scope.getDetailMission =  function(missionId) {
		$location.url('missionDetail/'+missionId);
		$("html, body").animate({
            scrollTop: 0
        }, "slow")
	}
	
	$scope.goToAston = function() {
		$location.url('missionDetail/2');
	}
	
	
	$scope.goToUniVal =  function() {
		window.location.href='http://www.univ-valenciennes.fr/';
	}
	
	$scope.goToWroclaw =  function() {
		window.location.href='http://pwr.edu.pl/';
	}
	
//	$scope.goToAbw =  function() {
//		window.location.href='http://www.abusinessware.com/';
//	}
	
	$scope.goToCoe = function() {
		window.location.href='https://www.coe.int/en/web/portal/home';
	}
	
	$scope.writeComment = function(logInForComment) {
		$scope.haveAccess(logInForComment);
	}
	
	var isMobile = {
		    Android: function() {
		        return navigator.userAgent.match(/Android/i);
		    },
		    BlackBerry: function() {
		        return navigator.userAgent.match(/BlackBerry/i);
		    },
		    iOS: function() {
		        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
		    },
		    Opera: function() {
		        return navigator.userAgent.match(/Opera Mini/i);
		    },
		    Windows: function() {
		        return navigator.userAgent.match(/IEMobile/i);
		    },
		    any: function() {
		        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
		    }
		};
	
	$scope.detectDevice = function() {
		if( isMobile.any() ) return true;
	}
	
	
	
	$scope.clickMenu = function() {
		if($menuIsClicked === false)
			$menuIsClicked = true;
		else
			$menuIsClicked = false;	
	}
	
	$scope.menuClicked = function() {
		return $menuIsClicked;
	}
	
	$scope.outMenuClicked = function() {
		return $outMenuIsClicked
	}
	
	$scope.openOuterMenu  = function() {
		if($outMenuIsClicked === false)
			$outMenuIsClicked = true;
		else
			$outMenuIsClicked = false;
	}
	
	$(document).click(function(event) { 
		if( event.target.localName!= "span"){
			$timeout( function() {
				removeCrossMenu();
			},1)
	    }        
	});
	
	var init = function() {
		MissionService.getAllMissions().then( function(response) {
			$scope.missions = response;
		}, function(error) {
			console.error(error)
		});
	}
	
	init();
}])

document.querySelector( "#nav-toggle" )
	  .addEventListener( "click", function() {
	    this.classList.toggle( "active" );
	  });


