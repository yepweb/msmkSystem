

<?php
// 初始化session.

session_start();

$_SESSION = array();

if (isset($_COOKIE[session_name()])) {
setcookie(session_name(), '', time()-42000, '/');
}
// 最后彻底销毁session.
session_destroy();
header("Location:../../index.php");

?>