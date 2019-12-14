<?php


	$host = 'localhost';
	$user = 'root';
	$pwd = '';
	$db = 'buildings';
		
	$conn = mysqli_connect($host, $user, $pwd, $db);
	
	if (!$conn) {
		die("ERROR in connection: " . mysqli_connect_error());
	}
	$response = array();
	
	$sql_query = "select * from buildings_data";
	$result = mysqli_query($conn, $sql_query);
	
	if (mysqli_num_rows($result) > 0) {
		$response['success'] = 1;
		$buildings_data = array();
		while ($row = mysqli_fetch_assoc($result)) {
			array_push($buildings_data, $row);
		}
		$response['buildings_data'] = $buildings_data;
	}
	else {
		$response['success'] = 0;
		$response['message'] = 'No data';
	}
	
	echo json_encode($response);
	mysqli_close($conn);
	
?>