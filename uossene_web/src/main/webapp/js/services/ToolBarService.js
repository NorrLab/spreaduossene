app.factory("ToolBarService", function($http,$translate) {
	return {
		changeLanguage: function(locale) {
			var language;
			if(locale === "FR"){
				language="fr_FR.json";
			}else{
				language="en_EN.json";
			} 
			$translate.use(locale);
			
			return $translate.use(locale);// $http.get('./languages/'+language);
		}
	}
})