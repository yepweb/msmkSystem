<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>删除商家</title>
</head>


<body>
<table width="586" border="1" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      <th width="47" class="rounded-q4" scope="col">删除</th>
      <th width="23" class="rounded" scope="col">ID</th>
      <th width="45" class="rounded" scope="col">编号</th>
      <th width="139" class="rounded" scope="col">名字</th>
      <th width="102" class="rounded" scope="col">地址</th>
      <th width="107" class="rounded" scope="col">电话</th>
      <th width="77" class="rounded" scope="col">其他</th>
      
    </tr>
  </thead>

  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "select * from  business ";

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
      <td><a href='bus_del_sql.php?b_id=$row[0]'><img src='images/trash.png' alt='' title='' border='0' /></a></td>
      <td>$row[0]</td>
      <td>$row[1]</td>
      <td>$row[2]</td>
      <td>$row[3]</td>
      <td>$row[4]</td>
	  <td style='font-size:5px'>$row[5]</td>
      
    </tr>
	
	
	
	
	
	
	
	";   //显示数据  
 

mysql_close($conn);
?>
    
   
  
   
    
  </tbody>
</table>
</body>
</html>







