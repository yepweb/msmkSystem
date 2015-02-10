<?php
include '../connf/conn.php';



$sql = "SELECT * FROM meal";

$result = mysql_query($sql);
echo mysql_num_rows($result);
mysql_close ( $conn );

?>