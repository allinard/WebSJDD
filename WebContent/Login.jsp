<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>

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
		<h2>Entrar los datos de los pacientes (los campos pueden
			permanecer vacios)</h2>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">


				
				<s:form action="login.action" method="post" class="login active">
				
			    	 <s:checkbox name="visitesUrgencies" fieldValue="true" value="false" label="Visites a urgenciès"/>
					 <s:checkbox name="simptomesIntercrisisAsma" fieldValue="true" value="false" label="Símptomes intercrisis asma"/>
				
					<table>

						<s:iterator value="listaCampos" var="campo">
							<s:if test="#campo == 'fechaini'">
								<tr>
									<td><s:textfield name="%{#campo}" label="%{#campo}" value="01/01/2014" size="600" /></td>
								</tr>
							</s:if>
							<s:else>
								<tr>
									<td><s:textfield name="%{#campo}" label="%{#campo}" value="?" size="600" /></td>
								</tr>
							</s:else>
						</s:iterator>

					</table>
					<s:submit method="execute" key="label.cestparti" align="center" />
				</s:form>



			</div>
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