function createParkingTable() {
    $('#parkingtable').append('<table></table>');
    var table = $('#parkingtable').children();
    table.append("<tr>"
    + "<td><a href=Parking name</td>"
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
        var info = data.parkings;
        var trHTML = '';
        $.each(info, function (i, item) {
            trHTML += '<tr><td><a href="/Parking-Management/html-frame/parking.html/?id=1">' + item.parkingName + '</a></td>'
            + '<td>' + (item.amountPlace - item.amountBusy) + '</td>'
            + '<td>' + item.amountBusy + '</td>'
            + '<td>' + item.amountFloor + '</td>'
            + '<td>' + item.address + '</td>'
            + '<td>' + item.description + '</td>'
            + '<td style="display: none;">' + item.parkingId + '</td>'
            + '</tr>';
        });
        var table = $('#parkingtable').children();
        table.append(trHTML);
    });
};

$(document).ready(function (){
   createParkingTable();
//   var colToHide = $tbl.find("." + $(this).attr("name"));
//   $(colToHide).toggle();
});