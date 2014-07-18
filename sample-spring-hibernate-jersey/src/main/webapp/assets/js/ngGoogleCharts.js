"use strict";

var googleChart = googleChart || angular.module("google-chart",[]);

googleChart.directive("googleChart",function(){  
    return{
        restrict : "A",
        link: function($scope, $elem, $attr){
            var dt = $scope[$attr.ngModel].dataTable;

            var options = {};
            if($scope[$attr.ngModel].title)
                options.title = $scope[$attr.ngModel].title;

            var googleChart = new google.visualization[$attr.googleChart]($elem[0]);
            googleChart.draw(dt,options);
            
            // there was a problem in binding the objects, so this code was written, but it has performance issues
			$scope.$watch(function() {
				return $scope[$attr.ngModel].dataTable;
			}, function(newValue) {
				googleChart.draw($scope[$attr.ngModel].dataTable, options);
			}, true);

        }
    };
});