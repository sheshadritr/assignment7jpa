var myApp =angular.module('myApp', [ 
  'myApp.services',
  'myApp.controllers',
  'google-chart'
]);

myApp.config(['$routeProvider',
                   function($routeProvider) {
                     $routeProvider.
                     when('/tagchart', {
                         templateUrl: 'assets/partials/tagchart.html',
                         controller: 'TagController'
                       }).
                       when('/questionchart', {
                           templateUrl: 'assets/partials/questionchart.html',
                           controller: 'QuestionController'
                         }).
                       otherwise({
                         redirectTo: '/tagchart'
                       });
                   }]);

