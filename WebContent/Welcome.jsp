<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.lang.Math, java.lang.String, java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Clasificación de pacientes afectados por asma</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
<meta name="keywords"
	content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
	Cufon.replace('h1', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h2', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h3', {
		textShadow : '1px 1px #000'
	});
	Cufon.replace('.back');
</script>
</head>

<body>

	<div class="wrapper">
		<h1>Clasificacion de pacientes afectados por asma</h1>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">

				<br>
				<br>
				
				<h3>
					Probabilidad Totes Urgencies:
					<s:property value="porcentajeTotesUrgencies" />
					%
				</h3>
				<br>
				<h3>
					Probabilidad Crisis Asma:
					<s:property value="porcentajeCrisisAsma" />
					%
				</h3>
				<br>
				<h3>
					Probabilidad Símptomes Intercrisis Asma:
					<s:property value="porcentajeSimtomesIntercrisisAsma" />
					%
				</h3>
			</div>


			<br>
			<br>
			<br>
			<script>
				document
						.write('<a href="' + document.referrer + '">Volver atrás</a>');
			</script>

		</div>
	</div>

</body>

<footer>
	<h3>
		Alexis Linard, Universite de Nantes<br> Ricard Gavalda,
		Universitat de Barcelona<br> Contact information: <a
			href="mailto:alexis.linard@etu.univ-nantes.fr">
			alexis.linard@etu.univ-nantes.fr </a>, <a
			href="mailto:alexis.linard@etu.univ-nantes.fr">
			gavalda@lsi.upc.edu </a> <br> version 0.1
	</h3>
</footer>

</html>