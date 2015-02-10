<?php
//引入数据库配置文件	
include '../connf/conn.php';
//获取POST过来的值
$m_id = $_POST['m_id'];

//编辑sql语句

$sql = "
		UPDATE zan 
			SET z_cai = z_cai+1
			WHERE m_id = '$m_id'
			";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
if(@mysql_result($result,0)){
	echo "踩失败";
}else{
	echo "踩成功";

}
//关闭数据库连接
mysql_close ( $conn );