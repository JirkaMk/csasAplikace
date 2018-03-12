<div class="container">

	<div class="row">
    <!-- radu rozdelim na dva sloupce, pro sidebar a pro produkty -->

		<!-- Would be to display sidebar -->
		<!-- md-3 a md-9 znamena v boostropu pomer kolik z rady zabira ktery sloupec -->
		<div class="col-md-3"> 

			<%@include file="./shared/sidebar.jsp"%>


		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">


			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12"> <!-- rikam ze chci pouzit cely sloupec -->

					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = ''; //pridava do id kategorie prazdny String
						</script>
						
					    <!-- breadcrumb je predpripravena trida boostrapu - vice v poznamkach --> 
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>


						</ol>														
					</c:if>
					
					
					<c:if test="${userClickCategoryProducts == true}">
						<script>
						//pokud uzivatel klikne na kategorii uloz ID kategorie do promenne categoryId	
						window.categoryId = '${category.id}'; 
						</script>						
						
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
					

				</div>


			</div>

			<!-- Pridani tabulky -->
			<div class="row">
			
				<div class="col-xs-12">
				
					
					<table id="productListTable" class="table table-striped table-borderd">
					
					    <!-- definuji hlavicku -->
						<thead> 
						
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							
							</tr>
						
						</thead>
					
                        <!-- hlavicku vyplni JSON a JavaScript! -->
						<tfoot>
						
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							
							</tr>
						
						</tfoot>
					</table>
				
				</div>
			
			</div>


		</div>



	</div>






</div>