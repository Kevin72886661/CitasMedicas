<%-- 
    Document   : slideshow_1
    Created on : 12-oct-2018, 9:57:24
    Author     : casa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Slideshow - Carousel</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, 
	initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        
</head>
<body>
	
	<div class="container">
		<div class="row ">
                        
			<div class="col-md-12">
				
				
				<div id="slideshow1" class="carousel slide" data-ride="carousel">
					<!-- Indicadores -->
                                        
					<ol class="carousel-indicators">
						<li data-target="#slideshow1" data-slide-to="0" class="active"></li>
						<li data-target="#slideshow1" data-slide-to="1"></li>
						<li data-target="#slideshow1" data-slide-to="2"></li>
					</ol>

					<!-- Contenedor de Slides -->
					<div class="carousel-inner">
						<div class="item active">
                                                    <img src="imagenes/img2.jpg" class="imagen" alt="">
							<div class="carousel-caption">
								
							</div>
						</div>

						<div class="item">
							<img src="imagenes/img1.jpg" alt="" class="imagen" >
							<div class="carousel-caption">
								
							</div>
						</div>

						<div class="item">
							<img src="imagenes/img3.jpg" alt="" class="imagen">
							<div class="carousel-caption">
								
							</div>
						</div>
					</div>

					<!-- Controles -->
					<a href="#slideshow1" class="left carousel-control" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left"  aria-hidden="true"></span>
					</a>

					<a href="#slideshow1" class="right carousel-control icon-prev" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
    

	
    <script src="JavaScript/jquery.js"></script>
    <script src="JavaScript/bootstrap.min.js"></script>
</body>
</html>
