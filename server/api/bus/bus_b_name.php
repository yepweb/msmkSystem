<?php
//引入数据库配置文件	
include '../connf/conn.php';
//获取POST过来的值
$b_id = $_POST['b_id'];

//编辑sql语句
$sql = "
SELECT b_name FROM business
	WHERE b_id = $b_id
	
	";
	
	
//执行sql语句
$result = mysql_query($sql,$conn);

//输入执行后的结果
while ( $row = mysql_fetch_assoc ( $result ) ) {
    $response [] = $row;
}
//使用Foreach遍历数组 同时使用urlencode处理 含有中文的字段
foreach ( $response as $key => $value ) {
    $newData[$key] = $value;
    //处理含有中文的字段
    $newData [$key] ['b_name'] = urlencode ( $value ['b_name'] );
  
}
//输入json数据
echo urldecode ( json_encode ( $newData) );
//关闭数据库连接
mysql_close ( $conn );