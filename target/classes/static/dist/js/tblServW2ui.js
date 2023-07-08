import { w2grid, w2popup, w2layout, w2form, w2utils, w2alert, w2ui, w2toolbar, w2confirm } from './w2ui-2.0.es6.min.js';

let grid2 = new w2grid({
    name: 'grid2',
    box: '#grid2',
    // header: 'Serventia Extrajudicial',
    show: { columnHeaders: false },
    name: 'grid2',
    columns: [
        { field: 'name', text: 'Name', size: '100px', style: 'background-color: #efefef; border-bottom: 1px solid white; padding-right: 5px;', attr: "align=right" },
        { field: 'value', text: 'Value', size: '100%' }
    ]
});

let layout = new w2layout({
    name: 'layout',
    padding: 0,
    panels: [
        { type: 'main', minSize: 380, overflow: 'hidden' },
        { type: 'bottom' }
    ],
    // onRefresh: function(event) {
    //     console.log('object '+ event.target + ' is refreshed', event);
    // },
    onDestroy: function (event) {
        console.log('object ' + event.target + ' is destroyed');
    }
});

let infoServ = function (event) {
    console.log(event);
    let record = this.get(event.detail.recid);
    console.log(record);
    layout.html('bottom', '');
    w2popup.open({
        title: `Detalhes #${record.nome} - ${record.municipio}`,
        width: 800,
        height: 500,
        showMax: true,
        body: `'<div id="main" style="position: absolute; left: 2px; right: 2px; top: 0px; bottom: 3px;">
    <div id="grid2" style="overflow: hidden;"></div>
    </div>'`
    }).then(() => {
        // let record = this.get(event.detail.recid);
        // console.log(record);
        grid2.clear();
        grid2.add([
            { recid: 0, name: 'id:', value: record.id },
            { recid: 1, name: 'nome:', value: record.nome },
            { recid: 2, name: 'logradouro:', value: record.logradouro },
            { recid: 3, name: 'email:', value: record.email },
            { recid: 4, name: 'cnpj:', value: record.cnpj },
            { recid: 5, name: 'cns:', value: record.cns },
            { recid: 6, name: 'código SEI:', value: record.cod_sei },
            { recid: 7, name: 'município:', value: record.municipio },
            { recid: 8, name: 'telefone:', value: record.telefone },
        ])
        layout.render('#main');
        layout.html('main', grid2);
    })
};

let editServ = (event) => {
    let record = myGrid.get(myGrid.getSelection());
    console.log(layout.get('bottom'));
    layout.html('bottom', '');

    let popupEdit = w2popup.open({
        title: `Editar #${record[0].nome} - ${record[0].municipio}`,
        width: 800,
        height: 500,
        showMax: true,
        body: `<div id="main" style="position: absolute; left: 2px; right: 2px; top: 0px; bottom: 3px;">
                    <div id="form"></div>
                    <div id="resultJson"></div>
                </div>`,
        onClose: function (event) {
            console.log('event: ' + event.type, event);
        }
    }).then(() => {
        form.recid = record[0].id;
        form.record = record[0];
        layout.render('#main');
        layout.html('main', form);
    });
}

let form = new w2form({
    box: '#form',
    name: 'form',
    // url: 'http://localhost:8080/serventias',
    // url: 'serventias',
    // header: 'Edit Serventia',
    fields: [
        {
            field: 'nome', type: 'text',
            html: { label: 'Nome', attr: 'style="width: 500px"' }
        },
        {
            field: 'logradouro', type: 'text',
            html: { label: 'Logradouro', attr: 'style="width: 300px"' }
        },
        {
            field: 'email', type: 'text',
            html: { label: 'Email', attr: 'style="width: 300px"' }
        },
        {
            field: 'cnpj', type: 'text',
            html: { label: 'CNPJ', attr: 'style="width: 300px"' }
        },
        {
            field: 'cns', type: 'text',
            html: { label: 'CNS', attr: 'style="width: 300px"' }
        },
        {
            field: 'cod_sei', type: 'text',
            html: { label: 'Código_SEI', attr: 'style="width: 300px"' }
        },
        {
            field: 'municipio', type: 'text',
            html: { label: 'Município', attr: 'style="width: 300px"' }
        },
        {
            field: 'telefone', type: 'text',
            html: { label: 'Telefone', attr: 'style="width: 300px"' }
        },
        {
            field: 'responsavel', type: 'text',
            html: { label: 'Responsável', attr: 'style="width: 300px"' }
        },
        {
            field: 'situacao', type: 'text',
            html: { label: 'Situação', attr: 'style="width: 300px"' }
        },
        {
            field: 'portaria', type: 'text',
            html: { label: 'Portaria', attr: 'style="width: 300px"' }
        }
    ],
    actions: {
        Reset(event) {
            console.log(event);
        },
        Save(event) {
            if (form.validate().length == 0) {
                this.get(event.details);
                layout.render('#main');
                layout.html('bottom', `<pre>${JSON.stringify(this.getCleanRecord(), null, 4)}</pre>`);
            }
            console.log(layout.get('bottom'));
        },
    },
});

