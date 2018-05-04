var selectRandomCountries = function(){
    $('#country1').val('Finland');
    $('#country2').val('Poland');
    $('#country3').val('Germany');
    $('#country4').val('Sierra Leone')
    $('#country5').val('Niger')
    $('#country6').val('Belgium')

    $('#country1').trigger('change');
    $('#country2').trigger('change');
    $('#country3').trigger('change');
    $('#country4').trigger('change');
    $('#country5').trigger('change');
    $('#country6').trigger('change');
}

populateCountrySelectBox = function(selectBox, countries) {
    for(var i = 0; i < countries.length; i++){
        selectBox.append('<option value="'+countries[i]+'">'+countries[i]+'</option>');
    }
}

$(document).ready(function() {
    getCountries(function(countries) {
        populateCountrySelectBox($('#country1'), countries);
        populateCountrySelectBox($('#country2'), countries);
        populateCountrySelectBox($('#country3'), countries);
        populateCountrySelectBox($('#country4'), countries);
        populateCountrySelectBox($('#country5'), countries);
        populateCountrySelectBox($('#country6'), countries);

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