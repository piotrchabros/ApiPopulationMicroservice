var selectRandomCountries = function(){
    var options = document.getElementById('country1').options;
    $('select').each(function (){
        var randomIndex = Math.round(Math.random() * options.length);
        $(this).val($(options[randomIndex])[0].value);
        $(this).trigger('change');
    });
}

populateCountrySelectBox = function(selectBox, countries) {
    for(var i = 0; i < countries.length; i++){
        selectBox.append('<option value="'+countries[i]+'">'+countries[i]+'</option>');
    }
}

$(document).ready(function() {
    getCountries(function(countries) {
        $('select').each(function (){
            populateCountrySelectBox($(this), countries);
        });
        selectRandomCountries();
    });

    $('#country1').change(function(data){
        getTotalTodayPopulationByCountryAjax($(this).val(), function(name, value){
            totalPopulationChartData[0].x[0] = name;
            totalPopulationChartData[0].y[0] = value;
            plotTotalPopulationChart();
        });
    });

    $('#country2').change(function(data){
        getTotalTodayPopulationByCountryAjax($(this).val(), function(name, value){
            totalPopulationChartData[0].x[1] = name;
            totalPopulationChartData[0].y[1] = value;
            plotTotalPopulationChart();
        });
    });

    $('#country3').change(function(data){
        getTotalTodayPopulationByCountryAjax($(this).val(), function(name, value){
            totalPopulationChartData[0].x[2] = name;
            totalPopulationChartData[0].y[2] = value;
            plotTotalPopulationChart();
        });
    });

    $('#country4').change(function(data) {
        getAverageLifeExpectancyAjax($(this).val(), function(data){
            setLifeExpectancyChartData(0, data);
        });
    });

    $('#country5').change(function(data) {
        getAverageLifeExpectancyAjax($(this).val(), function(data){
            setLifeExpectancyChartData(1, data);
        });
    });

    $('#country6').change(function(data) {
        getAverageLifeExpectancyAjax($(this).val(), function(data){
            setLifeExpectancyChartData(2, data);
        });
    });
});