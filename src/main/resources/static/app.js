var app = angular.module('postserviceApp', [ 'ngRoute','ngTable' ]);

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
		// templateUrl : 'recommend.html',
		controller: 'recommCtrl'
	})
	.when('/show', {
		templateUrl : 'show.html',
		controller: 'showRecCtrl'
	})
	.when('/save', {
		templateUrl : 'save.html',
		controller: 'saveCtrl'
	})	
	.when('/saved', {
		templateUrl : 'saved.html',
		// controller: 'saveCtrl'
	})
	.otherwise({ redirectTo: '/' });
	
	
});



app.controller('loginCtrl', function($scope){
	$scope.message = "Hello, this is login";
});

app.controller('homeCtrl', function($scope, $http, $location, ngTableParams,$defer){
	$scope.message = "Hello, this is home";

	    $http.get('/nifty-data').then(
				function(response) {
					if (response.data) {
						$scope.ndata = response.data;
                
                        <!-- **** -->
                        $scope.stocksTable = new ngTableParams({
                                page: 1,
                                count: 10
                                }, 
                                {
                                total: $scope.ndata.length, 
                                getData: function ($defer, params) {
                                $scope.data = $scope.ndata.slice((params.page() - 1) * params.count(), params.page() * params.count());
                                $defer.resolve($scope.data);
                                }
                            });
                        
					}else {
						$scope.msg = "error";
					}
					} , function(response) {
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
   				$location.path('/show');
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



    app.controller('saveCtrl', function($scope, $http, $location){
    	$scope.clicked = function(){  
	    $http.get('/save-history').then(
				function(response) {
					if (response.data) {
						// $scope.recdata = response.data;
						$scope.message="Saved";
						$location.path="/saved"
						
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
    	};
});

