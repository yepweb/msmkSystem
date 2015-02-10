<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员管理</title>
</head>

<body>

管理员列表：
<table border="1" width="586" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      <th width="90" class="rounded-q4" scope="col">删除</th>
      <th width="158" class="rounded" scope="col">编号</th>
      <th width="192" class="rounded" scope="col">账户名</th>
         
      
    </tr>
  </thead>

  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "select * from  admin ";

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
      <td><a href='admin_del_sql.php?a_id=$row[0]'><img src='images/trash.png' alt='' title='' border='0' /></a></td>
      <td>$row[0]</td>
      <td>$row[1]</td>
     
      
      
    </tr>
	
	
	
	
	
	
	
	";   //显示数据  
 

mysql_close($conn);
?>
    
   
  
   
    
  </tbody>
</table>


增加管理员：
	<form action="admin_add.php" method="post">
	管理员账号:<input type="text" name="a_name"/><br/>
	密码:<input type="password" name="a_pwd"/><br/>
	<input type="submit" value="增加管理员"/>
	</form><br/>
</body>
</html>
