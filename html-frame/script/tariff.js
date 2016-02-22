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
    $.get("http://localhost:8080/parkingManagement/tariff/1", function(data, status) {
        var trHTML = '';
        trHTML += '<tr><td>' + data.tariffName + '</td>'
        + '<td>' + data.costPerHour + '</td>'
        + '<td>' + data.description + '</td>'
        + '</tr>';
        var table = $('#tarifftable').children();
        table.append(trHTML);
    });
};

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
    + "<td style=\"display: none;\">parkingId</td>"
    + "</tr>");
    fillParkingTable();
};
function fillParkingTable() {
     $.get("http://localhost:8080/parkingManagement/parking/", function(data, status){
            var trHTML = '';
            $.each(data, function (i, item) {
                trHTML += '<tr><td><a href="/Parking-Management/html-frame/parking.html/?id=1">' + item.parkingName + '</a></td>'
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

$(document).ready(function (){
    createTariffTable();
    createParkingTable();
});