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
            trHTML += '<tr><td><a href="/parking.html/?id=1">' + item.parkingName + '</a></td>'
            + '<td>' + (item.amountPlace - item.amountBusy) + '</td>'
            + '<td>' + item.amountBusy + '</td>'
            + '<td>' + item.amountFloor + '</td>'
            + '<td>' + item.address + '</td>'
            + '<td>' + item.description + '</td>'
            + '</tr>';
        });
        var table = $('#parkingtable').children();
        table.append(trHTML);
//        foo();
        fun();
    });
};

function getParameter(theParameter) {
  var params = window.location.search.substr(1).split('&');

  for (var i = 0; i < params.length; i++) {
    var p=params[i].split('=');
	if (p[0] == theParameter) {
	  return decodeURIComponent(p[1]);
	}
  }
  return false;
}

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

function createCarInfoTable() {
    $('#carinfotable').append('<table></table>');
    var table = $('#carinfotable').children();
    table.append("<tr>"
    + "<td>First name</td>"
    + "<td>Last name</td>"
    + "<td>Contact phone</td>"
    + "<td>Car number</td>"
    + "</tr>");
    fillCarInfoTable();
//    console.log('hi');
};
function fillCarInfoTable() {
    $.get("http://localhost:8080/parkingManagement/place/", function(data, status){
        var info = data.places;
        var trHTML = '';
        $.each(info, function (i, item) {
            trHTML += '<tr><td>' + item.carInfo.firstName + '</td>'
            + '<td>' + item.carInfo.lastName + '</td>'
            + '<td>' + item.carInfo.phone + '</td>'
            + '<td>' + item.carInfo.carNumber + '</td>'
            + '</tr>';
        });
        var table = $('#carinfotable').children();
        table.append(trHTML);
    });
};

//var foo = function() {
//    $('tr td').click(function(){
//        var column_num = parseInt( $(this).index() ) + 1;
//        var row_num = parseInt( $(this).parent().index() )+1;
//
//        alert('Row Number: '+(row_num)+'\nColumn Number: '+(column_num));
////        var row = $(this).find('td:last').text();
////        alert('You clicked ' + row);
//    });
//};

var fun = function() {
    var table = $('#parkingtable').children();
    alert(table.rows[1].cells[1]);
};

$(document).ready(function (){
   createParkingTable();
//   createTariffTable();
//   createPlaceTable();
//   createCarInfoTable();
//    foo();
//    fun();

});