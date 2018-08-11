$(document).ready(function () {

    $('#completeForm').on('click', function () {
        let startDate = $('.it-startDate').val();
        let endDate = $('.it-endDate').val();
        let employeeName = $('#employeeName').val();
        let ownerName = $('#ownerName').val();
        let vacation = {
            dateFrom: startDate,
            dateTo: endDate
        };
        $.ajax({
            'type': 'POST',
            'url': baseUrl + '/api/vacation/byName/{0},{1}'.format(employeeName, ownerName),
            'contentType': 'application/json',
            'data': JSON.stringify(vacation),
            'dataType': 'json',
            'success': function (data) {
            }
        });
    });

    $('').on('click', function () {

    });

})