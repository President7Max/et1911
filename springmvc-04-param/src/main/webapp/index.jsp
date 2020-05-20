<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h2>测试数组传参</h2>
	<form action="${pageContext.request.contextPath }/complex/array"
		method="post">
	爱好:
	<input type="checkbox" name="hobby" value="看">看
	<input type="checkbox" name="hobby" value="听">听
	<input type="checkbox" name="hobby" value="唱">唱
	<br>
	<input type="submit" value="测试数组传参">
	</form>
	
	<hr>
	
	<h2>测试List传参</h2>
	<form action="${pageContext.request.contextPath }/complex/list"
		method="post">
	爱好:
	<input type="checkbox" name="hobbyList" value="看">看
	<input type="checkbox" name="hobbyList" value="听">听
	<input type="checkbox" name="hobbyList" value="唱">唱
	<br>
	<input type="submit" value="测试List传参">
	</form>
	
	<hr>
	<button id="testMap" type="button">测试Map</button>
	
	<hr>
	<button onclick="jsonToMap()" type="button">测试json转Map</button>
	
	<hr>
	<button onclick="jsonToList()" type="button">测试json转List</button>
	
	<hr>
	<button onclick="jsonToBean()" type="button">测试json转Bean</button>
	
	<script src="${pageContext.request.contextPath }/status/js/jquery-3.4.1.js" type="text/javascript"></script>
	<script type="text/javascript">
		const path = "${pageContext.request.contextPath}"
		
		$(function() {
			//alert(path)
			//测试map传参
			$('#testMap').click(()=>{
				$.ajax({
					url:path+'/complex/map',
					type:'post', //http method
					dataType:'text',
					data:"stuMap['id']=1&stuMap['name']=阿伟",
					success:function(data){
						alter(data);
					}
				});
			});
		})
		
		function jsonToMap() {
			let obj = {id:1, name:'阿伟'};
			$.ajax({
				url:path + '/json/jsonToMap',
				type:'post',
				data:JSON.stringify(obj),//将json对象转换成json字符串
				dataType:'json',
				contentType:'application/json;charset=UTF-8',
				success:function(data){
					alert(data.msg);
				}
			})
		}
		
		function jsonToList(){
			let array = [{id:2,name:"阿鲁卡",age:24}];
			let user = {id:1,name:"阿伟",age:23};
			array.push(user);
			$.ajax({
				url:path+'/json/jsonToList',
				type:'post',
				data:JSON.stringify(array),
				dataTyp:'json',
				contentType:'application/json;charset=UTF-8',
				success:function(data){
					alert(data.code+" - "+data.msg);
				}
			})
		}
		
		function jsonToBean() {
			let obj = {
					id:1,
					name:"阿伟",
					age:23,
					hobbyList:["打游戏","嘤嘤嘤"],
					stuMap:{id:2,score:200}
			};
			$.ajax({
				url:path+'/json/jsonToBean',
				type:'post',
				data:JSON.stringify(obj),
				dataType:'json',
				contentType:'application/json;charset=UTF-8',
				success:function(data){
					alert(data.code+":"+data.msg);
				}
			})
		}
		
		
		
	</script>
	
	
	
	
	
	
</body>
</html>