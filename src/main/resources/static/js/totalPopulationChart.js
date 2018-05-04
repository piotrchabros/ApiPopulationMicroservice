var totalPopulationChartData = [
    {
        x: [],
        y: [],
        type: 'bar'
    },
];

var plotTotalPopulationChart = function() {
    Plotly.newPlot('totalPopulationChart', totalPopulationChartData);
}