<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加用户</title>
</head>

<body>
</body>
</html>

<?php
	
include '../api/connf/conn.php';
$name = $_POST['u_name'];
$pwd = $_POST['u_pwd'];
$phone = $_POST['u_phone'];
$address = $_POST['u_address'];
$other = $_POST['u_other'];


$sql = "INSERT INTO user_ (u_name,u_pwd,u_phone,u_address,u_other)VALUES ('$name',md5('$pwd'),'$phone','$address','$other')";



$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "添加学生信息成功";
else
	echo "学生信息已存在，请重新输入！";
mysql_close ( $conn );
?>