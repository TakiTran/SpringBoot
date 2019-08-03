function loadCourses() {
	$.ajax({
			url : '/api/course/list',
			success : function(data) {
				$("#courses").html("");
				data.forEach(function(item) {
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
			loadCourses();
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
			loadCourses();
		},
		error : function(e) {
			console.log(e);
		}
	});
}
$(document).ready(function() {
	loadCourses();
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