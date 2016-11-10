<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name = "viewport" content = "initial-scale = 1.0, user-scalable = no,  width=device-width">

	
    <title>SUNAT - Mantenimiento en Linea</title>


    <!-- Bootstrap -->
    <link href="<c:url value='/a/js/libs/bootstrap/3.3.2/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/media/css/jquery.dataTables.css'/>" rel="stylesheet" type="text/css" >
    <link href="<c:url value='/a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/extensions/Responsive/css/dataTables.responsive.css'/>" rel="stylesheet" type="text/css" >
    <!--<link href="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet" type="text/css" >-->


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="a/js/libs/bootstrap/3.3.2/plugins/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="a/js/libs/bootstrap/3.3.2/plugins/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    	h1{
    		font-size: 1.7em;
    	}
    	.header div{
    		padding-left: 0 !important;
    	} 
    	.imgLogo{
    		height: 2.5em;
		    margin-top: 1em;
    	}
        .text-left-important{
            text-align: left !important;
        }
     	 
    </style>
  </head>
  <body>
  
	<div class="container">
		<div class="header" id="divHeader">
			<div class="col-md-10 col-md-offset-1">
	        	<img src="<c:url value='/a/imagenes/logo_2015.png'/>" class="imgLogo">
			</div>
	    </div>
	    <div class="row">	
	        <div class="col-md-10 col-md-offset-1">
	        	<div>
	        		<h1>Búsqueda de registros</h1>
	        	</div> 
			    <div class="panel panel-primary">
				   <div class="panel-heading">Resultado de la consulta</div>
				  <div class="panel-body" style="overflow: hidden;">
				  	<div id="custom-search-input">
                          <div class="input-group col-md-6">
                              <input type="text" id="textName" name="textName" class="  search-query form-control" placeholder="Search" />
                              <span class="input-group-btn">
                                  <button class="btn btn-danger" type="button" id="btnBuscar" >
                                      <span class=" glyphicon glyphicon-search"></span>
                                  </button>
                              </span>
                              &nbsp;&nbsp;&nbsp;
                              <span class="input-group-btn">
                          		<button type="submit" class="btn btn-primary disabled" id="btnExport" >Exportar Excel</button>
                          		</span>
                          </div>
                         
                      </div>

				  	<table id="tableEjemplo" class="table-striped" cellspacing="0" width="100%"><!--table table-striped table-bordered-->
				        <thead>
				             <tr>
				             	<th><input id="select_all" name="select_all" value="1" type="checkbox"></th>
				                <th>line_number</th>
				                <th>play_name</th>
				                <th>speaker</th>
				                <th>speech_number</th>
				                <th>text_entry</th>
				                <th>line_number</th>
				                <th>play_name</th>
				                <th>speaker</th>
				                <th>speech_number</th>
				                <th>text_entry</th>
				            </tr>
				        </thead>
				    </table>
					
				  </div>
				</div><!--fin panel-->
				
	         </div><!--fin col-->
	    </div><!--fin row-->
		<footer class="footer text-center">
			<div class="col-md-10 col-md-offset-1">
				<p><small>&copy; 1997 - 2015 SUNAT Derechos Reservados</small></p>
			</div>
		</footer>
	</div><!--fin container--> 

    <script src="<c:url value='/a/js/libs/jquery/1.11.2/jquery.min.js'/>"></script>
    <script src="<c:url value='/a/js/libs/bootstrap/3.3.2/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/media/js/jquery.dataTables.min.js'/>" type="text/javascript" language="javascript" ></script>    
    <script src="<c:url value='/a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/extensions/Responsive/js/dataTables.responsive.js'/>" type="text/javascript" language="javascript" ></script>
    <!--<script src="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript" language="javascript" ></script>-->
    
    <script>
    var exportStatus = false;
    var checksSeleccionados = [];
    var checksDesmarcados = [];
	
    $(document).ready(function() {   	
    	var oTable = $('#tableEjemplo').dataTable();
    	var rows_selected = [];
    	var exportButton = $('#btnExport');
    	
		$('#textName').val("");
		
		var datatable2Rest = function(sSource, aoData, fnCallback, oSettings) {
			
			
			var start = oSettings._iDisplayStart;
			var finish = oSettings._iDisplayLength;
			var pageNum = (start == 0) ? 1 : (start / finish) + 1; // pageNum is 1 based
			
			var sortCol = oSettings._iSortCol_0;
			var sortDir = oSettings._sSortDir_0;
		
			var restParams = new Array();
			restParams.push({"name" : "start", "value" : start});
			restParams.push({"name" : "finish", "value" : finish });
			restParams.push({"name" : "page", "value" : pageNum });
			for ( var i = 0; i < aoData.length; i++) {
				restParams.push({"name" : aoData[i].name,"value" :  aoData[i].value});
			}
			//if we are searching by name, override the url and add the name parameter
			var url = sSource;
			
			//finally, make the request
			$.ajax({
				"dataType" : 'json',
				"type" : "GET",
				"url" : url,
				"data" : restParams,
				"success" : function(data) {
 				    //alert("Current page number: primero el ServerData");
					fnCallback(data);
				}
			});
		};
		 
		$('#btnBuscar').click(function() {
			var textNametoSearch = $('#textName').val();
			exportButton.removeClass('btn btn-primary disabled');
			exportButton.addClass('btn btn-primary');
			checksSeleccionados = [];
		    checksDesmarcados = [];
		    exportStatus = false;
		    rows_selected = [];
		    document.getElementById('select_all').checked = false; 
			
			$('#tableEjemplo').dataTable( {
		           	"bProcessing": true,
	   		     	"bServerSide": true,
	   		 		"bDestroy": true,
	   		 		"bFilter": false,
	   		 		"sEcho":1,
	   		 		"sScrollY": "500px",
				    "sScrollX": "100%",
				    "sScrollXInner": "150%",
				    "bScrollCollapse": true,
	   		 		"lengthMenu": [[100, 200, 300, 400], [100, 200, 300, 400]],
  	                "sAjaxSource": "${pageContext.request.contextPath}/data/speechBeanList",
  	           		"fnServerParams": function ( aoData ) {
    	             	aoData.push( { "name": "text", "value": textNametoSearch } );
	    	         },
	    	    	"fnServerData" : datatable2Rest,
	    	    	"language"   : {
    	    	        processing:     "Procesando...",
    	    	        lengthMenu:    "Mostrar _MENU_ registros",
    	    	        info:           "Mostrar _START_ hasta  _END_ en  _TOTAL_ de Registros",
    	    	        infoEmpty:      "No hay informacion disponnible",
    	    	        infoFiltered:   "",
    	    	        infoPostFix:    "",
    	    	        loadingRecords: "Cargando...",
    	    	        zeroRecords:    "No hay resultados para su busqueda",
    	    	        emptyTable:     "Tabla sin resultados",
    	    	        paginate: {
    	    	            first:      "Primero",
    	    	            previous:   "Anterior",
    	    	            next:       "Siguiente",
    	    	            last:       "Ultimo"
    	    	        }
    	    	    },
    	    	    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {

    	    	    	 var rowId = aData.line_number;
    	    	         
    	    	         if($.inArray(rowId, rows_selected) !== -1 ||  (exportStatus && ($.inArray(rowId, checksDesmarcados)=== -1))){
    	    	            $(nRow).find('input[type="checkbox"]').prop('checked', true);
    	    	            $(nRow).addClass('selected');
    	    	         }
    	    	    },    	    
  	                "aoColumns": [
					{
						    "mData":   "isExport",
						    render: function ( value, type, row ) {
						    	return '<input type="checkbox" onclick="almacenarChecks(this);" class="checkbox1" id="'+row.line_number+'"> ';
						    },
						    className: "select-checkbox",
						    orderable: false
					},
					{ "mData": "line_number",
						render: function ( value, type, row ) {
					    	return row.line_number +"-"+ row.speech_number;
					    }
					},
					{ "mData": "play_name" },
					{ "mData": "speaker" },
					{ "mData": "speech_number" },
					{ "mData": "text_entry" },
					{ "mData": "line_number" },
					{ "mData": "play_name" },
					{ "mData": "speaker" },
					{ "mData": "speech_number" },
					{ "mData": "text_entry" }
				]
  	        });
				
			}); 


		// Handle click on checkbox
		   $('#tableEjemplo tbody').on('click', 'input[type="checkbox"]', function(e){
		      var $row = $(this).closest('tr');

		      // Get row ID
		      var rowId = this.id;//data[0];

		      // Determine whether row ID is in the list of selected row IDs 
		      var index = $.inArray(rowId, rows_selected);

		      // If checkbox is checked and row ID is not in list of selected row IDs
		      if(this.checked && index === -1){
		         rows_selected.push(rowId);

		      // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
		      } else if (!this.checked && index !== -1){
		         rows_selected.splice(index, 1);
		      }

		      if(this.checked){
		         $row.addClass('selected');
		      } else {
		         $row.removeClass('selected');
		      }

		      // Update state of "Select all" control
		      updateDataTableSelectAllCtrl(oTable);

		      // Prevent click event from propagating to parent
		      e.stopPropagation();
		   });

		   // Handle click on table cells with checkboxes
		   oTable.on('click', 'tbody td, thead th:first-child', function(e){
		      $(this).parent().find('input[type="checkbox"]').trigger('click');
		   });

		   // Handle click on "Select all" control
		   $('#tableEjemplo thead input[name="select_all"]').on('click', function(e){
		      if(this.checked){
		         $('#tableEjemplo tbody input[type="checkbox"]:not(:checked)').trigger('click');
		      } else {
		         $('#tableEjemplo tbody input[type="checkbox"]:checked').trigger('click');
		      }

		      // Prevent click event from propagating to parent
		      e.stopPropagation();
		   });

		   // Handle table draw event
		   oTable.on('draw', function(){
		      // Update state of "Select all" control
		      updateDataTableSelectAllCtrl(oTable);
		   });
		    
		   // Handle form submission event 
		   $('#frm-tableEjemplo').on('submit', function(e){
		      var form = this;

		      // Iterate over all selected checkboxes
		      $.each(rows_selected, function(index, rowId){
		         // Create a hidden element 
		         $(form).append(
		             $('<input>')
		                .attr('type', 'hidden')
		                .attr('name', 'id[]')
		                .val(rowId)
		         );
		      });

		   });
		   
		   $('#btnExport').click(function() {
			   var textNametoSearch = $('#textName').val();
			   var selectall = $("#select_all")[0];
			   if (textNametoSearch!=null){
				   if ( selectall.checked && !selectall.indeterminate ){
					   //window.location.href = "${pageContext.request.contextPath}/data/downloadCSV?text="+textNametoSearch;
					   window.location.href = "<c:url value='/data/downloadCSV?text='/>"+textNametoSearch;
				   }
				   else {
					   if(exportStatus){
						   //exportar todos menos los exluidos
						   window.location.href = "${pageContext.request.contextPath}/data/deselectedToExportCSV?text="+textNametoSearch+"&desmarcados="+checksDesmarcados;
					   } else {
						   //exportar solo los seleccionados
						   window.location.href = "${pageContext.request.contextPath}/data/selectedToExportCSV?text="+textNametoSearch+"&seleccionados="+checksSeleccionados;
					   }
				   }
			   }
		   });
		   
		   $('#select_all').click(function(data){
			   
			   if(!data.target.checked){
				   exportStatus = false;
				   rows_selected = [];
				   checksSeleccionados = [];
				   checksDesmarcados = [];
				   
			   }else{
				   exportStatus = true;
			   }
		   });
    });
    
 //
	 function updateDataTableSelectAllCtrl(table){
	    var $table             = table.dataTable();//table.table().node();
	    var $chkbox_all        = $('tbody input[type="checkbox"]', $table);
	    var $chkbox_checked    = $('tbody input[type="checkbox"]:checked', $table);
	    var chkbox_select_all  = document.getElementById('select_all');
	
	    // If none of the checkboxes are checked
	    if($chkbox_checked.length === 0){
	       chkbox_select_all.checked = false;
	       if('indeterminate' in chkbox_select_all){
	          chkbox_select_all.indeterminate = false;
	       }
	
	    // If all of the checkboxes are checked
	    } else if ($chkbox_checked.length === $chkbox_all.length){
	       chkbox_select_all.checked = true;
	       if('indeterminate' in chkbox_select_all){
	          chkbox_select_all.indeterminate = false;
	       }
	
	    // If some of the checkboxes are checked
	    } else {
	       //chkbox_select_all.checked = true;
	       if('indeterminate' in chkbox_select_all){
	          chkbox_select_all.indeterminate = true;
	       }
	    }
	 }
 
 	function almacenarChecks(element){
 		 var indexs = $.inArray(element.id, checksSeleccionados);
 		 var indexd = $.inArray(element.id, checksDesmarcados);
 		
 		if (element.checked){
	 		checksSeleccionados.push(element.id);
	 		if (indexd !== -1){
	 			checksDesmarcados.splice(indexd, 1);
 			}
 		}else {
 			checksDesmarcados.push(element.id);
 			if (indexs !== -1){
 				checksSeleccionados.splice(indexs, 1);
 			}
 		}
 		
 	}
    </script>
	
  </body>
</html>

	
	