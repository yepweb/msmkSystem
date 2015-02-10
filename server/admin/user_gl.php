<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
</head>

<body>
用户列表：
<table border="1" width="586" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      <th scope="col" class="rounded-q4">删除</th>
      <th width="97" class="rounded" scope="col">编号</th>
      <th width="97" class="rounded" scope="col">姓名</th>
      <th width="158" class="rounded" scope="col">电话</th>
      <th width="97" class="rounded" scope="col">地址</th>
      <th width="97" class="rounded" scope="col">备注</th>
      
      
    </tr>
  </thead>
 
  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "select * from  user_ ";

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
      <td><a href='user_del_sql.php?u_id=$row[0]'><img src='images/trash.png' alt='' title='' border='0' /></a></td>
      <td>$row[0]</td>
      <td>$row[1]</td>
      <td>$row[3]</td>
      <td>$row[4]</td>
	  <td>$row[5]</td>
      
      
    </tr>
	
	
	
	
	
	
	
	";   //显示数据  
 

mysql_close($conn);
?>
    
   
  
   
    
  </tbody>
</table>
	
    
    添加用户：
	<form action="user_add.php" method="post">
	用户名:<input type="text" name="u_name"/><br/>
	用户密码:<input type="password" name="u_pwd"/><br/>
    电话:<input type="text" name="u_phone"/><br/>
    地址:<input type="text" name="u_address"/><br/>
    备注:<input type="text" name="u_other"/><br/>
	<input type="submit" value="增加用户"/>
	</form><br/>
</body>
</html>
