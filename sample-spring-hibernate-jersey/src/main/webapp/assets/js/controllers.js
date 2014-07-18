 "use strict";

/*We need to manually start angular as we need to
wait for the google charting libs to be ready*/  
	google.setOnLoadCallback(function () {  
	    angular.bootstrap(document.body, ['myApp']);
	});
	google.load('visualization', '1', {packages: ['corechart']});
	var myApp = myApp || angular.module("myApp",["google-chart"]);


	myApp = angular.module( "myApp.controllers", [] );
	 // Controls the myApp.
	myApp.controller('TagController', ['$scope', 'tagService', function( $scope, tagService ) {
		$scope.tags = [];
		$scope.tagsmap = {};
        $scope.tagsmap.dataTable = new google.visualization.DataTable();
        loadRemoteData();        

        // I apply the remote data to the local scope.
        function applyRemoteData( newtags ) {
            $scope.tags = newtags.data;
            console.log($scope.tags);
            
            $scope.tagsmap.dataTable.addColumn("string","TagName");
            $scope.tagsmap.dataTable.addColumn("number","TagCount");
            for (var i=0; i<$scope.tags.length; i++)
            	$scope.tagsmap.dataTable.addRow([$scope.tags[i].tagAssociated, $scope.tags[i].tagCount]);
            $scope.tagsmap.title="Associate Tags Pie Chart";

        }

        // I load the remote data from the server.
        function loadRemoteData() {
        	tagService.getTags().then(
                    function( tags ) {
                        applyRemoteData( tags );
                    });
        }
	}]);
	
	myApp.controller('QuestionController', ['$scope', 'viewService', function($scope, viewService) {

		$scope.view = {};
		$scope.viewmap = {};
		$scope.viewmap.dataTable = new google.visualization.DataTable();
		loadRemoteData();

		// I apply the remote data to the local scope.
		function applyRemoteData(newview) {
			$scope.view = newview.data;
			
			$scope.viewmap.dataTable.addColumn("string", "Field");
			$scope.viewmap.dataTable.addColumn("number", "TotalCount");			
			$scope.viewmap.dataTable.addRows([[ "Total Questions", $scope.view.totalQuestions],
											  [ "Total Views", $scope.view.totalViews]
			                                  ]);
			$scope.viewmap.title = "Total Views Barchart";
			//console.log($scope.viewmap);
			
		}

		// I load the remote data from the server.
		function loadRemoteData() {
			viewService.getViews().then(function(view) {
				applyRemoteData(view);
			});
		}
	}]);
	
	myApp.controller('QuestionController', ['$scope', 'answerService', function($scope, answerService) {

		$scope.answer = {};
		$scope.answermap = {};
		$scope.answermap.dataTable = new google.visualization.DataTable();
		loadRemoteData();

		// I apply the remote data to the local scope.
		function applyRemoteData(newanswer) {
			$scope.answer = newanswer.data;
			
			$scope.answermap.dataTable.addColumn("string", "Field");
			$scope.answermap.dataTable.addColumn("number", "TotalCount");			
			$scope.answermap.dataTable.addRows([[ "Total Questions", $scope.answer.totalQuestions],
											  [ "Total Answers", $scope.answer.totalAnswers]
			                                  ]);
			$scope.answermap.title = "Total Answers Barchart";
			//console.log($scope.answermap);
			
		}

		// I load the remote data from the server.
		function loadRemoteData() {
			answerService.getAnswers().then(function(answer) {
				applyRemoteData(answer);
			});
		}
	}]);