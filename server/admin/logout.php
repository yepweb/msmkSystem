<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退出操作</title>
</head>


<body>
退出成功！<a href="index.html">返回首页</a>
</body>
</html>



<?php
// 初始化session.
session_start();

$_SESSION = array();

if (isset($_COOKIE[session_name()])) {
setcookie(session_name(), '', time()-42000, '/');
}
// 最后彻底销毁session.
session_destroy();

?>