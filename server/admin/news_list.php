<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>新闻通知</title>
</head>


<body>
<table border="1" width="586" id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <thead>
    <tr>
      
      <th width="97" class="rounded" scope="col">编号</th>
      <th width="97" class="rounded" scope="col">标题</th>
      <th width="158" class="rounded" scope="col">内容</th>
      <th width="97" class="rounded" scope="col">时间</th>
      
      
    </tr>
  </thead>

  <tbody>
  
          <?php

include '../api/connf/conn.php';

$sql = "select * from  news ";

$rs = mysql_query($sql,$conn);



 
while($row = mysql_fetch_row($rs)) 
	echo "
	
	<tr>
      
      <td>$row[0]</td>
      <td>$row[1]</td>
      <td style='font-size:5px'>$row[2]</td>
      <td>$row[3]</td>
      
      
    </tr>
	
	
	
	
	
	
	
	";   //显示数据  
 

mysql_close($conn);
?>
    
   
  
   
    
  </tbody>
</table>
</body>
</html>







