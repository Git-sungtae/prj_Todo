 function move(el){
	let con = document.getElementById(el.className);
	let parent = con.parentElement;
	parent.removeChild('div');
	console.log(con);
	console.log(parent);
	
 }