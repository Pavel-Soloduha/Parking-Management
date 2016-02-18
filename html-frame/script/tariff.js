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
    $.get("http://localhost:8080/parkingManagement/tariff/1", function(data, status){
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


function createInput() {
        var $butPark = $('<input type="button" onclick="location.href(\'http://www.google.com\');" value="Parkings"/>');
        $butPark.appendTo($('#buttonParkings'));
        var $butTar = $('<input type="button" onclick="location.href(\'http://www.google.com\');" value="Tariffs"/>');
        $butTar.appendTo($('#buttonTariffs'));
};

$(document).ready(function (){
   createInput();
//   createParkingTable();
   createTariffTable();
//   createPlaceTable();
//   createCarInfoTable();
//    foo();
//    fun();

});