app.factory("UserService", function($location,$http) {
	return{
			isLogIn: function() {
				return false;
			},
			login: function(userEmail,userPassword) {
				var user;
				
				var payLoad={
						email: userEmail,//"uso@uos.com",
						password:userPassword//"12345"
				};
				user = localStorageService.get("userLogin");
				if(user!= undefined){
					return  $http.post("UserServlet/Login",payLoad);
				}
				 
			},
			userRegistered : function(user) {
				if(user.password === user.passwordConfirm){
					return true;
				}else{
					return false;
				}
			}
	}
})