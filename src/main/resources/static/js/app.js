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
        $('#formPatient').find("input[type=text]").val("");
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
                    $('#myModal').modal('hide');
                    $('#tablepatient').DataTable().ajax.reload();
                },
                error : function(request,error)
                {
                    console.log(error);
                }
            });
        }
        if ($('#action').val()=='edit'){
            var urledit = '/patient/'+id;
            console.log('urledit'+urledit);
            $.ajax({
                url : urledit,
                type : 'PUT',
                contentType: "application/json",
                dataType:'json',
                data: formdata,
                success : function(data) {
                    $('#myModal').modal('hide');
                    $('#tablepatient').DataTable().ajax.reload();
                },
                error : function(request,error)
                {
                    console.log(error);
                    $('#tablepatient').DataTable().ajax.reload();
                }
            });
        }
    };


})

