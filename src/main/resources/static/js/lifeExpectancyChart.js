var lifeExpectancyChartDataMale = {
    x: [],
    y: [],
    name: SEX_MALE,
    type: 'bar'
}
var lifeExpectancyChartDataFemale = {
    x: [],
    y: [],
    name: SEX_FEMALE,
    type: 'bar'
}
var setLifeExpectancyChartData = function (index, data)
{
    if(data.sex == SEX_MALE)
    {
        lifeExpectancyChartDataMale.y[index] = data.total_life_expectancy;
        lifeExpectancyChartDataMale.x[index] = data.country;
    }
    else if(data.sex == SEX_FEMALE)
    {
        lifeExpectancyChartDataFemale.y[index] = data.total_life_expectancy;
        lifeExpectancyChartDataFemale.x[index] = data.country;
    }
    plotLifeExpectancyChart();
}

var plotLifeExpectancyChart = function() {
    var lifeExpectancyChartData = [lifeExpectancyChartDataMale, lifeExpectancyChartDataFemale];
    var layout = {barmode: 'group'};
    Plotly.newPlot('lifeExpectancyChart', lifeExpectancyChartData, layout);
}