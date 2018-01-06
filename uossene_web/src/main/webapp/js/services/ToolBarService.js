app.factory("ToolBarService", function($http,$translate,UserService,localStorageService) {
	var language;
	
	return {
		getLocalKey: function(locale) {
			var data = {};
			if(locale=="FR"){
				data.language="fr_FR"
				data.locale="FR";
				
			}else{
				data.language="en_EN"
				data.locale="EN"; 
			}
			return data;
		},
		changeLanguage: function(locale) {
			
			if(locale=="FR" && locale === localStorageService.get('locale')){
				
				language="en_EN"; 
				locale="EN"; 
				localStorageService.set('locale',locale);
			}else{
				locale="FR";
				language="fr_FR";
				localStorageService.set('locale',locale);
			}
			
			$translate.use(language).then( function(response) {
					
			}, function(error) {
				
			});
			
			return locale;
		},
		getUserLocale : function() {
			var currentLocale;
			
			if(UserService.isLogIn()){
				currentLocale = localStorageService.get('locale');
			}else{
				currentLocale = localStorageService.get('locale');

				if(currentLocale == null){
					currentLocale="FR";
					
					localStorageService.set('locale',currentLocale);
				}
			}
			
			var language=this.getLocalKey(currentLocale).language;
			
			
			$translate.use(language).then( function(response) {
				
			}, function(error) {
				
			});
			currentLocale=this.getLocalKey(currentLocale).locale;
			return currentLocale;
		}
		
	}
})