var myApp = angular.module('myApp', []);
myApp.controller('myController', function requestController($scope, $http) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/'
    }).then(function success(response) {
            $scope.text = response.data;
        },
        function errorCallback(response) {
            alert(response.toString());
        }
    )
});