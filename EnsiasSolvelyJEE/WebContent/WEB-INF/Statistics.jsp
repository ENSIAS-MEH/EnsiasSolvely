<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolevly | Statistics</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Statistics.css">
		
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="btnContainer">
			<section id="buttons">
				<a class="btn-1" id="BuildingStatistics" href="RecupererReport?reporting=4" style="width: 25%; height:28px;">Committee 'Building' Statistics</a>
				<a class="btn-1" id="VariousStatistics" href="RecupererReport?reporting=6" style="width: 25%; height:28px;">Committee 'Various' Statistics</a>
				<a class="btn-1" id="DistributionStatistics" href="RecupererReport?reporting=5" style="width: 25%; height:28px;">Problems Distribution Statistics</a>
				<a class="btn-1" id="GlobalStatistics" href="RecupererReport?reporting=7" style="width: 25%; height:28px;">Global Statistics</a>
			</section>
		</div>
		
		
		<%@ include file="footer.jsp" %>
	</body>
</html>