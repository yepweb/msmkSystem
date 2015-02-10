<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>删除订单</title>
</head>

<body>
</body>
</html>


<?php
	
include '../api/connf/conn.php';
$o_id = $_GET['o_id'];

$sql = "DELETE FROM orders WHERE o_id = $o_id";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "成功删除订单";
else
	echo "删除失败！";