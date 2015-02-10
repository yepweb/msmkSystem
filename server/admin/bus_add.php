<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加商家</title>
</head>

<body>
</body>
</html>
<?php
//引入数据库配置文件	
include '../api/connf/conn.php';
//获取POST过来的值
$b_no = $_POST['b_no'];
$b_name = $_POST['b_name'];
$b_address = $_POST['b_address'];
$b_phone = $_POST['b_phone'];
$b_other = $_POST['b_other'];
//编辑sql语句
$sql = "INSERT INTO business (b_no,b_name,b_address,b_phone,b_other)VALUES ('$b_no','$b_name','$b_address','$b_phone','$b_other')";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
if(@mysql_result($result,0)){
	echo "增加失败";
}else{
	echo "增加成功";

}
//关闭数据库连接
mysql_close ( $conn );