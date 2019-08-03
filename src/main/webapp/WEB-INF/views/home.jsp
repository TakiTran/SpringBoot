<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classroom Manage</title>
</head>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
	
	
	<style>
		.card{
			margin-top: 10px;
		}
	</style>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="card">
					<div class= "card-header">
						<span>Quản lý tài khoản</span>
					</div>
					<div class= "card-body">
						<div class= "user">
							<form id="user-form">
							<div class="row">
							 	<input type="number" style="display:none;" id="user-id"/>
								<div class="form-group col-sm-5">
								    <label >Họ Tên</label>
								    <input type="text" class="form-control" id="user-name" required="required"/>
							  	</div>
							  	<div class="form-group col-sm-5">
								    <label >Đối tượng</label>
								    <select class="form-control" id="user-role">
								    	<option value="teacher">Giáo viên</option>
								    	<option value="kid">Học sinh</option>
								    </select>
							  	</div>
							  	<div class="form-group col-sm-2">
								   <a class="btn btn-sm btn-success" id="submit-user">save</a>
							  	</div>
							</div>
							</form>
						</div>
						<div class= "user-list">
						 	<table class="table">
						 		<thead>
						 			<tr>
						 				<th>Tên</th>
						 				<th>Đối tượng</th>
						 				<th></th>
						 			</tr>
						 		</thead>
						 		<tbody id="users">
						 		
						 		</tbody>
						 	</table>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
			<div class="card">
				<div class="card-header">
						<span>Quản lý khóa học</span>
					</div>
					<div class="card-body">
						<div class="course">
						<form id="course-form">
							<div class="row">
							 	<input type="number" style="display:none;" id="course-id"/>
								<div class="form-group col-sm-5">
								    <label >Tên khóa học</label>
								    <input type="text" class="form-control" id="course-name" required="required"/>
							  	</div>
							  	<div class="form-group col-sm-5">
								    <label >Mô tả</label>
								    <input type="text" class="form-control" id="course-description" required="required"/>
							  	</div>
							  	<div class="form-group col-sm-2">
								   <a class="btn btn-sm btn-success" id="submit-course">save</a>
							  	</div>
							</div>
							</form>
						</div>
						<div class="course-list">
						<table class="table">
						 		<thead>
						 			<tr>
						 				<th>Tên khóa học</th>
						 				<th>Mô tả</th>
						 				<th></th>
						 			</tr>
						 		</thead>
						 		<tbody id="courses">
						 		
						 		</tbody>
						 	</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="card">
					<div class="card-header">
						<span>Quản lý lớp học</span>
					</div>
					<div class="card-body">
						<div class="classroom">
							<form class="classroom-form">
								<input type="hidden" id="class_id" />
								<div class="row">
									<div class="form-group col-sm-2">
									    <label >Khóa học</label>
									   <select class="form-control" id="course_id">
									    	
									    </select>
								  	</div>
								  	<div class="form-group col-sm-2">
									    <label >Giáo viên</label>
									    <select class="form-control" id="teacher_id">
									    	
									    </select>
								  	</div>
								  	<div class="form-group col-sm-2">
									    <label >Học viên</label>
									    <select class="form-control" id="kid_id">
									    
									    </select>
								  	</div>
								  	<div class="form-group col-sm-2">
									    <label >Thời gian bắt đầu</label>
									    <input  class="form-control" type="datetime-local" id="class_time" />
									    <!-- <div class="input-group date">
										  	<input type='text' class="form-control datetimepicker" id= "class_time"/>
										  	<span class="input-group-addon datetimepicker-addon">
										    	<span class="glyphicon glyphicon-calendar"></span>
										  	</span>
										</div> -->
								  	</div>
								  	<div class="form-group col-sm-2">
									    <label >Trạng thái</label>
									    <select class="form-control" id="class_status">
									    	<option value="happening">happening</option>
									    	<option value="happened">happened</option>
									    </select>
								  	</div>
								  	<div class="form-group col-sm-2">
								  	 	<a class="btn btn-sm btn-warning" id="reload-classroom">reload</a>
									   	<a class="btn btn-sm btn-success" id="submit-classroom">save</a>
								  	</div>
								</div>
							</form>
						</div>
						<div class="classroom-list">
							<table class="table">
								<thead>
									<tr>
										<th>Khóa học</th>
										<th>Giáo viên</th>
										<th>Học viên</th>
										<th>Thời gian bắt đầu</th>
										<th>Trạng thái</th>
										<th><th>
									</tr>
								</thead>
								<tbody id="class-list">
								
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
<script src="js/course.js"></script> 
<script src="js/user.js"></script> 
<script src="js/classroom.js"></script> 
<script type="text/javascript">
	
</script>
</html>