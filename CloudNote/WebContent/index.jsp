<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
if(session.getAttribute("user_id")==null) {
	response.sendRedirect("login.jsp");
}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>云笔记</title>
        <link type="text/css" rel="stylesheet" href="css/uikit.css">
        <link type="text/css" rel="stylesheet" href="css/components/tooltip.css">
        <link type="text/css" rel="stylesheet" href="css/components/search.css">
        <link type="text/css" rel="stylesheet" href="css/style_index.css">
        <script src="js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="js/uikit.min.js" type="text/javascript"></script>
        <script src="js/components/tooltip.min.js" type="text/javascript"></script>        
        <script src="js/components/search.js" type="text/javascript"></script>

</head>
<body>
<div class=" uk-grid" style="min-height:100%;">
    <div class="o-leftbar uk-hidden-small">
        <ul class="o-menu"><!--可通过设置项设置hover背景色-->
            <li class="o-logo"><a href="#">云</a></li><!--可以设置背景色和文字-->
            
            <!--End 作为外链或页面专题链接-->
        </ul>
        
    </div>
    <div class="o-left uk-width-3-10 uk-hidden-small">
        <div class="o-leftwarp">
            <h1>云笔记</h1>
            <h3>点击左侧云按钮创建笔记</h3>
        </div>
    </div>
    
    
    <div class="o-right uk-width-medium-7-10 ">
        <div class="o-container uk-width-medium-4-5">
            
            <hr class="uk-visible-small" />
            <div class="o-main">
                
                <%
                	//TODO
                %>
        
                <ul class="uk-pagination">
                    <li class="uk-pagination-previous uk-disabled"><span><i class="uk-icon-angle-double-left"></i> 上一页</span></li>
                    <li class="uk-pagination-next"><a href="#">下一页 <i class="uk-icon-angle-double-right"></i></a></li>
                </ul>
                <hr class="uk-article-divider">
            </div>
            
        </div>
    </div>
</div> 
</body>
</html>