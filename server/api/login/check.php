<?php
include '../connf/conn.php';
$n = $_POST['u_name'];
$p = $_POST['u_pwd'];
$sql = "select * from  user_ where u_name='$n' and u_pwd=md5('$p')";

$result = mysql_query($sql,$conn);
if(@mysql_result($result,0)){
	echo "true";
	session_start();
	$_SESSION['user'] = $n;
	

}else{
	echo "false";

}

