$(document).ready(function($){
    var array = [];
    $('#tabledit tbody').on('click','#editButtom',function(){
        var curRow = $(this).closest('tr');

        var col1 = curRow.find('td:eq(0)').text();
        array.push(col1);
        var col2 = curRow.find('td:eq(1)').text();
        array.push(col2);
        var col3 = curRow.find('td:eq(2)').text();
        array.push(col3);
        var col4 = curRow.find('td:eq(3)').text();
        array.push(col4);
        var col5 = curRow.find('td:eq(4)').text();
        array.push(col5);
        var result = col1+ '\n'+col2+ '\n'+col3+ '\n'+col4+ '\n'+col5;
        console.log(array);
        alert(array);
        var modal =''
        modal += '<form action="/update" method="POST">'
        modal +='<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
        modal += '<div class="modal-dialog" role="document">'
        modal += '<div class="modal-content">'
        modal+= '<div class="modal-header text-center">'
        modal += '<h4 class="modal-title w-100 font-weight-bold">Modificar Estudiante</h4>'
        modal += '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
        modal += ' <span aria-hidden="true">&times;</span>'
        modal += '</button>'
        modal += '</div>'
        modal += '<div class="modal-body mx-3">'

        modal += '<div class="md-form mb-2">'
        modal += '<i class="fas fa-id prefix grey-text"></i>'
        modal += '<input type="hidden" id="defaultForm-email" class="form-control validate" value="'+array[0]+'" name="id">'

        modal += '</div>'

        modal += '<div class="md-form mb-2">'
        modal += '<i class="fas fa-id prefix grey-text"></i>'
        modal += '<input type="name" id="defaultForm-email" class="form-control validate" value="'+array[1]+'" name="student_id">'

        modal += '</div>'


        modal += '<div class="md-form mb-2">'
        modal += '<i class="fas fa-signature prefix grey-text"></i>'
        modal += '<input type="name" id="defaultForm-email" class="form-control validate" value="'+array[2]+'" name="name">'

        modal += '</div>'

        modal += '<div class="md-form mb-2">'
        modal += '<i class="fas fa-signature prefix grey-text"></i>'
        modal += '<input type="name" id="defaultForm-email" class="form-control validate" value="'+array[3]+'" name="last_name">'

        modal += '</div>'

        modal += '<div class="md-form mb-2">'
        modal += '<i class="fas fa-phone prefix grey-text"></i>'
        modal += '<input type="name" id="defaultForm-email" class="form-control validate" value="'+array[4]+'" name="tel">'

        modal += '</div>'


        modal += '<div class="modal-footer d-flex justify-content-center"><button class="btn btn-default" type="submit">Modificar</button></div>'
        modal += '</div>'
        modal += '</div>'
        modal += '</div>'
        modal += '</form>'
        $(document).find('.modal_form').html(modal);



    });
    console.log(array);


    var modal = '';
    function loadButtom(){
        modal += '<div class="text-center"><a href="" class="btn btn-default btn-rounded mb-2" data-toggle="modal" id="editButtom" data-target="#modalLoginForm">Editar</a> </div>'
        $(document).find('.modal_form').html(modal);
    }
    loadButtom();


});