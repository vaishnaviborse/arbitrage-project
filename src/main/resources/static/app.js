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
		templateUrl : 'recomm.html',
		controller: 'recommCtrl'
	})
	
	.otherwise({ redirectTo: '/' });
	
	
});

app.controller('loginCtrl', function($scope){
	$scope.message = "Hello, this is login";
});

app.controller('homeCtrl', function($scope){
	$scope.message = "Hello, this is home";
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


app.controller('recommCtrl', function($scope, $http, $location){
	$scope.msg = "yo bro";
	$scope.clicked = function(){  
    
    $http.get('/get-acc-data').then(
			function(response) {
				if (response.data) {
					$scope.alldata = response.data;
					$scope.trial="trial";
					console.log($scope.alldata);
					$location.path('/recommend');
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

