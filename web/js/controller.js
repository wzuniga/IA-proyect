var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
    
    $scope.songs = [];
    $scope.test = "";

    var arr = [{grupo : "Mana", name:"Mariposa Traicionera"},
               {grupo : "Mana", name:"Mi verdad"},
               {grupo : "Mana", name:"Labios compartidos"},
               {grupo : "Mana", name:"Oye mi Amor"},
               {grupo : "Mana", name:"En el muelle de San Blas"},
               {grupo : "Mana", name:"El verdadero amor perdona"},
               {grupo : "Mana", name:"Amor clandestino"}];

    var jsonArray = JSON.parse(JSON.stringify(arr));
    $scope.songs = jsonArray;

});