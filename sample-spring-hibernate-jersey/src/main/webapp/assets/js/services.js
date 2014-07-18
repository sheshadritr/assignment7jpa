var module = angular.module('myApp.services',[]);

module.service( 'tagService', ['$http', function( $http, $t ) {
	// Return public API.
	return ({
		getTags : getTags,
	});

	function getTags() {
		var request = $http({
			method : "get",
			url : "http://0.0.0.0:8080/api/tags/associated",
			params : {
				action : "get"
			}
		});
		return request;
	}
}]);

module.service( 'viewService', ['$http', function( $http, $t ) {
	// Return public API.
	return ({
		getViews : getViews,
	});

	function getViews() {
		var request = $http({
			method : "get",
			url : "http://0.0.0.0:8080/api/questions/views",
			params : {
				action : "get"
			}
		});
		return request;
	}
}]);

module.service( 'answerService', ['$http', function( $http, $t ) {
	// Return public API.
	return ({
		getAnswers : getAnswers,
	});

	function getAnswers() {
		var request = $http({
			method : "get",
			url : "http://0.0.0.0:8080/api/questions/answers",
			params : {
				action : "get"
			}
		});
		return request;
	}
}]);

module.service( 'questionService', ['$http', function( $http, $t ) {
	// Return public API.
	return ({
		getQuestions : getQuestions,
	});

	function getQuestions() {
		var request = $http({
			method : "get",
			url : "http://0.0.0.0:8080/api/questions/count",
			params : {
				action : "get"
			}
		});
		return request;
	}
}]);