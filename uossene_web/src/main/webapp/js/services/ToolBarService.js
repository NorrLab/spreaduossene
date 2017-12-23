app.factory("ToolBarService", function($http,$translate,UserService,localStorageService) {
	var language;
	
	return {
		
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
				
			}else{
				currentLocale = localStorageService.get('locale');

				if(currentLocale == null){
					currentLocale="FR";
					localStorageService.set('locale',currentLocale);
				}else{
					this.changeLanguage(currentLocale);
				}
			}
			return currentLocale;
		}
	}
})