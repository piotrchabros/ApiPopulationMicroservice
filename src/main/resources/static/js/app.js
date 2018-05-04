var countries = [];
var totalPopulationChartData = [];
var totalPopulationChartData = [
    {
        x: [],
        y: [],
        type: 'bar'
    }
];

var getCountries = function (){
    $.ajax({
        url: '/ajax/countries',
        method: 'get'
    }).done(function(response) {
        var jsonResponse = JSON.parse(response);
        countries = jsonResponse.countries;

        populateCountrySelectBox($('#country1'));
        populateCountrySelectBox($('#country2'));
        populateCountrySelectBox($('#country3'));

        selectRandomCountries();
    });
}

var selectRandomCountries = function(){
    $('#country1').val('Finland');
    $('#country2').val('Poland');
    $('#country3').val('Germany');

    $('#country1').trigger('change');
    $('#country2').trigger('change');
    $('#country3').trigger('change');
}

var getTotalTodayPopulationByCountryAjax = function (country, callback) {
    $.ajax({
        url: '/ajax/population/' + country + '/' + todayDateStr(),
        method: 'get'
    }).done(function(response){
        var jsonResponse = JSON.parse(response);
        callback(country, jsonResponse.total_population.population);
    });
}

populateCountrySelectBox = function(selectBox) {
    for(var i = 0; i < countries.length; i++){
        selectBox.append('<option value="'+countries[i]+'">'+countries[i]+'</option>');
    }
}

todayDateStr = function() {

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd = '0'+dd
    }

    if(mm<10) {
        mm = '0'+mm
    }

    today = yyyy + '-' + mm + '-' + dd;

    return today;
}

$(document).ready(function() {
    getCountries();

    $('#country1').change(function(data){
        getTotalTodayPopulationByCountryAjax($(this).val(), function(name, value){
            totalPopulationChartData[0].x[0] = name;
            totalPopulationChartData[0].y[0] = value;
            Plotly.newPlot('totalPopulationChart', totalPopulationChartData);
        });
    });

    $('#country2').change(function(data){
        getTotalTodayPopulationByCountryAjax($(this).val(), function(name, value){
            totalPopulationChartData[0].x[1] = name;
            totalPopulationChartData[0].y[1] = value;
            Plotly.newPlot('totalPopulationChart', totalPopulationChartData);
        });
    });

    $('#country3').change(function(data){
        getTotalTodayPopulationByCountryAjax($(this).val(), function(name, value){
            totalPopulationChartData[0].x[2] = name;
            totalPopulationChartData[0].y[2] = value;
            Plotly.newPlot('totalPopulationChart', totalPopulationChartData);
        });
    });
});