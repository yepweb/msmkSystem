<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>订单列表</title>
</head>


<body>
<table border="1" width="586" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      <th scope="col" class="rounded-q4">删除</th>
      <th width="97" class="rounded" scope="col">编号</th>
      <th width="97" class="rounded" scope="col">学生姓名</th>
      <th width="158" class="rounded" scope="col">地址</th>
      <th width="97" class="rounded" scope="col">电话</th>
      <th width="97" class="rounded" scope="col">餐品名字</th>
      
    </tr>
  </thead>

  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "
	SELECT o_id,user_.u_name,u_address,u_phone,meal.m_name
	FROM orders
	JOIN user_
	ON orders.u_name = user_.u_name
	JOIN meal
	ON orders.m_id = meal.m_id

";

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
      <td><a href='orders_del_sql.php?o_id=$row[0]'><img src='images/trash.png' alt='' title='' border='0' /></a></td>
      <td>$row[0]</td>
      <td>$row[1]</td>
      <td>$row[2]</td>
      <td>$row[3]</td>
      <td>$row[4]</td>
      
    </tr>
	
	
	
	
	
	
	
	";   //显示数据  
 

mysql_close($conn);
?>
    
   
  
   
    
  </tbody>
</table>
</body>
</html>







