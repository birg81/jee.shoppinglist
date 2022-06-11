<%@page import="model.VoceListaDAO, model.VoceLista, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="it">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<title>Shoppinglist DB</title>
<link
	rel="icon"
	type="image/png"
	href="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/60/emojidex/112/shopping-trolley_1f6d2.png"
/>
<script>
'use strict';
const modifyItem = (id, voceOld) => {
	let voce = prompt(`Inserisci il nuovo valore a \${voceOld}`, voceOld).trim();
	if(
		voce !== null && voce != '' &&
		voce.toLowerCase() != voceOld.toLowerCase()
	)
		document.location = `modifyItem.jsp?id=\${id}&voce=\${voce}`;
}
</script>
</head>
<body>
<form method="POST" action="./addItem.jsp">
<div class="input-group mb-3">
	<input type="submit" class="btn btn-outline-success" value="&#x2714;"/>
	<input type="text" class="form-control" name="voce" placeholder="inserisci voce"/>
</div>
</form>
<% ArrayList<VoceLista> listItems = VoceListaDAO.listItems(); %>
<% if(listItems.size() == 0) { %>
<p>lista vuota, inserire voci</p>
<% } else { %>
<ul>
<% for(VoceLista item : listItems) { %>
<li class="input-group mb-3">
	<a class="btn btn-outline-danger" href="delItem.jsp?id=<%= item.getId() %>">&#x274c;</a>
	<a class="btn btn-outline-warning" href="javascript:modifyItem(<%= item.getId() %>, '<%= item.getVoce() %>')">&#x270d;</a>
	<div class="btn btn-outline"><%= item.getVoce() %></div>
</li>
<% } %>
</ul>
<% } %>
</body>
</html>