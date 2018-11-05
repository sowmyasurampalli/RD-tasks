<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>


<body>
	<div class="row">
		<div class="col-md-6">
			<pre>			
				<form id="menuForm" action="">
				<div id="park">
					<input type="radio" name="menu" value="1"> 1.Park the vehicle
				</div>
				<div id="unpark">
					<input type="radio" name="menu" value="2"> 2.Unpark the vehicle 
				</div>	
				<div id="common">
				    <select id = "parkingarea">
                        <option value="epam">EPAM</option>
                        <option value="synchrony">SYNCHRONY</option>
                        <option value="statestreet">STATESTREET</option>
                    </select>
				    Enter vehicle ID: <input type="text" id="vehicle">
					<button type="submit" value="Submit">Submit</button>
				</div>
				</form>
			
			
			</pre>

		</div>

		<script>
		function getParking() {
            $.get("GetParkingMap", function(data, status) {
                $('#vehicleMap').empty();
                for (i = 0; i < data.length; i++) {
                    $('#vehicleMap').append(
                            "<tr>" + "<td>" + data[i].slotNumber + "</td>"
                                    + "<td>" + data[i].vehicle + "</td>"
                                    + "</tr>");
                }
            });
            return false;
        }
		<%
        if(request.getAttribute("typeOfadmin").equals("display")){
            out.print("getParking()");
        }
        
        %>
		
		$('#menuForm').on('submit',process);		
		function process(){
			console.log("posted");
			alert("parkingServlet");
			$.post("ParkingServlet", {menu:$("input[name='menu']:checked").val(),
				vehicle:$("#vehicle").val(),
				parkingarea: $("#parkingarea").val()},function(data, status){
				
			});
			return false;
			
		}
		
		</script>

		<div class="col-md-6" id="display">
			<input type="text" id="yoursearchinput">
			<table id="vehicleMap">
				<tr>
					<td>Vehicle number</td>
					<td>Slot number</td>
				</tr>
			</table>
		</div>
		<script>
       
			document.getElementById("unpark").style.display =
		<%if (request.getAttribute("typeOfadmin").equals("unparking"))
				out.print("'block'");
			else
				out.print("'none'");%>
			document.getElementById("park").style.display =
		<%if (request.getAttribute("typeOfadmin").equals("parking"))
				out.print("'block'");
			else
				out.print("'none'");%>
			document.getElementById("display").style.display =
		<%if (request.getAttribute("typeOfadmin").equals("display"))
				out.print("'block'");
			else
				out.print("'none'");%>
			document.getElementById("common").style.display =
		<%if (request.getAttribute("typeOfadmin").equals("display"))
				out.print("'none'");
			else{out.print("'block'");			
			}
				%>
				
			
		</script>
	</div>
</body>
</html>
