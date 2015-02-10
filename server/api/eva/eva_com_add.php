<?php
//引入数据库配置文件	
include '../connf/conn.php';
//获取POST过来的值
$m_id = $_POST['m_id'];
$e_comment = $_POST['e_comment'];
//编辑sql语句
$sql = "INSERT INTO evaluate (m_id,e_comment)VALUES ('$m_id','$e_comment')";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
if(@mysql_result($result,0)){
	echo "评论失败";
}else{
	echo "评论成功";

}
//关闭数据库连接
mysql_close ( $conn );