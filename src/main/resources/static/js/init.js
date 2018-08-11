let baseUrl = window.location.origin;

$(document).ready(function () {

    $.get(baseUrl + '/api/salary/', function (data) {
        let vacationTable = $('#salary-table');
        constructTable(vacationTable, data, 0, Object.keys(data[0]).length, null)
    });

    $.get(baseUrl + '/api/vacation/', function (data) {
        let vacationTable = $('#vacation-table');
        let vacationData = data;
        $.get(baseUrl + '/api/employee/', function (dataEmpls) {
            let employeeMap = {};
            for (let i = 0; i < dataEmpls.length; i++) {
                employeeMap[dataEmpls[i].id] = dataEmpls[i].name;
            }
            for (let z = 0; z < vacationData.length; z++)
            {
            //
            //     if (employeeMap[vacationData[z].employeeID] === undefined) {
            //         vacationData.remove(z);
            //     } else {
            //         vacationData[z].employeeID = employeeMap[vacationData[z].employeeID];
            //         vacationData[z].approvedBy = employeeMap[vacationData[z].approvedBy];
            //     }
                vacationData[z].employeeID = employeeMap[vacationData[z].employeeID];
                vacationData[z].approvedBy = employeeMap[vacationData[z].approvedBy];
            }
            constructTable(vacationTable, vacationData, 1, Object.keys(data[0]).length, null);
        })
    });

    $.get(baseUrl + '/api/employee/', function (data) {
        let employeeTable = $('#employee-table');
        let initData = data;
        let ids = [];

        let employeeData = data;
        $.get(baseUrl + "/api/department/", function (depData) {
            let depMap = {};
            for (let i = 0; i < depData.length; i++) {
                depMap[depData[i].id] = depData[i].department;
            }
            for (let z = 0; z < employeeData.length; z++) {
                employeeData[z].department = depMap[employeeData[z].department];
                ids.push(initData[z].id);
            }
            $.get(baseUrl + "/api/profession/", function (prfData) {
                let prfMap = {};
                for (let q = 0; q < prfData.length; q++) {
                    prfMap[prfData[q].id] = prfData[q].professionName;
                }
                for (let x = 0; x < employeeData.length; x++) {

                    employeeData[x].professionId = prfMap[employeeData[x].professionId];
                }
                constructTable(employeeTable, employeeData, 1, Object.keys(data[0]).length - 1, ids)

            });
        });
    });

    $.get(baseUrl + '/api/employee/', function (data) {
        for (let i = 0; i < data.length; i++) {
            let name = data[i].name;
            $("#employeeName").append("<option>{0}</option>".format(name));
            $("#ownerName").append("<option>{0}</option>".format(name));
        }
    });

})