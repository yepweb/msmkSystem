<?php
	session_start();
	if(!isset($_SESSION['user'])){
	echo 'fail';
	exit();
	}else {
		
		echo $_SESSION['user'];
		
	}
?>