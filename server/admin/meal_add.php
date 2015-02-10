<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加餐品</title>
</head>

<body>
</body>
</html>
<?php
if ($_FILES["file"]["error"] > 0)
  {
  echo "Error: " . $_FILES["file"]["error"] . "<br />";
  }
else
  {
	
  }
  
  
  
  if ((($_FILES["file"]["type"] == "image/gif")
|| ($_FILES["file"]["type"] == "image/jpeg")
|| ($_FILES["file"]["type"] == "image/pjpeg"))
&& ($_FILES["file"]["size"] < 20000))
  {
  if ($_FILES["file"]["error"] > 0)
    {
    echo "Return Code: " . $_FILES["file"]["error"] . "<br />";
    }
  else
    {
	


    if (file_exists("../upload/" . $_FILES["file"]["name"]))
      {
      echo $_FILES["file"]["name"] . " 文件已经存在 ";
      }
    else
      {
      move_uploaded_file($_FILES["file"]["tmp_name"],
      "../upload/" . $_FILES["file"]["name"]);
      $src = $_FILES["file"]["name"];
	 
	
      }
    }
  }
else
  {
  echo "Invalid file";
  }
?>
<?php

//引入数据库配置文件	
include '../api/connf/conn.php';
//获取POST过来的值

$m_name = $_POST['m_name'];
$b_id = $_POST['b_id'];
$m_price = $_POST['m_price'];
$m_other = $_POST['m_other'];
//编辑sql语句
$sql = "INSERT INTO meal (m_name,b_id,m_price,m_other,m_img)VALUES ('$m_name','$b_id','$m_price','$m_other','../upload/$src')";
//执行sql语句
$result = mysql_query($sql,$conn);
//输入执行后的结果
if(mysql_affected_rows()>0)
	echo "添加餐品信息成功";
else
	echo "餐品信息已存在，请重新输入！";
//关闭数据库连接
mysql_close ( $conn );