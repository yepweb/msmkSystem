<?php
include '../api/connf/conn.php';
$n = $_POST['a_name'];
$p = md5($_POST['a_pwd']);
$sql = "select * from  admin where a_name='$n' and a_pwd='$p'";

$result = mysql_query($sql,$conn);
if(@mysql_result($result,0)){
	//账户名和密码通过数据库验证成功后.....
		
	//写入session，保存用户名
	session_start();
	$_SESSION['user'] = $n;
	//跳转到管理界面
	header("Location:index-digital.php");
	
	
}else{
	//账户名和密码错误提示
	echo "<script>alert('你的账户名和密码错误，请重新输入');window.location.href='index.html';</script>";

}