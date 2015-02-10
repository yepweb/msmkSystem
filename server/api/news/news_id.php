<?php
//引入数据库配置文件	
include '../connf/conn.php';
//获取POST过来的值
$n_id = $_POST['n_id'];

//编辑sql语句

$sql = "
		SELECT * from news
	WHERE n_id = $n_id";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
//输入执行后的结果
while ( $row = mysql_fetch_assoc ( $result ) ) {
    $response [] = $row;
}
//使用Foreach遍历数组 同时使用urlencode处理 含有中文的字段
foreach ( $response as $key => $value ) {
    $newData[$key] = $value;
    //处理中文字段
     $newData [$key] ['n_title'] = urlencode ( $value ['n_title'] );
	   $newData [$key] ['n_content'] = urlencode ( $value ['n_content'] );
}
//输入json数据
echo urldecode ( json_encode ( $newData ) );
//关闭数据库连接
mysql_close ( $conn );