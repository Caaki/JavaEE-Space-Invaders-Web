     
function buildTable(data){
		var table = document.getElementById('skorovi');

		for (var i = 0; i < data.length; i++){
			var row = `<li><a href='#'>
							<h4 class='li-head'>${data[i].username}</h4>
							<p class='li-sub'>Last score ${data[i].lastscore}</p>
							<p class='li-sub'> High score: ${data[i].highscore}</p>
					  </a></li>`;
			table.innerHTML += row;


		}
	}

const api_url = 'http://localhost:8080/CS230-PZ/webresources/com.pz.entiteti.users';

async function getInfo(){
    const response = await fetch(api_url);
    const data = await response.json();
    console.log(data);
    buildTable(data);
}
getInfo();

	