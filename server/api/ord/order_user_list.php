<?php
//引入数据库配置文件	
include '../connf/conn.php';
//获取POST过来的值
$u_name = $_POST['u_name'];

//编辑sql语句
$sql = "
SELECT o_id,meal.m_id
	FROM orders
	JOIN user_
	ON orders.u_name = user_.u_name
	JOIN meal
	ON orders.m_id = meal.m_id 
	where orders.u_name = '$u_name'
	
	";
	
	/*
	JOIN user_
	ON orders.u_name = user_.u_name
	JOIN meal
	ON orders.m_id = meal.m_id
	WHERE orders.u_name = '张三'
	*/
//执行sql语句
$result = mysql_query($sql,$conn);

//输入执行后的结果
while ( $row = mysql_fetch_assoc ( $result ) ) {
    $response [] = $row;
}
//使用Foreach遍历数组 同时使用urlencode处理 含有中文的字段
foreach ( $response as $key => $value ) {
    $newData[$key] = $value;
    
}
//输入json数据
echo urldecode ( json_encode ( $newData ) );
//关闭数据库连接
mysql_close ( $conn );