if (!String.prototype.format) {
    String.prototype.format = function () {
        var args = arguments;
        return this.replace(/{(\d+)}/g, function (match, number) {
            return typeof args[number] != 'undefined'
                ? args[number]
                : match
                ;
        });
    };
}

function constructTable(table, data, startPosition, endPosition, ids) {

    for (let i = 0; i < data.length; i++) {
        let row = $('<tr></tr>');
        let keys = Object.keys(data[i]);
        let columns = "";
        for (let key = startPosition; key < endPosition; key++) {
            let column = $('<td></td>');
            row.append(column.html(data[i][keys[key]]));

        }
        if (table.attr('id').includes('employee-table') && ids) {
            let deleteEmployee = $('<button>Delete</button>').addClass('btn btn-outline-alert')
                .attr('type', 'button')
                .attr('id', ids[i])
                .on('click', deleteEmployeeButton);
            row.append(deleteEmployee);
        }
        table.append(row);
    }
}


function deleteEmployeeButton() {

    let employeId = $(this).attr('id');
    $.get(baseUrl + '/api/employee/deleteById/' + employeId, function (data) {
        //window.location.reload();
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
                        employeeData[x].professionId = prfMap[employeeData[x].professionId]
                    }
                    employeeTable.empty();
                    constructTable(employeeTable, employeeData, 1, Object.keys(data[0]).length - 1, ids)

                });
            });
        });
    });
}