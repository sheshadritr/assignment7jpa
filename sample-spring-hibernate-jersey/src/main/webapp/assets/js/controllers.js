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
            //console.log($scope.tags);
            
            $scope.tagsmap.dataTable.addColumn("string","TagName");
            $scope.tagsmap.dataTable.addColumn("number","TagCount");
            for (var i=0; i<$scope.tags.length; i++) {
            	if($scope.tags[i].tagAssociated != "angularjs" && $scope.tags[i].tagCount >= 10)
            		$scope.tagsmap.dataTable.addRow([$scope.tags[i].tagAssociated, $scope.tags[i].tagCount]);
            }
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
	
	myApp.controller('QuestionController', ['$scope', 'viewService', 'answerService', 'questionService',
	    function($scope, viewService, answerService, questionService) {
		
		/*
		 * This part of controller provides data of Views vs Questions
		 * */
		$scope.view = {};
		$scope.viewmap = {};
		$scope.viewmap.dataTable = new google.visualization.DataTable();
		loadViewData();

		// I apply the remote data to the local scope.
		function applyViewData(newview) {
			$scope.view = newview.data;
			
			$scope.viewmap.dataTable.addColumn("string", "Field");
			$scope.viewmap.dataTable.addColumn("number", "TotalCount");			
			$scope.viewmap.dataTable.addRows([[ "Total Questions", $scope.view.totalQuestions],
											  [ "Total Views", $scope.view.totalViews]
			                                  ]);
			$scope.viewmap.title = "Total Views Barchart";
			
		}

		// I load the remote data from the server.
		function loadViewData() {
			viewService.getViews().then(function(view) {
				applyViewData(view);
			});
		}
		
		/*
		 * This part of controller provides data of Answers vs Questions
		 * */
		$scope.answer = {};
		$scope.answermap = {};
		$scope.answermap.dataTable = new google.visualization.DataTable();
		loadAnswerData();

		// I apply the remote data to the local scope.
		function applyAnswerData(newanswer) {
			$scope.answer = newanswer.data;
			
			$scope.answermap.dataTable.addColumn("string", "Field");
			$scope.answermap.dataTable.addColumn("number", "TotalCount");			
			$scope.answermap.dataTable.addRows([[ "Total Questions", $scope.answer.totalQuestions],
											  [ "Total Answers", $scope.answer.totalAnswers]
			                                  ]);
			$scope.answermap.title = "Total Answers Barchart";
			
		}

		// I load the remote data from the server.
		function loadAnswerData() {
			answerService.getAnswers().then(function(answer) {
				applyAnswerData(answer);
			});
		}
		
		/*
		 * This part of controller provides data of total no.of Questions over time
		 * */
		$scope.question = {};
		$scope.questionmap = {};
		$scope.questionmap.dataTable = new google.visualization.DataTable();
		loadQuestionData();

		// I apply the remote data to the local scope.
		function applyQuestionData(newquestion) {
			$scope.question = newquestion.data;
			
			$scope.questionmap.dataTable.addColumn("string", "CreatedYear");
			$scope.questionmap.dataTable.addColumn("number", "NoOfQuestions");			
            for (var i=0; i<$scope.question.length; i++)
            {
            	//console.log($scope.question[i].createdDate, $scope.question[i].questionCount);
            	$scope.questionmap.dataTable.addRow([$scope.question[i].createdDate, $scope.question[i].questionCount]);
            }
			$scope.questionmap.title = "No.of Questions over-time";
			
		}

		// I load the remote data from the server.
		function loadQuestionData() {
			questionService.getQuestions().then(function(question) {
				applyQuestionData(question);
			});
		}
	}]);