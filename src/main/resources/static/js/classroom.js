function loadTeacher() {
		$.ajax({
			url:'/api/user',
			data: {role:"teacher"},
			success: function(data) {
				$("#teacher_id").html("");
				data.forEach(function(item) {
					$("#teacher_id").append('<option value="'+item.id+'">'+ item.name +'</option>');
				});
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
	
	function loadKid() {
		$.ajax({
			url:'/api/user',
			data: {role:"kid"},
			success: function(data) {
				$("#kid_id").html("");
				data.forEach(function(item) {
					$("#kid_id").append('<option value="'+item.id+'">'+ item.name +'</option>');
				});
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
	
	function loadCourse() {
		$.ajax({
			url:'/api/course',
			success: function(data) {
				$("#course_id").html("");
				data.forEach(function(item) {
					$("#course_id").append('<option value="'+item.id+'">'+ item.name +'</option>');
				});
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
	
	function loadClasses(pageNumber) {
		$.ajax({
			url : '/api/classroom/list',
			contentType : "application/json; charset=utf-8",
			data: {pageNumber: pageNumber},
			success : function(data) {
				$("#class-list").html("");
				var classrooms = data.content;
				classrooms.forEach(function(item) {
					$("#class-list").append(
						'<tr>\
							<td>'+ item.courseId + '</td>\
							<td>'+ item.teacherId + '</td>\
							<td>'+ item.kidId + '</td>\
							<td>'+ item.startTime + '</td>\
							<td>'+ item.status + '</td>\
							<td>\
								<a class="btn btn-sm btn-primary" onclick = "updateClass('+ item.id + ')">edit</a>\
								<a class= "btn btn-sm btn-danger" onclick = "deleteClass('+ item.id + ')">del</a>\
								<a class="btn btn-sm btn-warning" onclick = "changeStatus('+ item.id + ')">end</a>\
							</td>\
						</tr>');
					});
					$("#pagination-class").html("");
					var s = "";
					var totalPage = data.totalPages;
					var pageCurent = data.number;
					for (i = 0; i < totalPage; i++) {
						if(i == pageCurent) {
							s += '<li class="page-item active"><a class="page-link" href="#" onclick = "loadClasses('+ i + ')">'+ (i + 1) +'</a></li>';
						} else {
							s += '<li class="page-item "><a class="page-link" href="#" onclick = "loadClasses('+ i + ')">'+ (i + 1) +'</a></li>';
						}
					}
					$("#pagination-class").html(s);
				},
			error : function(e) {
				console.log(e);
			}
		});
	}
	
	function saveClass(classroom) {
		$.ajax({
			processData : false,
			contentType : "application/json; charset=utf-8",
			method : 'post',
			url : '/api/classroom/save',
			data : JSON.stringify(classroom),
			success : function(data) {
				loadClasses(0);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
	
	function updateClass(id) {
		$.ajax({
			url : "/api/classroom/" + id,
			data : {
				id : id
			},
			success : function(data) {
				console.log(data);
				$("#class_id").val(data.id);
				$("#course_id").val(data.courseId);
				$("#teacher_id").val(data.teacherId);
				$("#kid_id").val(data.kidId);
				$("#class_time").val(data.startTime);
				$("#class_status").val(data.status);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
	
	function deleteClass(id) {
		$.ajax({
			contentType : "application/json; charset=utf-8",
			url : "/api/classroom/delete/" + id,
			data : {
				id : id
			},
			success : function(data) {
				loadClasses(0);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
	function changeStatus(id) {
		$.ajax({
			contentType : "application/json; charset=utf-8",
			url : "/api/classroom/changeStatus/" + id,
			data : {
				id : id
			},
			success : function(data) {
				loadClasses(0);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
	$(document).ready(function(){
		loadCourse();
		loadTeacher();
		loadKid();
		loadClasses(0);
		$("#submit-classroom").click(function(){
			var id = $("#class_id").val();
			var courseId = $("#course_id").val();
			var teacherId = $("#teacher_id").val();
			var kidId = $("#kid_id").val();
			var startTime = $("#class_time").val();
			var status = $("#class_status").val();
			var classroom;
			if (id != "") {
				classroom = {id:id, courseId:courseId, teacherId:teacherId, kidId:kidId, startTime:startTime, status:status};
			} else {
				classroom = {courseId:courseId, teacherId:teacherId, kidId:kidId, startTime:startTime, status:status};
			}
			
			if(startTime === null) {
				alert("Thời gian đang để trống!")
			} else {
				saveClass(classroom);
			}
		});
		$("#reload-classroom").click(function(){
			loadCourse();
			loadTeacher();
			loadKid();
			loadClasses(0);
		});
		/* $('.datetimepicker').datetimepicker();
		  
		$('.datetimepicker-addon').on('click', function() {
		  	$(this).prev('input.datetimepicker').data('DateTimePicker').toggle();
		}); */
	});