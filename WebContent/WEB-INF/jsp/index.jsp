<%@page import="com.demo.util.ConstConverter"%>
<%@page import="com.demo.bo.UserActivity"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.bo.Movie"%>
<%@page import="com.demo.bo.User"%>
<%@page import="com.demo.action.SessionContainer"%>
<jsp:useBean id="se" scope="application" class="com.demo.action.SessionContainer"></jsp:useBean>
<jsp:useBean id="user" class="com.demo.bo.User"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	se = (SessionContainer)session.getAttribute("sessionContainer");
%>



<jsp:include page="header.jsp"/>
<style>
.new_item{
	margin-bottom:15px;
	width:266px;
	height:64px;
}
.new_intro{
	margin-left:10px;
	float:left;
	width:200px;
}


</style>
<script type="text/javascript">
	$(function(){
		$("#newMovieBtn").button("reset");
		$("#newMovieBtn").click(function(){
			$(this).button("loading");
			window.location.href="movie.do?action=New";
		});
		$('.carousel').carousel();
		$('.carousel-inner div:first').addClass("active");
		
	});
</script>	
	<!-- body content -->
	<div class="content">
		<div class="container">
		<%if(se==null || se.getUser()==null){ %>
			<div class="span11" style="margin-left:0px;">
					<div class="alert alert-warning">
						<a class="close" data-dismiss="alert">×</a>
						<h4>快放我进去！</h4>
						<div class="row">
							<div class="span4">
								<form class="form-horizontal" id="login_form" style="margin: 0 0 0 0;">
									<fieldset>
										<div class="control-group">
											<div class="controls" style="margin-left:0px;">
												<input type="text" placeholder="那你输入账号呗" id="account" name="username" value="">
											</div>
										</div>
										<div class="control-group">
											<div class="controls" style="margin-left:0px;">
												<input type="password" placeholder="还有密码..." id="pass" name="password" value="">
											</div>
										</div>
										<div class="control-group">
											<div class="controls" style="margin-left:0px;">
												<img alt="" style="cursor:pointer;" src="/auth">
												<a href="#" onclick="$(this).prev().attr('src','/auth?'+Math.random())">给爷换一个</a>
												<input style="width:75px;" type="text" placeholder="验证码哟亲" id="auth" name="authCode" value="">
												
											</div>
										</div>
										<input type="button" class="btn btn-success" data-loading-text="正在登录..." style="width:100px;margin-left:120px;" id="login_btn" value="登录">
									</fieldset>
								</form>							
							</div>
							<div class="span6">
								这里放点宣传语或者图片勾引用户注册
							</div>
						</div>
					</div>
			</div>
		<%}%>
			<div class="span8" style="margin-left:0px;">
				<div class="row">
					<div class="span3"><h3>趁热赶快看了吧...</h3></div>
					<%if(se!=null && se.getUser()!=null){ %>
						<div class="span5"><input id="newMovieBtn" data-loading-text="少女努力祈祷中..." type="button" class="btn btn-info btn-large pull-right" value="我也来分享个片儿吧"></div>
					<%} %>
				</div>
				<div style="margin-top:10px;">
				    <div id="myCarousel" class="carousel" style="width:720px;height:480px;">
					    <!-- Carousel items -->
					    <div class="carousel-inner">
					    	<%for(Movie movie:(List<Movie>) request.getAttribute("hotest")){ %>
					    	
					    		<div class="item">
					    			<a href="/movie.do?action=Show&id=<%=movie.getId()%>">
						    			<div style="float:left;"><img alt="" src="http://placehold.it/720x480"></div>
						    			<div style="position: absolute;left:15px;top:15px;font-size:18px;"><%=movie.getName() %></div>
					    			</a>
					    		</div>
					    	<%} %>
					    </div>
					    <!-- Carousel nav -->
					    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
					    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				    </div>					
				</div>
				<div class="row">
					<div class="span3"><h3>认识她们不...</h3></div>
					<%if(se!=null && se.getUser()!=null){ %>
						<div class="span5"><a class="btn btn-success btn-large pull-right">我还认识你不认识的</a></div>
					<%} %>
					
				</div>
				<div class="alert" style="height:600px;margin-top:10px;">这里是占位置的，放妹纸</div>
			</div>
			<div class="span3">
				<div class="row">
					<div class="span3"><h3>新片儿速递...</h3></div>
					
				</div>
				<div style="float:right;"><a href="/movie.do?action=Index">更多...</a></div>
				
				<hr>
				<div>
					<%for(Movie movie : (List<Movie>) request.getAttribute("newest")){ %>
					
						<div class="new_item">
							<img src="http://placehold.it/48x64" alt="" style="float:left;">
							<div class="new_intro">
								<span class="label label-warning">片名</span><a style="cursor: pointer;" href="/movie.do?action=Show&id=<%=movie.getId()%>"><%=movie.getName()%></a><br>
								<%if(movie.getWiki().length()>26){%>
									<span class="label label-warning">简介</span><%=movie.getWiki().substring(0, 25) %>...
								<%}else{ %>
									<span class="label label-warning">简介</span><%=movie.getWiki()%>
								<%} %>						
							</div>
							
						</div>
									
					<%} %>			
				</div>



				<div class="row">
					<div class="span3"><h3>最近大家都在干这些事...</h3></div>
				</div>
				<div style="float:right;"><a href="#">更多...</a></div>
				<hr>
				<div style="margin-bottom:20px;">
					
					<%for(UserActivity activity :(List<UserActivity>)request.getAttribute("activities")) {%>
					<div class="activity_item">
						<a>@<%=activity.getUser().getNickname() %></a>
						 <%=ConstConverter.ConvertActionType(activity.getAction()) %>
						 <%=ConstConverter.ConvertTargetType(activity.getTarget_type()) %>
						<a href="/<%=activity.getTarget_type() %>.do?action=Show&id=<%=activity.getTarget_id()%>"><%=activity.getTarget_name() %></a>
					</div>
					<%} %>					
					

				</div>

				<div class="row">
					<div class="span3"><h3>加入团伙...</h3></div>
				</div>
				<div class="alert" style="height:300px;margin-top:20px;">这里是占位置的，放人气最旺的小组信息</div>
				
				

				
				
								
				
			</div>
			
		</div>

	</div>
	
	
<jsp:include page="footer.jsp"></jsp:include>
