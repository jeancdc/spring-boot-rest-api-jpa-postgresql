$(document).ready(function() {

    $.ajax({
        url: 'http://localhost:8080/api/v1/greeting'
    }).then(function(data, status, jqxhr) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
    });

    $.ajax({
        url: 'http://localhost:8080/api/v1/customers'
    }).then(function(data, status, jqxhr) {
        data.forEach(function(d) {
            $('.data-content').append(JSON.stringify(d) + '<br />');
        });
    });

});
