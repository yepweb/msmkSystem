<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>评论管理</title>
</head>


<body>
<table width="586" border="1" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      <th scope="col" class="rounded-q4">删除</th>
      <th width="97" class="rounded" scope="col">编号</th>
      <th width="97" class="rounded" scope="col">餐名</th>
      <th width="158" class="rounded" scope="col">评论</th>
      
      
      
    </tr>
  </thead>
  
  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "SELECT e_id,m_name,e_comment 
	FROM 
	evaluate
	JOIN meal
	ON evaluate.m_id = meal.m_id
	";
	

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
       <td><a href='eva_del_sql.php?e_id=$row[0]'><img src='images/trash.png' alt='' title='' border='0' /></a></td>
      <td>$row[0]</td>
      <td>$row[1]</td>
      <td>$row[2]</td>
  
      
      
    </tr>
	
	
	
	
	
	
	
	";   //显示数据  
 

mysql_close($conn);
?>
    
   
  
   
    
  </tbody>
</table>
</body>
</html>







