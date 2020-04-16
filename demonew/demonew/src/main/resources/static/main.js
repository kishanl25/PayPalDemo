var app = angular.module("LibraryManagement", []);
 
// Controller Part
app.controller("LibraryController", function($scope, $http) {
 
 
    $scope.libraries = [];
    $scope.libraryForm = {
        libraryId: 1,
        libraryName: ""
    };
 
    // Now load the data from server
    _refreshLibraryData();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitLibrary = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.libraryForm.libraryId == -1) {
            method = "POST";
            url = '/addLibrary';
        } else {
            method = "PUT";
            url = '/addLibrary';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.libraryForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.libraryEmployee = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteLibrary = function(employee) {
        $http({
            method: 'DELETE',
            url: '/library/' + library.libraryId
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editLibrary = function(library) {
        $scope.libraryForm.libraryId = library.libraryId;
        $scope.libraryForm.libraryName = library.libraryName;
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshLibraryData() {
        $http({
            method: 'GET',
            url: '/libraries'
        }).then(
            function(res) { // success
                $scope.libraries = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshLibraryData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.libraryForm.libraryId = -1;
        $scope.libraryForm.libraryName = ""
    };
});