let addForm = new w2form({
    name: 'addForm',
    style: 'border: 0px; background-color: transparent;',
    // httpHeaders: {
    //     'Content-Type': 'application/json; charset=UTF-8',
    // },
    fields: [
        { field: 'nome', type: 'text', required: true },
        { field: 'email', type: 'text', required: true },
        { field: 'bairro', type: 'text', required: true },
    ],
    actions: {
        Reset() {
            this.clear();
        },
        Save() {
            $.ajax({
                method: 'POST',
                url: 'http://localhost:8080/serventias',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(this.record),
                complete: function (event) {
                    console.log("teste de complete", event);
                    layout.html('bottom', `<pre>${JSON.stringify(event, null, 4)}</pre>`)
                },
            });
        }
    },
});

// let popupAddForm = new w2popup.open({
//     title: 'Popup',
//     width: 900,
//     height: 600,
//     showMax: true,
//     body: '<div id="main" style="position: absolute; left: 2px; right: 2px; top: 0px; bottom: 3px;"></div>'
// })

let toolbar = new w2toolbar({
    name: 'toolbar',
    // right : 'text on the right',
    items: [
        { id: 'bt1', type: 'button', text: 'Adicionar', icon: 'fa fa-plus' },
        { id: 'bt2', type: 'button', text: 'Editar', icon: 'fa fa-pen' },
        { id: 'bt3', type: 'button', text: 'Excluir', icon: 'fa fa-trash' },
        { type: 'spacer' },
        { type: 'break' },
        { type: 'html', id: 'id6', html: '<div style="margin-top: 5px;">Filtro: </div>' },
        { id: 'id1', type: 'radio', group: '1', text: 'Instalada' },
        { id: 'id2', type: 'radio', group: '1', text: 'Não Instalada' },
        { id: 'id3', type: 'radio', group: '1', text: 'Anexada' },
        { id: 'id4', type: 'radio', group: '1', text: 'Extinta' },
        { id: 'id5', type: 'radio', group: '1', text: 'Desativada' },
    ],
    onClick(event) {
        let record = myGrid.get(myGrid.getSelection());
        // console.log(myGrid.get());
        switch (event.target) {
            case 'id1': myGrid.search([{ field: 'instalacao', value: 'INSTALADA', type: 'text', operator: 'is' }]);
                break;
            case 'id2': myGrid.search([{ value: ['NÃO INSTALADA'], field: 'instalacao' }], 'OR');
                break;
            case 'id3': myGrid.search([{ value: ['ANEXADA'], field: 'instalacao' }], 'OR');
                break;
            case 'id4': myGrid.search([{ value: ['EXTINTA'], field: 'instalacao' }], 'OR');
                break;
            case 'id5': myGrid.search([{ value: ['DESATIVADA'], field: 'instalacao' }], 'OR');
                break;
            case 'bt1':
                w2popup.open({
                    title: 'Popup',
                    width: 900,
                    height: 600,
                    showMax: true,
                    body: '<div id="main" style="position: absolute; left: 2px; right: 2px; top: 0px; bottom: 3px;"></div>',
                    onClose: function (event) {
                        myGrid.load('http://localhost:8080/serventias').then(res => res);
                    }
                })
                    .then(e => {
                        addForm.clear();
                        layout.render('#w2ui-popup #main')
                        layout.html('main', addForm)
                        layout.html('bottom', '');
                    })
                break;
            case 'bt2':
                if (record.length == 0) {
                    w2utils.notify('Selecione um registro para EDITAR!', { error: true, timeout: 3000 });
                }
                editServ(event);
                break;
            case 'bt3':
                if (record.length == 0) {
                    w2utils.notify('Selecione um registro para EXCLUIR!', { error: true, timeout: 3000 });
                }
                w2confirm({
                    msg: `Excluir ${record[0].nome} de ${record[0].municipio}?`,
                    btn_yes: {
                        text: 'Sim',   // text for yes button (or yes_text)
                        class: '',     // class for yes button (or yes_class)
                        style: '',     // style for yes button (or yes_style)
                        onClick: null  // callBack for yes button (or yes_callBack)
                    },
                    btn_no: {
                        text: 'Não',   // text for yes button (or yes_text)
                        class: '',     // class for yes button (or yes_class)
                        style: '',     // style for yes button (or yes_style)
                        onClick: null  // callBack for yes button (or yes_callBack)
                    },
                }, 'Exclusão de Serventia')
                    .yes(() => {
                        console.log('Sim');
                        $.ajax({
                            method: 'DELETE',
                            url: `http://localhost:8080/serventias/${record[0].id}`,
                            contentType: 'application/json; charset=UTF-8',
                            complete: function (event) {
                                console.log("COMPLETE", event);
                                if (event.status == 200) {
                                    console.log("STATUS ENTER");
                                    myGrid.searchReset();
                                    myGrid.load('http://localhost:8080/serventias').then(res => res);
                                    w2utils.notify(`Registro ${record[0].nome} excluído com SUCESSO`, { type: 'success', timeout: 3000 });
                                }
                            },
                        });
                    })
                    .no(() => {
                        console.log('Não')
                    });
                break;
            default:
                break;
        }
    },
});


