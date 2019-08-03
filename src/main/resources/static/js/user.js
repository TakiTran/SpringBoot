function loadUsers() {
	$.ajax({
		url : '/api/user/list',
		success : function(data) {
			$("#users").html("");
			data.forEach(function(item) {
				$("#users").append(
					'<tr>\
						<td>'+ item.name + '</td>\
						<td>'+ item.role + '</td>\
						<td>\
							<a class="btn btn-sm btn-primary" onclick = "updateUser('+ item.id + ')">edit</a>\
							<a class= "btn btn-sm btn-danger" onclick = "deleteUser('+ item.id + ')">del</a>\
						</td>\
					</tr>');
				});
			},
		error : function(e) {
			console.log(e);
		}
	});
}
function addUser(user) {
	$.ajax({
		processData : false,
		contentType : "application/json; charset=utf-8",
		method : 'post',
		url : '/api/user/save',
		data : JSON.stringify(user),
		success : function(data) {
			loadUsers();
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function updateUser(id) {
	$.ajax({
		url : "/api/user/" + id,
		data : {
			id : id
		},
		success : function(data) {
			$("#user-id").val(data.id);
			$("#user-name").val(data.name);
			$("#user-role").val(data.role);
		},
		error : function(e) {
			console.log(e);
		}
	});
}
function deleteUser(id) {
	$.ajax({
		contentType : "application/json; charset=utf-8",
		url : "/api/user/delete/" + id,
		data : {
			id : id
		},
		success : function(data) {
			loadUsers();
		},
		error : function(e) {
			console.log(e);
		}
	});
}
$(document).ready(function() {
	loadUsers();
	$("#submit-user").click(function() {
		var id = $("#user-id").val();
		var name = $("#user-name").val();
		var role = $("#user-role").val();
		var user;
		if (id != "") {
			user = {
				id : id,
				name : name,
				role : role
			};
		} else {
			user = {
				name : name,
				role : role
			};
		}

		addUser(user);
	});
});