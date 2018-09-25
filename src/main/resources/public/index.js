//jQuery
// $(document).ready(function () {
//     var request = new XMLHttpRequest();
//     request.open('GET', 'http://localhost:8080/');
//     request.onreadystatechange = function () {
//         if (request.readyState == 4) {
//             if (request.status == 200) {
//                 $("#section").text(request.responseText);
//             }
//         }
//     }
//     request.send();
// });
//

//angular
var myApp = angular.module('myApp', []);
myApp.controller('myController', function requestController($scope, $http) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/'
    }).then(function success(response) {
            $scope.text = response.data;
        }
        , function errorCallback(response) {
            alert(response.toString());
        }
    )
});