let myGrid = new w2grid({
    box: '#myGrid',
    name: 'myGrid',
    show: { lineNumbers: true, toolbar: true, footer: true, statusSearch: true, statusSort: true },
    liveSearch: true,
    multiSearch: true,
    toolbar: toolbar,
    columns: [
        { field: 'id', text: 'ID', size: '4%' },
        { field: 'nome', text: 'Nome', size: '30%', searchable: { operator: 'contains' }, sortable: true },
        { field: 'email', text: 'Email', size: '20%', sortable: true },
        { field: 'telefone', text: 'Fone', size: '20%', },
        { field: 'instalacao', text: 'Instalação', size: '15%', searchable: { operator: 'contains' } },
        { field: 'responsavel', text: 'Responsável', size: '15%', searchable: { operator: 'contains' } },
        // { field: 'logradouro', text: 'Logradouro', size: '30%', searchable: { operator: 'contains' } },
        // { field: 'cnpj', text: 'CNPJ', size: '13%', },
    ],
    contextMenu: [
        { id: 'view', text: 'View', icon: 'w2ui-icon-info' },
        { id: 'edit', text: 'Edit', icon: 'w2ui-icon-pencil' },
        { text: '--' },
        { id: 'delete', text: 'Delete', icon: 'w2ui-icon-cross' },
    ],
    onSave: function (event) {
        w2alert('save');
    },
    onSearch: function (event) {
        if (event.detail.reset) {
            myGrid.toolbar.uncheck('id1', 'id2', 'id3', 'id4', 'id5')
        }
    },
    onReload: function (event) {
        myGrid.searchReset();
        myGrid.toolbar.uncheck('id1', 'id2', 'id3', 'id4', 'id5');
        myGrid.load('http://localhost:8080/serventias').then(res => res);
    },
    onContextMenuClick(event) {
        // await event.complete
        let menu = event.detail.menuItem.id;
        let record = this.get(event.detail.recid);

        if (menu == 'view') {
            w2popup.open({
                title: `Detalhes #${record.nome} - ${record.municipio}`,
                width: 800,
                height: 500,
                showMax: true,
                body: `<div id="main" style="position: absolute; left: 2px; right: 2px; top: 0px; bottom: 3px;">
            <div id="grid2" style="overflow: hidden;">
            </div>
            </div>`
            }).then(() => {
                // console.log(event);
                let record = this.get(event.detail.recid);
                // console.log(record);
                grid2.clear();
                grid2.add([
                    { recid: 0, name: 'id:', value: record.id },
                    { recid: 1, name: 'nome:', value: record.nome },
                    { recid: 2, name: 'logradouro:', value: record.logradouro },
                    { recid: 3, name: 'email:', value: record.email },
                    { recid: 4, name: 'cnpj:', value: record.cnpj },
                    { recid: 5, name: 'cns:', value: record.cns },
                    { recid: 6, name: 'código SEI:', value: record.cod_sei },
                    { recid: 7, name: 'município:', value: record.municipio },
                    { recid: 8, name: 'telefone:', value: record.telefone },
                ])
                layout.render('#main');
                layout.html('main', grid2);
            })
        } else if (menu == 'edit') {
            w2popup.open({
                title: `Editar #${record.nome} - ${record.municipio}`,
                width: 800,
                height: 500,
                showMax: true,
                body: `<div id="main" style="position: absolute; left: 2px; right: 2px; top: 0px; bottom: 3px;">
                <div id="form"></div>
                <div id="resultJson"></div>
                </div>`
            }).then(() => {
                console.log(record);
                form.recid = record.id;
                form.record = w2utils.clone(this.get(event.detail.recid));
                form.refresh();
                // console.log("form.record => ", form.record);

                layout.render('#main');
                layout.html('main', form);
            });
        } else if (menu == 'delete') {
            console.log(menu);
        }

        // query('#grid-log').html(event.detail.menuItem.text)
    },
    async onClick(event) {
        await event.complete
        let record = this.get(event.detail.recid);
        let sel = myGrid.getSelection();
    },
    onDblClick: infoServ,
});

myGrid.load('http://localhost:8081/serventias').then(res => res);
