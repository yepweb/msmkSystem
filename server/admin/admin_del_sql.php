<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>删除管理员</title>
</head>

<body>
</body>
</html>


<?php
	
include '../api/connf/conn.php';
$a_id = $_GET['a_id'];

$sql = "DELETE FROM admin WHERE a_id = $a_id";

$result = mysql_query($sql,$conn);
if(@mysql_result($result,0)){
	echo "删除失败";
}else{
	echo "删除成功";

}