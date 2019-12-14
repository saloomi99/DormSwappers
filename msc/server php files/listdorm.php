<?php

require "connDorm.php";
$location = $_POST["location"];
$address = $_POST["address"];
$roomtype = $_POST["roomtype"];
$email = $_POST["email"];
$mysql_qry = "insert into buildings_data (location, address, roomtype, email) values ('$location','$address','$roomtype','$email')";

if ($conn->query($mysql_qry) === TRUE) {
echo "Building listed!";
}
else {
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();

?>