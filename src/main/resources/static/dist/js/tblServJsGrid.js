$(function () {
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
        inserting: true,
        filtering: true,
        editing: true,
        sorting: true,
        paging: true,
        // pageLoading: true,
        autoload: true,
        // loadMessage: "Please, wait...",
        rowClick: function (args) {
            // showDetailsDialog("Edit", args.item);
            console.log("args.item => ", args.item)
        },
        controller: {
            loadData: function (filter) {
                var d = $.Deferred();
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/serventias",
                    // data: filter,
                    dataType: "json",
                }).done(result => {
                    let fil = Object.entries(filter).filter(el => el[1]);
                    if (fil[0] != undefined) {
                        let attr0 = fil[0][0];
                        let attr1 = fil[0][1];
                        result = $.grep(result, function (item) {
                            let _res;
                            let val = Object.entries(item);
                            val.forEach(element => {
                                let e1 = element[0].toLowerCase();
                                let e2 = element[1];
                                if (attr0 == e1 && e2 != null) {
                                    e2 = e2.toLowerCase();
                                    if (e2.includes(attr1)) {
                                        _res = element;
                                    }
                                }
                            });
                            // console.log(_res);
                            return _res;
                        })
                    }
                    dt = result.length;
                    d.resolve(result);
                })
                return d.promise();
            },
            updateItem: function (item) {
                console.log(item.id, item.nome);
                return $.ajax({
                    type: "PUT",
                    url: "http://localhost:8080/serventias",
                    data: item
                });
            },
        },
        fields: [
            {
                name: "nome", type: "text", width: 120, filtering: true,
                headerTemplate: function () {
                    // console.log(this._grid.data);
                    console.log(this._parent);
                    return `NOME`
                },
            },
            { name: "logradouro", type: "text", width: 100 },
            { name: "email", type: "text", width: 100, filtering: true, },
            { name: "cnpj", type: "text", width: 55 },
            { name: "municipio", type: "text", width: 50 },
            { type: "control" }
        ],
        pagerFormat: "{first} {prev} {pages} {next} {last} &nbsp; {pageIndex} de {pageCount}    Page",
        pagePrevText: "<",
        pageNextText: ">",
        pageFirstText: "<<",
        pageLastText: ">>",
        // headerRowRenderer: function(params) {
        // console.log(params);
        // },

    });
});

let data = fetch('http://localhost:8080/serventias')
    .then(res => res.json())
    .then(resp => {
        resp.forEach(el => el)
    })


function applyFilter(data, filter) {
    return $.grep(data, function (item) {
        // return true/false depending on filter condition
        return (!filter.Name || item.Name.indexOf(filter.Name) > -1)
    });
};

// fetch('http://localhost:8080/serventias')
//   .then(res => res.json())
//   .then(resp => console.log(resp))

var showDetailsDialog = function (dialogType, serventia) {
    $("#nome").val(serventia.nome);
    $("#logradouro").val(serventia.logradouro);
    $("#email").val(serventia.email);
    $("#cnpj").val(serventia.cnpj);
    $("#municipio").val(serventia.municipio);

    formSubmitHandler = function () {
        saveClient(client, dialogType === "Add");
    };

    $("#detailsDialog").dialog("option", "title", dialogType + " Client")
        .dialog("open");
};