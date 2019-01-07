app.factory("MissionService", function($scope, $http) {
	
	var arrayString = ["I am ","riche"]
	
	return {
		getAllMissions: function() {
			var allMissions;
			
			$http.post("/saerch-mission",arrayString).success( function(response) {
				allMissions = response;
			}).error( function() {
				alert('error')
			})
		}
	}
})