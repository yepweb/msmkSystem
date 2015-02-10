<?php
//引入数据库配置文件	
include '../connf/conn.php';
//编辑sql语句
$sql = "
SELECT *
	FROM 
	zan
	JOIN meal
	ON zan.m_id = meal.m_id
	ORDER BY zan.z_zan DESC
	
	
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
   // $newData [$key] ['b_name'] = urlencode ( $value ['b_name'] );
    $newData [$key] ['m_name'] = urlencode ( $value ['m_name'] );
    $newData [$key] ['m_price'] = urlencode ( $value ['m_price'] );
    $newData [$key] ['m_other'] = urlencode ( $value ['m_other'] );
}
//输入json数据
echo urldecode ( json_encode ( $newData ) );
//关闭数据库连接
mysql_close ( $conn );