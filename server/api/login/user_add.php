<?php
	
include '../connf/conn.php';
$name = $_POST['u_name'];
$pwd = $_POST['u_pwd'];
$phone = $_POST['u_phone'];
$address = $_POST['u_address'];
$other = $_POST['u_other'];


$sql = "INSERT INTO user_ (u_name,u_pwd,u_phone,u_address,u_other)VALUES ('$name',md5('$pwd'),'$phone','$address','$other')";



$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0){
	echo "true";
	header("Location:../../index.php");	
}
else
	echo "false";
mysql_close ( $conn );
?>