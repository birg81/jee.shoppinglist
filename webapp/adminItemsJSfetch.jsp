<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!doctype html>
<html lang="it">
<head>
<meta charset="utf-8"/>
<title>Shoppinglist DB (fetch)</title>
<meta
	name="viewport"
	content="width=device-width, shrink-to-fit=no, user-scalable=yes, initial-scale=1.0, maximum-scale=4.0, minimum-scale=0.5"
/>
<link
	rel="icon"
	type="image/png"
	href="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/60/emojidex/112/shopping-trolley_1f6d2.png"
/>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous"
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
};
const loadItems = async () => {
	document.querySelector('#listItems').innerHTML = 
		await fetch('./listItems.json')
			.then(res => res.json())
			.then(json => {
				console.log(json);
				let listStr = '';
				if(json.length > 0)
					for(const item of json)
						listStr += `
<li class="input-group mb-3">
	<a class="btn btn-outline-danger" href="delItem.jsp?id=\${item.id}">&#x274c;</a>
	<a class="btn btn-outline-warning" href="javascript:modifyItem(\${item.id}, '\${item.voce}')">&#x270d;</a>
	<div class="btn btn-outline">\${item.voce}</div>
</li>
						`.trim();
				else
					listStr = '<li>(lista vuota)</li>';
				return listStr;
			});
};
</script>
</head>
<body onload="loadItems()">
<form method="POST" action="./addItem.jsp">
<div class="input-group mb-3">
	<input type="submit" class="btn btn-outline-success" value="&#x2714;"/>
	<input type="text" class="form-control" name="voce" placeholder="inserisci voce"/>
</div>
</form>
<ul id='listItems'></ul>
</body>
</html>