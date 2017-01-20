var app = angular.module('postserviceApp', [ 'ngRoute' ]);


app.config(function($routeProvider) {
	$routeProvider

	.when('/', {
		templateUrl : 'login.html',
		controller: 'loginCtrl'
	})
	.when('/home', {
		templateUrl : 'home.html',
		controller: 'homeCtrl'
	})
	
	.when('/recommend', {
		templateUrl : 'recommend.html',
		controller: 'recommCtrl'
	})
	.when('/show', {
		templateUrl : 'show.html',
		controller: 'showRecCtrl'
	})
	
	.otherwise({ redirectTo: '/' });
	
	
});

app.controller('loginCtrl', function($scope){
	$scope.message = "Hello, this is login";
});

app.controller('homeCtrl', function($scope, $http, $location){
	$scope.message = "Hello, this is home";

	    $http.get('/nifty-data').then(
				function(response) {
					if (response.data) {
						$scope.ndata = response.data;
						console.log($scope.ndata);
					} else {
						$scope.msg = "error";
					}
				}, function(response) {
					$scope.msg = "Unsuccessful";
					$scope.statusval = response.status;
					$scope.statustext = response.statusText;
					$scope.headers = response.headers();
				});
});

app.controller('postserviceCtrl', function($scope, $http, $location) {
	$scope.name = null;
	$scope.password = null;
	$scope.lblMsg = null;
	
	$scope.postdata = function(username, password) {
		var data = {
			username : username,
			password : password
		};

		$http.post('/connect', JSON.stringify(data)).then(
				function(response) {
					if (response.data) {
						$scope.msg = "Post Data Submitted Successfully!";
						$location.path('/home')
						
						$scope.name = null;
						$scope.password = null;
						$scope.lblMsg = null;
						$scope.msg = "Welcome Mr."+$scope.username;
					} else {
						$scope.msg = "Invalid User";
						$location.path('/')
					}
				}, function(response) {
					$scope.msg = "Unsuccessful";
					$scope.statusval = response.status;
					$scope.statustext = response.statusText;
					$scope.headers = response.headers();
				});
	};
	
});


app.controller('recommendCtrl', function($scope, $http, $location){
	$scope.clicked = function(){  
    
    $http.get('/get-acc-data').then(
			function(response) {
				if (response.data) {
					$scope.alldata = response.data;
					$scope.message="Recommendations";
					$location.path('/show');
				} else {
					$scope.msg = "error";
				}
			}, function(response) {
				$scope.msg = "Unsuccessful";
				$scope.statusval = response.status;
				$scope.statustext = response.statusText;
				$scope.headers = response.headers();
			});
    };
});
    app.controller('showRecCtrl', function($scope, $http, $location){

    	    $http.get('/get-acc-data').then(
    				function(response) {
    					if (response.data) {
    						$scope.recdata = response.data;
    						console.log($scope.recdata);
    					} else {
    						$scope.msg = "error";
    					}
    				}, function(response) {
    					$scope.msg = "Unsuccessful";
    					$scope.statusval = response.status;
    					$scope.statustext = response.statusText;
    					$scope.headers = response.headers();
    				});
    });


