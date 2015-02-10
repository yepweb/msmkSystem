<?php
	header("Content-type: text/html; charset=utf-8");
	session_start();
	if(!isset($_SESSION['user'])){
	echo "请你先登陆<a href=login.html>登陆</a>";
	exit();
	}else {
		
	}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理界面</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript" src="style/jquery.min.js"></script>

<script type="text/javascript" src="style/ddaccordion.js"></script>

<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>
<script type="text/javascript" language="javascript">   
function iFrameHeight() {   
var ifm= document.getElementById("iframepage");   
var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
if(ifm != null && subWeb != null) {
   ifm.height = subWeb.body.scrollHeight;
}   
}   
</script>
<script src="style/jquery.jclock-1.2.0.js.txt" type="text/javascript"></script>
<script type="text/javascript" src="style/jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
	
</script>
<script type="text/javascript">
function SetWinHeight(obj) 
{ 
var win=obj; 
if (document.getElementById) 
{ 
if (win && !window.opera) 
{ 
if (win.contentDocument && win.contentDocument.body.offsetHeight) 
win.height = win.contentDocument.body.offsetHeight; 
else if(win.Document && win.Document.body.scrollHeight) 
win.height = win.Document.body.scrollHeight; 
} 
} 
} 
</script>

<script type="text/javascript">
$(function($) {
    $('.jclock').jclock();
});
</script>

<script language="javascript" type="text/javascript" src="style/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="style/niceforms-default.css" />

</head>
<body>
<div id="main_container">

	<div class="header">
    <div class="logo"><a href="#"><img src="images/logo.jpg" alt="" width="222" height="60" title="" border="0" /></a></div>
    
    <div class="right_header">欢迎：
    <?php
	//	session_start();
    	echo $_SESSION['user'];
    ?>
     ,<a href="logout.php" class="logout">退出</a></div>
    <div class="jclock"></div>
    </div>
    
    <div class="main_content">
      <div class="center_content">  
        
        
        
        <div class="left_content">
          <div class="sidebarmenu">
            
            <a class="menuitem submenuheader" href="">餐品管理</a>
              <div class="submenu">
                    <ul>
                    <li><a href="meal_list.php" target="rightframe">显示餐品</a></li>
                    <li><a href="meal_add.html"  target="rightframe">添加餐品</a></li>
                    <li><a href="meal_del.php" target="rightframe">删除餐品</a></li>
                    <li></li>
                    <li></li>
                    </ul>
            </div>
            <a class="menuitem submenuheader" href="" >订单管理</a>
                <div class="submenu">
                    <ul>
                    <li><a href="orders_list.html" target="rightframe">查询订单</a></li>
                    <li><a href="orders_list_all_del.php" target="rightframe">删除订单</a></li>
                    <li><a href="orders_list_all.php" target="rightframe">所有订单</a></li>
                    <li></li>
                    <li></li>
                    </ul>
                </div>
            <a class="menuitem submenuheader" href="">用户管理</a>
                <div class="submenu">
                    <ul>
                    <li><a href="user_gl.php" target="rightframe">学生管理</a></li>
                    <li><a href="admin_gl.php" target="rightframe">管理员</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    </ul>
                </div>
            <a class="menuitem submenuheader" href="">新闻通知</a>
            	 <div class="submenu">
                    <ul>
                    <li><a href="news_list.php" target="rightframe">查询新闻</a></li>
                    <li><a href="news_add.html" target="rightframe">增加新闻</a></li>
                    <li><a href="news_del.php" target="rightframe">删除新闻</a></li>
                    <li></li>
                    <li></li>
                    </ul>
                </div>
            <a class="menuitem submenuheader" href="">商家管理</a>
            	 <div class="submenu">
                    <ul>
                    <li><a href="bus_list.php" target="rightframe">商家列表</a></li>
                    <li></li>
                    <li><a href="bus_del.php" target="rightframe">删除商家</a></li>
                    <li><a href="bus_add.html" target="rightframe">增加商家</a></li>
                    <li></li>
                    </ul>
                </div>
                
            <a class="menuitem submenuheader" href="">评论管理</a>
            <div class="submenu">
                    <ul>
                    <li><a href="eva_list_del.php" target="rightframe">全部评论</a></li>
                    <li></li>
                    <li></li>
                    <li><a href="zan_list_del.php" target="rightframe">赞踩管理</a></li>
                    <li></li>
                    </ul>
                </div>
                
            <a class="menuitem_red" href="">功能拓展</a>
                    
          </div>
            
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">暂无信息
                  <p>&nbsp;</p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
        </div>  
    
    <div class="right_content">            
       
    <h2><iframe  id="iframepage" name="rightframe" frameBorder=0 scrolling=no width="100%" onLoad="iFrameHeight()" ></iframe>&nbsp;</h2>
    </div><!-- end of right content-->
            
                    
</div>   <!--end of center content -->               
                    
                    
    
    
    <div class="clear"></div>
    </div> <!--end of main content-->
	
    
    <div class="footer">
    
    	<div class="left_footer">IN ADMIN PANEL | Powered by <a href="http://indeziner.com">ZZDX</a></div>
    	<div class="right_footer"><a href="http://indeziner.com"><img src="images/logo.jpg" alt="" width="59" height="20" title="" border="0" /></a></div>
    
    </div>

</div>		
</body>
</html>