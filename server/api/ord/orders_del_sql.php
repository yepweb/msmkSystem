<?php

include '../connf/conn.php';
$o_id = $_POST['o_id'];

$sql = "DELETE FROM orders WHERE o_id = $o_id";

$result = mysql_query($sql,$conn);
if(mysql_affected_rows()>0)
	echo "ture";
else
	echo "false";