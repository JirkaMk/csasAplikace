$(function() {
	/* solving the active menu problem - pridava do menu listu z navbar.jsp
    tridu active */
	switch(menu) {
	
		case 'About Us': // porovnava se hodnat title z PageControlleru.java s touto hodnotou 
			$('#about').addClass('active'); // about odpovidajici id = 'about' z definice v navbar.jsp
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;				
		case 'CSAS ATM':
			$('#csasATMs').addClass('active');
			break;			
		default:
			//$('#listProducts').addClass('active');
		    $('#a_'+menu).addClass('active'); // menu, coz je category.getName() predavam jako objekt v pagecontroleru tride ModelandView 
		break;
	}

	// code for jquery dataTable
	// create a dataset
	// takle vypada v java scriptu rada
/*	var products = [  
	                
	                	['1', 'ABC'],
	                	['2', 'CYX'],
	                	['3', 'PQR'],
	                	['4', 'MNO'],
	                	['5', 'WVB'],
	                	['6', 'CFG'],
	                	['7', 'HIK'],
	                	['8', 'LMP']
	                	                
	                ]; */
	
	var $table = $('#productListTable'); // id tabulky definovane v listProducts.jsp 
	
	// execute the below code only where we have this table
	if($table.length) { //pokud nactu listProducts nacte se i tenhle kod..
		//console.log('Inside the table!');
		var jsonUrl = '';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			//jsonUrl urcena k importu JSON dat z odpovidajiciho kontroleru 
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
			
		$table.DataTable( {
			
			lengthMenu: [[3,5,10,-1], ['3', '5', '10', 'ALL']], // nastavuji pocet zaznamu na stranku
			pageLength: 5, 
			//predani dat z DB do tabulky
			ajax: {
				url: jsonUrl,
				dataSrc: '' // v "hlavicce" JSON neni nic
			},
			columns: [
			          {
			        	  //pridavam obrazky
			        	  data: 'code',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  
			        		  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
			        		  
			        	  }
			          },
			          {
			        	  data: 'name' // nazvy musi byt stejne jako nazvy prijmane v JSON objektu			        	  
			          },
			          {
			        	  data: 'brand'			        	  
			          },
			          {
			        	  data: 'unitPrice',
			        	  mRender: function(data, type, row) { // uprava format unitPrice
			        		  return data + ' CZK'
			        	  }
			          },
			          {
			        	  data: 'quantity'			        	  
			          },
			          {
			        	  data: 'id',
			        	  bSortable: false, // diky tomuhle rusim sort pro tuhle kategorii
			        	  mRender: function(data, type, row) {
			        		  
			        		  var str = '';
			        		  // prirazuji do tabulky tlacitka a odkazy URL 
			        		  str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;'; // 160 prida misto 
			        		  str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';			        		  
			        		  
			        		  return str;
			        		  
			        	  }
			        	  
			          }
			          ]
		});
	}
});