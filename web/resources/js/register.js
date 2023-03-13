function validation(){
	var ime = document.getElementById('ime').value;
	var prezime = document.getElementById('password').value;
	var broj = document.getElementById('confirm').value;

	if (ime.length < 3) {
		alert("Ime mora da ima vise od 2 karaktera");
		return false;
	}
	else if (password < 4) {
		alert("Sifra mora da ima vise od 3 karaktera");
		return false;
	}
	
	else
	return true;
}