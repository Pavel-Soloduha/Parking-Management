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
        var trHTML = '';
        $.each(data, function (i, item) {
                trHTML += '<tr><td><a href="/Parking-Management/html-frame/tariff.html/?id=1">' + item.tariffName + '</a></td>'
                + '<td>' + item.costPerHour + '</td>'
                + '<td>' + item.description + '</td>'
                + '</tr>';
            });
        var table = $('#tarifftable').children();
        table.append(trHTML);
    });
};

$(document).ready(function () {
    createTariffTable();
});