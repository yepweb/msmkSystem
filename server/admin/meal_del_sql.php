<?php
	//引入数据库配置文件	
include '../api/connf/conn.php';
//获取POST过来的值
$m_id = $_GET['m_id'];

$sql = "DELETE  FROM meal WHERE m_id = $m_id ";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
if(@mysql_result($result,0)){
	echo "ok";
}else{
	echo "删除成功";

}
//关闭数据库连接
mysql_close ( $conn );
		
?>