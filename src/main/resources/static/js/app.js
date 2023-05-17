angular.module("app", []).controller("PatientController", function($scope) {
    $scope.message="List Data Patient";
    $scope.openModal = function() {
        $('#myModal').modal('show');
      };

      $scope.closeModal = function() {
        $('#myModal').modal('hide');
      };
})

