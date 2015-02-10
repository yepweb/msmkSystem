<?php
	
include '../api/connf/conn.php';
$e_id = $_GET['e_id'];

$sql = "DELETE FROM evaluate WHERE e_id = $e_id";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "删除信息成功";
else
	echo "删除信息失败！";