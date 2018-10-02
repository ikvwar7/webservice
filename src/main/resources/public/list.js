var myApp = angular.module('myApp', []);
myApp.controller('myController', function requestController($scope, $http) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/getClients'
    }).then(function success(response) {
            $scope.clients = response.data;
        },
        function errorCallback(response) {
            alert(response.toString());
        }
    )
});