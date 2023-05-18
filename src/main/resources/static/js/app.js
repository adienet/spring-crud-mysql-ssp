function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}


angular.module("app", []).controller("PatientController", function($scope) {
    $scope.message="List Data Patient";
    $scope.openModal = function() {
        $("#action").val('add');
        $('#myModal').modal('show');
    };

    $scope.closeModal = function() {
        $('#myModal').modal('hide');
    };

    $scope.btnSave = function() {
        console.log('save');
        $('#myModal').modal('hide');
        var id = $('#pid').val();
        var formdata = JSON.stringify(getFormData($('#formPatient')));
        console.log(formdata);
        if ($('#action').val()=='add'){
            $.ajax({
                url : '/patient',
                type : 'POST',
                contentType: "application/json",
                dataType:'json',
                data: formdata,
                success : function(data) {
                    $('#myModal').modal('show');
                    console.log(data);
                },
                error : function(request,error)
                {
                    console.log(data);
                }
            });
        }
        if ($('#action').val()=='edit'){
            $.ajax({
                url : '/patient/'+pid,
                type : 'PUT',
                dataType:'json',
                data: formdata,
                success : function(data) {
                    $('#myModal').modal('show');
                    console.log(data);
                },
                error : function(request,error)
                {
                    console.log(data);
                }
            });
        }
    };


})

