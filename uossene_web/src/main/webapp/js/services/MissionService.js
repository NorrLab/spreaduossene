
app.factory("MissionService", function($http, $q) {
	
	var methodeGet = "GET";
	var methodePos = "POST";
	var methodePut = "PUT";
	var methodeDel = "DELETE";
	var methodeOpt = "OPTION";
	
	return{
		
		getAllMissions: function() {
			var url = 'http://localhost:8080/uossene_service/mission/all/';
			var deferred = this.executeRequest(url,methodeGet,null);
			return deferred;
		},
		createMission: function(mission) {
			var url = 'http://localhost:8080/uossene_service/create/';
			var deferred = this.executeRequest(url,methodePos,mission); 
		},
		updateMission: function(mission) {
			var url = 'http://localhost:8080/uossene_service/update/';
			var deferred = this.executeRequest(url,methodeGet,mission); 
		},
		deleteMission: function(missionId) {
			var url = 'http://localhost:8080/uossene_service/delete/'+missionId;
			var deferred = this.executeRequest(url,methodeGet,null); 
		},
		getMissionsByTechnologyKeyWord: function(keyWordArray) {
			var url = 'http://localhost:8080/uossene_service/saerch-mission/'+keyWordArray;
			var deferred = this.executeRequest(url,methodeGet,null);
			return deferred;
		},
		getMissionById: function(missionId) {
			var url = 'http://localhost:8080/uossene_service/mission/'+missionId;
			var deferred = this.executeRequest(url,methodeGet,null);
			return deferred;
		},
		executeRequest: function(url, methodeGet, payLoad) {
			
			var deferred = $q.defer();
			
			switch (methodeGet) {
			case "GET":
				$http.get(url).success( function(data, status) {
					deferred.resolve(data);
				}).error( function(data, status){
					deferred.resolve(data);
				});
				break;
			case "POST":
				$http.post(url, payLoad).success( function(data, status) {
					deferred.resolve(data);
				}).error( function(data, status){
					deferred.resolve(data);
				});
				break;
			case "PUT":
				$http.put(url, payLoad).success( function(data, status) {
					deferred.resolve(data);
				}).error( function(data, status){
					deferred.resolve(data);
				});
				break;
			case "DELETE":
				$http.get(url).success( function(data, status) {
					deferred.resolve(data);
				}).error( function(data, status){
					deferred.resolve(data);
				});
				break;
			case "OPTION":
				$http.get(url).success( function(data, status) {
					deferred.resolve(data);
				}).error( function(data, status){
					deferred.resolve(data);
				});
				break;

			default:
				break;
			}
			
			return deferred.promise;
		}
	}
})