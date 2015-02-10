<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title></title>
</head>


<body>
<table border="1" width="586" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      
      <th width="97" class="rounded" scope="col">编号</th>
      <th width="97" class="rounded" scope="col">名字</th>
      <th width="158" class="rounded" scope="col">所属餐厅</th>
      <th width="97" class="rounded" scope="col">价格</th>
      <th width="97" class="rounded" scope="col">其他</th>
      
    </tr>
  </thead>

  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "select * from  meal ";

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
      
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







