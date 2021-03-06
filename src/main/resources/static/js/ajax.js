var getCountries = function (callback){
    $.ajax({
        url: GET_COUNTRIES_URL,
        method: 'get'
    }).done(function(response) {
        callback(response.countries);
    });
}

var getTotalTodayPopulationByCountryAjax = function (country, callback) {
    $.ajax({
        url: GET_POPULATION_URL + country + '/' + todayDateStr(),
        method: 'get'
    }).done(function(response){
        callback(country, response.total_population.population);
    });
}

var getAverageLifeExpectancyAjax = function (country, callback) {

    $.ajax({
        url: GET_LIFE_EXPECTANCY_URL + SEX_MALE + '/' + country + '/' + DATE_OF_BIRTH,
        method: 'get'
    }).done(function(response){
        callback(response);
    });

    $.ajax({
        url: GET_LIFE_EXPECTANCY_URL + SEX_FEMALE + '/' + country + '/' + DATE_OF_BIRTH,
        method: 'get'
    }).done(function(response){
        callback(response);
    });
}