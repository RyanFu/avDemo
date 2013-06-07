<%@page import="java.util.List"%>
<%@page import="com.demo.bo.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<style>
.block{
    background-color: #f5f5f5;
    border-radius: 6px 6px 6px 6px;
    margin-bottom: 30px;
    padding: 30px;
}
.tool_border{
	background-color: #FeFeFe;
    border: 1px solid #CCCCCC;

    min-height: 20px;
    border-radius: 4px 4px 4px 4px;
    min-height: 20px;
	margin-bottom:20px;
}
.tool_header{
	background: linear-gradient(to top, #ECECEC, #F9F9F9) repeat scroll 0 0 #F1F1F1;
	padding:5px 10px 5px 10px;
	border-bottom: 1px solid #CCCCCC;
	border-radius:6px 6px 0 0;
}
.tool_body{
	padding:5px 10px 5px 10px;
	
}
.display_off{
	display:none;
}
.tag{
	margin-left:5px;
}
.thumbnail a:hover{
	
}


</style>

<script type="text/javascript">
	$(function(){
		document.getElementById("movie_form").reset();
		$("#add_category").click(function(){
			if($("#add_category_panel").hasClass('display_off')){
				$("#add_category_panel").removeClass('display_off');
			}else{
				$("#add_category_panel").addClass('display_off');
			}
		});
		
		$("#submit_category").click(function(){
			if($("#category_name").val().length<1){
				toastr.warning("目录名称不能为空哟~");
				return;
			}
			$.post("/category.do?action=New",{
				name:$("#category_name").val(),
				parent_id:$("#category_parent").val()
			}).done(function(data){
				$("#category_list").append('<label class="checkbox"><input name="category" type="checkbox" value="'+data+'">'+$("#category_name").val()+'</label>');
				$("#category_parent").append('<option value="'+data+'">'+$("#category_name").val()+'</option>');
			}).fail(function(data){
				toastr.error(data.responseText);
			});
		});
		
		$("#submit_movie").click(function(){
			console.log($("#movie_form").serialize());
			$.post("/movie.do?action=Create",$("#movie_form").serialize()).done(function(data){
				$("#successBlock").removeClass('display_off');
				$("#newBlock").remove();
				$("#created_movie_id").val(data);
			}).fail(function(data){
				toastr.error(data.responseText);
			});
		});
		
		
		$(".uploadedImage").each(function(){
			
		});
		
	});
</script>

	<div class="container" style="padding:20px;">
		<div id="successBlock" class="display_off" style="margin-bottom: 30px;padding: 30px;min-height:300px;text-align: center;">
			<input type="hidden" id="created_movie_id">
			<h2>恭喜您，您的丰功伟绩以及卓越贡献将会载入史册传承于千秋万代！</h2>
			<a onclick="window.location.href='/movie.do?action=Show&id='+$('#created_movie_id').val()" class="btn btn-info btn-large">立刻查看</a>
			<a class="btn btn-warning btn-large" onclick="window.location.href='/movie.do?action=New'">再来一发</a>
		</div>
		<div class="block" id="newBlock">
			<h2><i class="icon-pencil 4x"></i><span style="margin-left:10px;">添加影片信息</span><a id="submit_movie" class="btn btn-warning"  style="top:-30px;">发布影片</a></h2>
			<form id="movie_form">
				<fieldset>			
					<div class="row">
						<div class="span8">
							
		
								<div class="control-group">
									<div class="controls">
										<input name="name" type="text" placeholder="影片标题" class="span8">
									</div>
								</div>
								
								
								<div class="control-group">
									<div class="controls">
										<textarea name="wiki" placeholder="影片简介" class="span8" style="min-height:150px;"></textarea>
									</div>
								</div>
									
								<div class="control-group">
									<div class="controls">
										<div class="tool_border">
											<div class="tool_header"><h4><i class="icon-camera"></i> 影片截图预览</h4></div>
											<div class="tool_body">
											    <ul class="thumbnails">
												    <li class="span2">
													    <a  class="thumbnail uploadedImage">
													   		<img src="http://placehold.it/280x180" alt="">
													    </a>
												    </li>
												    <li class="span2">
													    <a  class="thumbnail uploadedImage">
													   		<img src="http://placehold.it/280x180" alt="">
													    </a>
												    </li>
												    <li class="span2">
													    <a  class="thumbnail uploadedImage">
													   		<img src="http://placehold.it/280x180" alt="">
													    </a>
												    </li>
												    <li class="span2">
													    <a  class="thumbnail uploadedImage">
													   		<img src="http://placehold.it/280x180" alt="">
													    </a>
												    </li>													    								    
											    </ul>
											</div>
										</div>
									</div>									
								</div>
																					
									
		
						</div>
						<div class="span3" style="width:300px;">



							<div class="tool_border">
								<div class="tool_header"><h4><i class="icon-picture"></i> 影片封面图片</h4></div>
								<div class="tool_body">
								    <ul class="thumbnails">
									    <li class="span3">
										    <a  class="thumbnail">
										   		<img src="http://placehold.it/280x180" alt="">
										    </a>
									    </li>
									</ul>
									<div class="input-append">
										<input style="margin-bottom:0px;" value="http://placehold.it/280x180"><a class="btn btn-info">上传</a>
									</div>
																	
								</div>
							</div>							

							
							<div class="tool_border">
								<div class="tool_header"><h4><i class="icon-book"></i> 分类目录</h4></div>
								<div class="tool_body">
									<div id="category_list">
										<!-- 这里循环输出所有分类目录 -->
										<%for(Category category:(List<Category>)request.getAttribute("categories")){%>
											<label class="checkbox">
												<input name="category" type="checkbox" value="<%=category.getId() %>"><%=category.getName() %>
											</label>
										<%}%>
									</div>
									<a style="cursor:pointer;" id="add_category"><i class="icon-plus"></i>添加目录</a>
									<div id="add_category_panel" class="display_off asdasd">
										<input id="category_name" name="category_name" placeholder="输入分类名称（限5字以内）" type="text">
										<select id="category_parent">
											<option value="0">没有所属分类</option>
										<%for(Category category:(List<Category>)request.getAttribute("categories")){%>
											<option value="<%=category.getId() %>"><%=category.getName() %></option>
										<%}%>
										</select>
										<a id="submit_category" class="btn btn-info">添加新分类目录</a>
									</div>
								</div>
							</div>
							
							
							<div class="tool_border">
								<div class="tool_header"><h4><i class="icon-bookmark-empty"></i> 标签目录</h4></div>
								<div class="tool_body">
									<div class="input-append">
										<input placeholder="输入标签" style="margin-bottom:0px;"/><a class="btn btn-info">添加</a>
									</div>
									<div id="tag_list">
										<div class="tag">
											<span class="label label-warning">标签1</span>
											<i class="icon-remove-sign"></i>
										</div>
										<div class="tag">
											<span class="label label-warning">标签1</span>
											<i class="icon-remove-sign"></i>
										</div>										
									</div>
								</div>
							</div>
							
							

							
							
													
						</div>
					</div>
			
			
				</fieldset>
			</form>
	
		</div>

	</div>

<jsp:include page="../footer.jsp"/>