// The root URL for the RESTful services
//var USER_URL = "http://localhost:8080/rest/user";
var PARKINGS_URL = "http://localhost:8080/parkingManagement";

findAll();

// Register listeners
//$('#btnSave').click(function () {
//    if ($('#userId').val() == '')
//        addUser();
//    else
//        updateUser();
//    return false;
//});

function findAll() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: PARKINGS_URL,
        dataType: "json", // data type of response
        success: renderList,
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            alert('findAll: ' + textStatus);
        }
    });
}

function renderList(data) {
    console.log('renderList');
    var dto = data.parkings == null ? [] : (data.parkings instanceof Array ? data.parkings : [data.parkings]);
    var dto = data;
    console.log(data instanceof Array);
    $('#parkingList tr').remove();
    $.each(dto, function (index, parking) {
        drawRow(parking);
    });
}

function drawRow(parking) {
    console.log('drawRow');
    var row = $("<tr />")
    $("#parkingList").append(row);
    row.append($("<td>" + '<a href="#" data-identity="' + parking.parkingId + '">' + parking.amountPlace
     + '</a></td>'));
    row.append($("<td>" + parking.address + "</td>"));
}
//
//function addUser() {
//    console.log('addUser');
//    $.ajax({
//        type: 'POST',
//        contentType: 'application/json',
//        url: USER_URL,
//        dataType: "json",
//        data: formToJSON(),
//        success: function (data, textStatus, jqXHR) {
//            alert('User created successfully');
//            $('#userId').val(data.userId);
//            findAll();
//        },
//        error: function (jqXHR, textStatus, errorThrown) {
//            alert('addUser error: ' + textStatus);
//        }
//    });
//}
//
//function updateUser() {
//    console.log('updateUser');
//    $.ajax({
//        type: 'PUT',
//        contentType: 'application/json',
//        url: USER_URL,
//        data: formToJSON(),
//        success: function (data, textStatus, jqXHR) {
//            alert('User updated successfully');
//            findAll();
//        },
//        error: function (jqXHR, textStatus, errorThrown) {
//            alert('updateUser error: ' + textStatus);
//        }
//    });
//}
//
//function formToJSON() {
//    var userId = $('#userId').val();
//    return JSON.stringify({
//        "userId": userId == "" ? null : userId,
//        "login": $('#login').val(),
//        "password": $('#password').val()
//    });
//}
