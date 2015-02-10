<?php
	
include '../api/connf/conn.php';
$a_name = $_POST['a_name'];
$a_pwd = $_POST['a_pwd'];



$sql = "INSERT INTO admin (a_name,a_pwd)VALUES ('$a_name',md5('$a_pwd'))";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "添加管理员成功";
else
	echo "账号已存在，请重新添加！";
mysql_close ( $conn );
?>