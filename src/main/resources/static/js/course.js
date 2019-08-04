function loadCourses(pageNumber) {
	$.ajax({
			url : '/api/course/list',
			contentType : "application/json; charset=utf-8",
			data: {pageNumber: pageNumber},
			success : function(data) {
				$("#courses").html("");
				var courses = data.content;
				courses.forEach(function(item) {
				$("#courses").append(
					'<tr>\
						<td>'+ item.name+ '</td>\
						<td>'+ item.description+ '</td>\
						<td>\
							<a class="btn btn-sm btn-primary" onclick = "updateCourse('+ item.id + ')">edit</a>\
							<a class= "btn btn-sm btn-danger" onclick = "deleteCourse('+ item.id + ')">del</a>\
						</td>\
					</tr>');
				});
				$("#pagination-course").html("");
				var s = "";
				var totalPage = data.totalPages;
				var pageCurent = data.number;
				for (i = 0; i < totalPage; i++) {
					if(i == pageCurent) {
						s += '<li class="page-item active"><a class="page-link" href="#" onclick = "loadCourses('+ i + ')">'+ (i + 1) +'</a></li>';
					} else {
						s += '<li class="page-item "><a class="page-link" href="#" onclick = "loadCourses('+ i + ')">'+ (i + 1) +'</a></li>';
					}
				}
				$("#pagination-course").html(s);
			},
			error : function(e) {
				console.log(e);
			}
		});
}
function addCourse(course) {
	$.ajax({
		processData : false,
		contentType : "application/json; charset=utf-8",
		method : 'post',
		url : '/api/course/save',
		data : JSON.stringify(course),
		success : function(data) {
			loadCourses(0);
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function updateCourse(id) {
	$.ajax({
		url : "/api/course/" + id,
		data : {
			id : id
		},
		success : function(data) {
			$("#course-id").val(data.id);
			$("#course-name").val(data.name);
			$("#course-description").val(data.description);
		},
		error : function(e) {
			console.log(e);
		}
	});
}
function deleteCourse(id) {
	$.ajax({
		contentType : "application/json; charset=utf-8",
		url : "/api/course/delete/" + id,
		data : {
			id : id
		},
		success : function(data) {
			loadCourses(0);
		},
		error : function(e) {
			console.log(e);
		}
	});
}
$(document).ready(function() {
	loadCourses(0);
	$("#submit-course").click(function() {
		var id = $("#course-id").val();
		var name = $("#course-name").val();
		var description = $("#course-description").val();
		var course;
		if (id != "") {
			course = {
				id : id,
				name : name,
				description : description
			};
		} else {
			course = {
				name : name,
				description : description
			};
		}

		addCourse(course);
	});
});