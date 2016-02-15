function createParkingTable() {
    $('#parkingtable').append('<table></table>');
    var table = $('#parkingtable').children();
    table.append("<tr>"
    + "<td>Parking name</td>"
    + "<td>Amount free places</td>"
    + "<td>Amount busy places</td>"
    + "<td>Amount floors</td>"
    + "<td>Parking address</td>"
    + "<td>Description</td>"
    + "</tr>");
    fillParkingTable();
};
function fillParkingTable() {
    $.get("http://localhost:8080/parkingManagement/parking/", function(data, status){
        var info = data.parkings;
        var trHTML = '';
        $.each(info, function (i, item) {
            trHTML += '<tr><td>' + item.parkingName + '</td>'
            + '<td>' + (item.amountPlace - item.amountBusy) + '</td>'
            + '<td>' + item.amountBusy + '</td>'
            + '<td>' + item.amountFloor + '</td>'
            + '<td>' + item.address + '</td>'
            + '<td>' + item.description + '</td>'
            + '</tr>';
        });
        var table = $('#parkingtable').children();
        table.append(trHTML);
    });
};

function createTariffTable() {
    $('#tarifftable').append('<table></table>');
    var table = $('#tarifftable').children();
    table.append("<tr>"
    + "<td>Tariff name</td>"
    + "<td>Cost per hour</td>"
    + "<td>Description</td>"
    + "</tr>");
    fillTariffTable();
};
function fillTariffTable() {
    $.get("http://localhost:8080/parkingManagement/tariff/", function(data, status){
        var info = data.tariffs;
        var trHTML = '';
        $.each(info, function (i, item) {
            trHTML += '<tr><td>' + item.tariffName + '</td>'
            + '<td>' + item.costPerHour + '</td>'
            + '<td>' + item.description + '</td>'
            + '</tr>';
        });
        var table = $('#tarifftable').children();
        table.append(trHTML);
    });
};

function createPlaceTable() {
    $('#placetable').append('<table></table>');
    var table = $('#placetable').children();
    table.append("<tr>"
    + "<td>Place Id</td>"
    + "<td>Number</td>"
    + "<td>Floor</td>"
    + "<td>Start time</td>"
    + "<td>End time</td>"
    + "</tr>");
    fillPlaceTable();
};
function fillPlaceTable() {
    $.get("http://localhost:8080/parkingManagement/place/", function(data, status){
        var info = data.places;
        var trHTML = '';
        $.each(info, function (i, item) {
            trHTML += '<tr><td>' + item.placeId + '</td>'
            + '<td>' + item.number + '</td>'
            + '<td>' + item.floor + '</td>'
            + '<td>' + item.startDate + '</td>'
            + '<td>' + item.endDate + '</td>'
            + '</tr>';
        });
        var table = $('#placetable').children();
        table.append(trHTML);
    });
};

//function createCarInfoTable() {
//    $('#carinfotable').append('<table></table>');
//    var table = $('#carinfotable').children();
//    table.append("<tr>"
//    + "<td>First name</td>"
//    + "<td>Last name</td>"
//    + "<td>Contact phone</td>"
//    + "<td>Car number</td>"
//    + "</tr>");
//    fillCarInfoTable();
//    console.log('hi');
//};
//function fillCarInfoTable() {
//    $.get("http://localhost:8080/parkingManagement/place/", function(data, status){
//        var info = data.parkings;
//        var trHTML = '';
//        $.each(info, function (i, item) {
//            trHTML += '<tr><td>' + item.parkingName + '</td>'
//            + '<td>' + (item.amountPlace - item.amountBusy) + '</td>'
//            + '<td>' + item.amountBusy + '</td>'
//            + '<td>' + item.amountFloor + '</td>'
//            + '<td>' + item.address + '</td>'
//            + '<td>' + item.description + '</td>'
//            + '</tr>';
//        });
//        var table = $('#carinfotable').children();
//        table.append(trHTML);
//    });
//};



$(document).ready(function (){
   createParkingTable();
   createTariffTable();
   createPlaceTable();
//   createCarInfoTable();
});