<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	        		<h1>Búsqueda de Productos</h1>
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

				  	<table id="sivepList" class="table-striped" cellspacing="0" width="100%"><!--table table-striped table-bordered-->
				        <thead>
				             <tr>
				             	<th><input id="select_all" name="select_all" value="1" type="checkbox"></th>
				                <th>Puerto Embarque</th>
				                <th>Nro</th>
				                <th>Canal</th>
				                <th>SPN</th>
				                <th>Producto</th>
				                <th>Marca</th>
				                <th>Modelo</th>
				                <th>Caracteristicas</th>
				                <th>Clase variedad</th>
				                <th>Material Composicion</th>
				                <th>Uso Aplicacion</th>
				                <th>Aro - Año</th>
				                <th>FOB</th>
				                <th>FOB - KG</th>
				                <th>Ajuste</th>
				                <th>FOB Unitario</th>
				                <th>Cantidad</th>
				                <th>Unidad</th>
				                <th>DAM</th>
				                <th>Item</th>
				                <th>Serie</th>
				                <th>Factura</th>
				                <th>Importador</th>
				                <th>Vendedor</th>
				                <th>Estado</th>
				                <th>Fec. Fact</th>
				                <th>Fec. Embar</th>
				                <th>Pais Origen</th>
				                <th>Pais Embar.</th>
				                <th>Otra Descripc.</th>
								<th>Otra Descr</th>
				                <th>Otra Descr</th>
				                <th>Cant. CC</th>
				                <th>Codigo C</th>
				                <th>Des Comp2</th>
				                <th>Cant. Cc</th>
				                <th>Cod C</th>
				                <th>Des Comp3</th>
				                <th>Cant. Cc</th>
				                <th>Cod A</th>
				                <th>Espesor</th>
				                <th>Des. Acab1</th>
				                <th>Cod. A</th>
				                <th>Des. Acab2</th>
				                <th>SPBQ</th>
				                <th>Cod C.</th>
				                <th>Des Comp1</th>
				                <th>Ancho</th>
				                <th>Grama</th>
				                <th>FOB Inicial</th>
				                <th>Nombre BQ</th>
				                <th>Descripcion BQ</th>
				                <th>Composicion BQ</th>
				                <th>Uso BQ</th>
				                
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
    	var oTable = $('#sivepList').dataTable();
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
			var url = sSource;
			
			$.ajax({
				"dataType" : 'json',
				"type" : "GET",
				"url" : url,
				"data" : restParams,
				"success" : function(data) {
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
			
			oTable.dataTable( {
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
  	                "sAjaxSource": "${pageContext.request.contextPath}/data/sivepBeanSearch",
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

    	    	    	 var rowId = aData.NUM_SERIE;
    	    	         
    	    	         if($.inArray(rowId, rows_selected) !== -1 ||  (exportStatus && ($.inArray(rowId, checksDesmarcados)=== -1))){
    	    	            $(nRow).find('input[type="checkbox"]').prop('checked', true);
    	    	            $(nRow).addClass('selected');
    	    	         }
    	    	    },    	    
  	                "aoColumns": [
					{
						    "mData":   "isExport",
						    render: function ( value, type, row ) {
						    	return '<input type="checkbox" onclick="almacenarChecks(this);" class="checkbox1" id="'+row.NUM_SERIE+'"> ';
						    },
						    className: "select-checkbox",
						    orderable: false
					},
					{ "mData": "DES_PUER_EMBAR" },
					{ "mData": "NUM_DECLARACION" },
					{ "mData": "COD_CANAL" },
					{ "mData": "NUM_PARARANCEL" },
					{ "mData": "DES_PRODUCBQ" },
					{ "mData": "DES_MARCA" },
					{ "mData": "DES_MODELO" },
					{ "mData": "DES_CARATIPO" },
					{ "mData": "DES_CLASEVARI" },
					{ "mData": "DES_MATERIALCOMP" },
					{ "mData": "DES_USOAPLIC" },
					{ "mData": "DES_AROANO" },
					{ "mData": "MTO_FOBITEM" },
					{ "mData": "MTO_FOBKG" },
					{ "mData": "MTO_AJUUNITARIO" },
					{ "mData": "MTO_FOBUNITARIO" },
					{ "mData": "CNT_UNI" },
					{ "mData": "COD_UNICOMER" },
					{ "mData": "DAM",
						render: function ( value, type, row ) {
					    	return row.NUM_CORRIV + " - "+ row.NUM_CORREDOC+ " - "+  row.COD_ADUANA+ " - "+  row.ANN_PRESEN+ " - "+  row.NUM_DECLARACION+ " - "+  row.NUM_SECITEM+ " - "+  row.MTO_FOBUNITARIO+ " - "+  row.COD_ESTVAL+ " - "+  row.COD_NATUTRANS;
					    }
					},
					{ "mData": "NUM_SECITEM" },
					{ "mData": "NUM_SERIE" },
					{ "mData": "NUM_FACT" },
					{ "mData": "NUM_DOCIMPORT",
						render: function ( value, type, row ) {
					    	return row.NUM_DOCIMPORT + " - "+ row.NOM_IMPORT;
					    }
					},
					{ "mData": "NOM_PROVE" },
					{ "mData": "COD_ESTMERC" },
					{ "mData": "FEC_FACT" },
					{ "mData": "FEC_EMBARQUE" },
					{ "mData": "COD_PAISORIGEN" },
					{ "mData": "COD_PAISEMBARQUE" },
					{ "mData": "DES_COM1" },
			        { "mData": "DES_COM2" },
			        { "mData": "DES_COM3" },
			        { "mData": "CNT_COMPOSICION1" },
		            { "mData": "COD_COMPOSICION2" },
		            { "mData": "DES_COMPOSICION2" },
		            { "mData": "CNT_COMPOSICION2" },
		            { "mData": "COD_COMPOSICION3" },
		            { "mData": "DES_COMPOSICION3" },
		            { "mData": "CNT_COMPOSICION3" },
		            { "mData": "COD_ACABADO1" },
		            { "mData": "NUM_ESPESOR" },
		            { "mData": "DES_ACABADO1" },
		            { "mData": "COD_ACABADO2" },
		            { "mData": "DES_ACABADO2" },
		            { "mData": "NUM_PARBQ" },
		            { "mData": "COD_CRITERIO" },
		            { "mData": "DES_COM1" },
		            { "mData": "NUM_ANCHO" },
		            { "mData": "NUM_GRAMAJE" }, 
		            { "mData": "MTO_FOBDECINI" },
		            { "mData": "NUM_BQ" },
		            { "mData": "DES_COMPBQ" },
		            { "mData": "DES_COMPBQ" },
		            { "mData": "DES_USOBQ" }
		            
		            
					
// 					{ "mData": "NUM_CORRIV" },
// 		            { "mData": "NUM_CORREDOC" },
// 		            { "mData": "COD_ADUANA" },
// 		            { "mData": "ANN_PRESEN" },
// 		            { "mData": "COD_REGIMEN" },
// 		            { "mData": "COD_MODALIDAD" },
// 		            { "mData": "FEC_DECLARACION" },
// 		            { "mData": "COD_TIPDOCIMPORT" },
// 		            { "mData": "IND_CONCLU" },
// 		            { "mData": "FEC_CONCLU" },
// 		            { "mData": "IND_IMPFREC" },
// 		            { "mData": "IND_GARANTIA" },
// 		            { "mData": "IND_GARANTIACONC" },
// 		            { "mData": "NUM_GARANTIA" },
// 		            { "mData": "COD_TIPOLIQUIDA" },
// 		            { "mData": "COD_ESTDR" },
// 		            { "mData": "COD_ORIGEN" },
// 		            { "mData": "COD_PUER_EMBAR" },
// 		            { "mData": "NUM_DOCTRANSP" },
// 		            { "mData": "COD_TIPOESTMERC" },
// 		            { "mData": "COD_PAISADQUI" },
// 		            { "mData": "MTO_FOBPROVIS" },
// 		            { "mData": "COD_TIPOVALFOB" },
// 		            { "mData": "IND_SENSIBLE" },
// 		            { "mData": "DES_COMER" },
// 		            { "mData": "OBS_OBS" },
// 		            { "mData": "COD_TIPDESCRMIN" }
// 		            { "mData": "IND_DESCRMIN" },
// 		            { "mData": "DES_BUSQUEDA" },
// 		            { "mData": "NUM_SECFACT" },
// 		            { "mData": "NUM_SECPROVE" },
// 		            { "mData": "COD_PAISPROVE" },
// 		            { "mData": "COD_NIVCOM" },
// 		            { "mData": "COD_CONDPROVE" },
// 		            { "mData": "COD_NATUTRANS" },
// 		            { "mData": "IND_VINCULADO" },
// 		            { "mData": "MTO_FOBDR" },
// 		            { "mData": "MTO_FOBCP" },
// 		            { "mData": "MTO_FOBDDR" },
// 		            { "mData": "IND_BQ" },
// 		            { "mData": "DES_INFORMBQ" },
// 		            { "mData": "COD_ADUANABQ" },
// 		            { "mData": "ANN_BQ" },
// 		            { "mData": "IND_BQCOM" },
// 		            { "mData": "NUM_SECVALORACT" },
// 		            { "mData": "COD_ESTVAL" },
// 		            { "mData": "FEC_GENVAL" },
// 		            { "mData": "COD_CRITERIO" },
// 		            { "mData": "COD_FUNCVAL" },
// 		            { "mData": "NOM_FUNCVAL" },
// 		            { "mData": "FEC_CARGASIS" },
// 		            { "mData": "IND_DEL" },
// 		            
				]
  	        });
				
			}); 


		// Handle click on checkbox
		   $('#sivepList tbody').on('click', 'input[type="checkbox"]', function(e){
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
		   $('#sivepList thead input[name="select_all"]').on('click', function(e){
		      if(this.checked){
		         $('#sivepList tbody input[type="checkbox"]:not(:checked)').trigger('click');
		      } else {
		         $('#sivepList tbody input[type="checkbox"]:checked').trigger('click');
		      }

		      // Prevent click event from propagating to parent
		      e.stopPropagation();
		   });

		   // Handle table draw event
		   oTable.on('draw', function(){
		      // Update state of "Select all" control
		      updateDataTableSelectAllCtrl(oTable);
		   });
		   
		   $('#btnExport').click(function() {
			   var textNametoSearch = $('#textName').val();
			   var selectall = $("#select_all")[0];
			   if (textNametoSearch!=null){
				   if ( selectall.checked && !selectall.indeterminate ){
					   //window.location.href = "${pageContext.request.contextPath}/data/downloadCSV?text="+textNametoSearch;
					   window.location.href = "<c:url value='/data/exportCSV?text='/>"+textNametoSearch;
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
	