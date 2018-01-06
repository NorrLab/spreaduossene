app.factory("UserService", function($mdDialog,$location,$http,localStorageService) {
	this.userMedias;
	return{
		
			isLogIn: function(user) {
				var currentUser = localStorageService.get("currentUser");
				if(currentUser === null){
					return false;
				}
				return true;
			},
			login: function(currentUser) {
				var user = currentUser;
				
				if(user!= undefined){
					return  $http.post("http://localhost:8080/uossene_service/user/login",user);
				}
				 
			},
			userRegistered : function(user) {
				if(user.password === user.passwordConfirm){
					return true;
				}else{
					return false;
				}
			},
			getUserWithComment : function() {
				return $http.get("http://localhost:8080/uossene_service/user/users/comments/");
			},
			createComment: function(user) {
				if(this.isLogIn(user)){
					this.callMdDialog();
					return null;
				}else{
					return this.login(user);
				}
			},
			accessMedia: function(user) {
					if(this.isLogin(user)){
						return $http.post("",user).then( function(response) {
							this.userSetMedias(response.data);
						});
					}else{
						var user
						return $http.post("",user).then( function(response) {
							this.userSetMedias(response.data);
						});
					}
			},
			userSetMedias: function(mediaList) {
				this.userMedias = mediaList;
			},
			callMdDialog: function() {
				$mdDialog.show({
//    	            controller: UosCtrl,
    	            templateUrl: 'partials/user/user_comment.html',
    	            parent: angular.element(document.body),
    	            clickOutsideToClose: true,
    	            locals:{
//    	            	logInForComment : logInForComment
    	    		}
    	        }).then(function () {
    	            }
    	        );
			},
			validateComment: function(message) {
				var user =localStorageService.get("currentUser");
				alert(user.commentId)
				var comment = {
						commentId:0,
						dateComment: '',
						userComment:message
				}
					user.userComment = comment;	
				
				
		        return $http({
		        	'url' : 'http://localhost:8080/uossene_service/user/comment/'+user.userId,
			        'method' : 'POST',
			        'headers': {'Content-Type' : 'application/json'},
			        'data' : message
		        });
		        
			}
	}
})