<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>删除用户</title>
</head>

<body>
</body>
</html>


<?php
	
include '../api/connf/conn.php';
$u_id = $_GET['u_id'];

$sql = "DELETE FROM user_ WHERE u_id = $u_id";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows())
echo "sql执行成功";
else
echo "sql执行失败";