<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.lang.Math, java.lang.String, java.util.List" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
        <title>Est-ce que ce tweet est drôle ?</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
        <meta name="keywords" content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript"/>
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<script src="js/cufon-yui.js" type="text/javascript"></script>
		<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
    </head>
 
	<body>

		<div class="wrapper">
			<h1>Recuperation de tweets droles</h1>
			<h2>Entrer un hashtag ou un utilisateur, et recuperer les tweets droles (exemple : <span>@vdm</span> ou <span>#ivg</span>)</h2>
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">	

					<h3><s:property value="username"/></h3>
					<h2><span><s:property value="totalTrue"/></span> tweets droles trouves contre <span><s:property value="totalFalse"/></span> pas drole (non presentes) </h2>
					
					<table>
				        <s:iterator value="listeTweets">
				                <tr>
				                        <td><s:property value="user"/></td>
				                        <td><s:property value="text"/></td>
				                </tr>
				        </s:iterator>
					</table>
					
				</div>


				<br>
				<h3>Redo?</h3>
				<div id="form_wrapper" class="form_wrapper">	

					<s:actionerror />
					<s:form action="login.action" method="post" class="login active">
					    <s:textfield name="username" key="label.requete" size="20" />
					    <s:submit method="execute" key="label.cestparti" align="center" />
					</s:form>
					
				</div>

			</div>
		</div>

</body>
</html>