<%@page import="com.demo.bo.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="movie" class="com.demo.bo.Movie"/>
<%movie = (Movie)request.getAttribute("movie"); %>
<jsp:include page="../header.jsp"/>
<script type="text/javascript">
<!--
	$(function(){
		$('.carousel').carousel();
	});
//-->
</script>

<style>
<!--
	.action{
		cursor: pointer;
		
	}
-->
</style>


<div class="container" style="margin-top:20px;">
<h2 style="margin-left:30px;"><%=movie.getName() %></h2>
	<div class="row">
		<div class="span8">
			
			<div class="span8">
				<div class="row">
					<div class="span3">													    
						<a  class="thumbnail uploadedImage">
					   		<img src="http://placehold.it/270x320" alt="">
					    </a></div>
					<div class="span4" style="margin-left:60px;">
						<div class="row">
							简介：<%=movie.getWiki() %>
						</div>
						
					
					</div>
				</div>
				<div style="margin:15px 0px 15px 0px;">
					你想对这部片做点什么？<a class="action">喜欢</a>(45)　<a class="action">看过</a>(70)　<a class="action">想看</a>(405)　<a class="action">来一发</a>(999+)
				</div>
				<hr>
				<h4>影片儿截图在这儿</h4>
				
				<div class="span8" style="margin-top:20px;">
				    <div id="myCarousel" class="carousel" style="width:720px;height:480px;">
					    <!-- Carousel items -->
					    <div class="carousel-inner">
						    <div class="active item"><img alt="" src="http://placehold.it/720x480"></div>
						    <div class="item"><img alt="" src="http://placehold.it/720x480"></div>
						    <div class="item"><img alt="" src="http://placehold.it/720x480"></div>
					    </div>
					    <!-- Carousel nav -->
					    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
					    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				    </div>				
				
				
				</div>
				
				
				<hr>
				<h4>良心站点放图又放种</h4>
				<div class="span8" style="margin-top:20px;">
					<div class="input-append">
						电驴下载地址：<input style="margin-bottom:0px;" class="input-xxlarge" value="http://placehold.it/"><a class="btn btn-info">复制</a>
					</div>
					<div class="input-append">
						迅雷下载地址：<input style="margin-bottom:0px;" class="input-xxlarge" value="http://placehold.it/"><a class="btn btn-warning">复制</a>
					</div>					
					<div class="input-append">
						其他下载地址：<input style="margin-bottom:0px;" class="input-xxlarge" value="http://placehold.it/"><a class="btn btn-primary">复制</a>
					</div>
				</div>
			</div>
		</div>
		<div class="span4">
			<div style="margin:15px;">
				<h4>来吐个槽</h4>
				<textarea style="width:330px;margin-bottom:0px;"></textarea>
				<div style="height:40px;"><a class="btn btn-success pull-right" style="width:70px;">发送</a></div>
				
				<hr>
				<div class="comments">
					<div class="comment_item">XXX对这部片说：这是一个评论啦</div>
					<hr>
					<div class="comment_item">XXX对这部片说：这是一个评论啦</div>
					<hr>
					<div class="comment_item">XXX对这部片说：这是一个评论啦</div>
				</div>
				
			</div>
			
		</div>
	</div>
</div>

<jsp:include page="../footer.jsp"/>