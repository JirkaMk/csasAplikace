<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- pridani tag knihoven - soubor obsahuje kod s vyznamem v ramci Springu a JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<!-- mapuje se na dispatcher servlet, ktery odkazuje na zdroje s css -->
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!-- ucebni ucel -->

<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Moje CSAS aplikace</title>
</head>
<body>
   ${contextRoot} says - ${greeting}
</body>
</html> --%>

<!-- boostrap template -->
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Moje zkusebni aplikace - ${title}</title>

<!-- jednoduchy script slouzici ke zvyrazneni aktivni polozky -->
<script>
	window.menu = '${title}'; //konfiguraci menu provadim v myapp.js
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-custom-theme.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    
    <div class="wrapper"> <!-- trida wrapper obali cely zbytek ve vnitrku divu -->
    
	<!-- Navigation - vrchni lista, pritomna vzdy-->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<div class="content">
	<!-- Za pomoci JSTL a Springu nacte aktualni obsah (home page)jen pokud je userClickHome prommena rovna true-->
	<c:if test="${userClickHome == true}">
		<%@include file="home.jsp"%>
	</c:if>
	
	<!-- Sekce se nacte jen pokud uzivatel klikne na about-->
	<c:if test="${userClickAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>

	<c:if test="${userClickContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
    
    </div>
    
	<!-- Footer - zahlavi -->	
	<%@include file="./shared/footer.jsp"%>



	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	
	<!-- Vlastni javascript mimo sablonu -->
    <script src="${js}/myapp.js"></script>
    
    </div>
    
</body>

</html>
