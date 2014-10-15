<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addColumn('number', 'hidden');
        data.addRows([
		<c:forEach var="fruit" items="${fruitList}">               
		          ['${fruit.frName}', ${fruit.fcount}, ${fruit.f_id}],
		</c:forEach>          
        ]);

        // Set chart options
        var options = {'title':'How many Fruit available in Basket', 'width':400,'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));

        function selectHandler() {
          var selectedItem = chart.getSelection()[0];
          if (selectedItem) {
            var topping = data.getValue(selectedItem.row, 2);
            alert('The user selected ' + topping);
          }
        }

        google.visualization.events.addListener(chart, 'select', selectHandler);
        chart.draw(data, options);
      }

    </script>
  </head>
<body>
<h2>Google Chart + Spring MVC + MongoDB.</h2>

<form:form action="mongo/save" commandName="fruit">
	<form:hidden path="id"/>
	 <form:label path="f_id">FID:</form:label>
	<form:input path="f_id" />
	<form:label path="frName" >FName:</form:label>
	<form:input path="frName" />
	<form:label path="fcount" >FCount:</form:label>
	<form:input path="fcount" /> 
	<input type="submit" value="Submit"/>
</form:form>


<%-- <form action="mongo/save" method="post">
	<input type="hidden" name="id">
	<label for="title">FId</label>
	<input type="text" id="fid" name="title"/> 
	<label for="author">FName</label>
	<input type="text" id="fname" name="fname"/>
	<label for="author">FCount</label>
	<input type="text" id="fcount" name="fcount"/>
	<input type="submit" value="Submit"/>
</form> --%>

 <table style="border: 1px solid black;">
	 	<tr style="background-color: green;">
		<td>_ID</td> 
		<td>FruitID</td>
		<td>FruitName</td>
		<td>FruitCount</td>
		</tr>
	<c:forEach var="fruit" items="${fruitList}"> 
		<tr>
		<td>${fruit.id}</td> 
		<td>${fruit.f_id}</td>
		<td>${fruit.frName}</td>
		<td>${fruit.fcount}</td>
		</tr>
	</c:forEach>
</table>

<div id="chart_div" style="width:400; height:300"></div>
        
</body>
</html>