function isValidData() {

	var firstName = document.getElementById("first_name").value;
	if (firstName == "") {
		alert("Please input a first name");
		return false;
	}

	var lastName = document.getElementById("last_name").value;
	if (lastName == "") {
		alert("Please input a last name");
		return false;
	}

	var email = document.getElementById("email").value;
	if (email == "") {
		alert("Please input an email");
		return false;
	}

	return true;
}
