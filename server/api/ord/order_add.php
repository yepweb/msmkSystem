<?php
//引入数据库配置文件	
include '../connf/conn.php';
//获取POST过来的值
$u_name = $_POST['u_name'];
$m_id = $_POST['m_id'];

//编辑sql语句

$sql = "
	INSERT INTO orders (m_id,u_name)VALUES('$m_id','$u_name')
			
			";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
if(@mysql_result($result,0)){
	echo "订单失败";
}else{
	echo "订单成功";

}
//关闭数据库连接
mysql_close ( $conn );