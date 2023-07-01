var p_cost = document.getElementById('p_cost');
var avg = document.getElementById('avg');
var kw_out = document.getElementById('kw_out');
var num = document.getElementById('num');
var charging_p_day = document.getElementById('charging/day');
var days_p_month = document.getElementById('days/month');
var kw_cost = document.getElementById('kw_cost');
var kW_MSRP = document.getElementById('kW_MSRP');


const headers = {
    'Content-Type': 'application/json'
};


async function handleSubmit(e) {
    e.preventDefault();

    kw_out_value = 0;

    if (kw_out.value == 1) {
        kw_out_value = 7.7;
    } else if (kw_out.value == 2) {
        kw_out_value = 11;
    } else if (kw_out.value == 3) {
        kw_out_value = 19;
    } else if (kw_out.value == 4) {
        kw_out_value = 190;
    }

    let bodyObj = {
        avgChargingSessionDuration: avg.value,
        stationKWOutput: kw_out_value,
        noOfChargingStations: num.value,
        chargingSessionsPerDayPerUnit: charging_p_day.value,
        daysOfUsePerMonth: days_p_month.value,
        projectCost: p_cost.value,
        kwCost: kw_cost.value,
        kwMSRP: kW_MSRP.value
    };

    console.log(bodyObj);

    const response = await fetch("http://localhost:8080/roi/getroi", {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message));

    if (response.status === 200) {
        var gross = document.getElementById('gross');
        var kwCost = document.getElementById('kwCost');
        var kw_gross = document.getElementById('kw_gross');
        var margin = document.getElementById('margin');
        var months = document.getElementById('months');
        var years = document.getElementById('years');

        var resp_json = await response.json();

        gross.innerHTML = resp_json.grossKWDispensed;
        kwCost.innerHTML = resp_json.kwCost;
        kw_gross.innerHTML = resp_json.kwGross;
        margin.innerHTML = resp_json.margin;
        console.log(resp_json);
        months.innerHTML = resp_json.monthsToPayOff;
        years.innerHTML = resp_json.yearsToOff;
    } else {
        console.log("error")
    }
}

var form = document.getElementById('form');
form.addEventListener("submit", handleSubmit);