<!DOCTYPE html>

<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name = "viewport" content = "initial-scale = 1.0, user-scalable = no,  width=device-width">

	
    <title>SUNAT - Título Formulario</title>

    <!-- Bootstrap -->
    <link href="a/js/libs/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/media/css/jquery.dataTables.css" rel="stylesheet" type="text/css" >
    <link href="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet" type="text/css" >
    <!--<link href="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet" type="text/css" >-->


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
	        	<img src="a/imagenes/logo_2015.png" class="imgLogo">
			</div>
	    </div>
	    <div class="row">	
	        <div class="col-md-10 col-md-offset-1">
	        	<div>
	        		<h1>Título Formulario</h1>
	        	</div> 
			    <div class="panel panel-primary">
				   <div class="panel-heading">Resultado de la consulta</div>
				  <div class="panel-body">

				<table border="0" cellspacing="5" cellpadding="5">
				        <tbody><tr>
				            
				            <td>
				            	<input type="text" id="textName" name="textName">
				            </td>
				            <td>
				            	<button type="submit" class="btn btn-primary" id="btnBuscar" >Buscar</button>
				            </td>
				           
				        </tr>
				        
				    </tbody></table>

				  	<table id="tableEjemplo" class="display" cellspacing="0" width="100%"><!--table table-striped table-bordered-->
				        <thead>
				            <tr>
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
	
    <script src="a/js/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="a/js/libs/jquery/1.11.2/table2csv.js"></script> 
    <script src="a/js/libs/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/media/js/jquery.dataTables.min.js" type="text/javascript" language="javascript" ></script>    
    <script src="a/js/libs/bootstrap/3.3.2/plugins/datatables-1.10.7/extensions/Responsive/js/dataTables.responsive.js" type="text/javascript" language="javascript" ></script>
    
    <script>
    	$(document).ready(function() {   	
    		
    		$('#tableEjemplo_filter').hide();
    		$('#textName').val("");
    		 
   		    $('#btnBuscar').click(function() {
   		    	var textNametoSearch = $('#textName').val();
   		    	
       	    	$.getJSON('${pageContext.request.contextPath}/data/speechList',
       	    			{
       	    				text: textNametoSearch
       	    			},
       	    			function(data) {
       	    				$('#tableEjemplo').dataTable( {
       	    	            	"bprocessing": true,
       	   	     		     	"bserverSide": true,
       	   	     		 		"bDestroy": true,
       	   	     		 		"bFilter": false,
       	   	     		 		"lengthMenu": [[100, 200, 300, 400], [100, 200, 300, 400]],
       	    	                //"dataType": "json",
       	    	                "aaData": data,
       	    	                "aoColumns": [
									
       								{ "mData": "line_number" },
       								{ "mData": "play_name" },
       								{ "mData": "speaker" },
       								{ "mData": "speech_number" },
       								{ "mData": "text_entry" }
       								
       							]
       	    	        });
   				});
   			}); 
    		 
    	    
    	});
	  
	</script>
	
  </body>
</html>

	