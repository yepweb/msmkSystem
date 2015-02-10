<?php
	
include '../api/connf/conn.php';
$title = $_POST['n_title'];
$content = $_POST['n_content'];
$sql = "INSERT INTO news (n_title,n_content,n_time)VALUES ('$title','$content',UNIX_TIMESTAMP(NOW()))";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "添加新闻信息成功";
else
	echo "新闻信息添加失败！";