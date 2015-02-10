<?php
//建立数据库连接
include '../connf/conn.php';
//编辑sql语句
$query = "select *
 from business";
//执行SQL语句
$result = mysql_query ( $query ,$conn);
//循环 将查询的数据存入数组
while ( $row = mysql_fetch_assoc ( $result ) ) {
    $response [] = $row;
}
//使用Foreach遍历数组 同时使用urlencode处理 含有中文的字段
foreach ( $response as $key => $value ) {
    $newData[$key] = $value;
    //处理含有中文的字段
    $newData [$key] ['b_name'] = urlencode ( $value ['b_name'] );
    $newData [$key] ['b_address'] = urlencode ( $value ['b_address'] );
    $newData [$key] ['b_other'] = urlencode ( $value ['b_other'] );
    
}
//输入json数据
echo urldecode ( json_encode ( $newData ) );
//关闭数据库连接
mysql_close ( $conn );
?>