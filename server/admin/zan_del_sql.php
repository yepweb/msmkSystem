<?php
	
include '../api/connf/conn.php';
$z_id = $_GET['z_id'];

$sql = "DELETE FROM zan WHERE z_id = $z_id";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "删除信息成功";
else
	echo "删除信息失败！";