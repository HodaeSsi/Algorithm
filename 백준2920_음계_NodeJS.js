const readline = require('readline');
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let input = [];

rl.on('line', function (line) {
	input = line.split(' ').map((el) => parseInt(el));
}).on('close', function () {
	//let asc, desc, mix = true
	//console.log(asc, desc, mix)
	//출력값 null, null, 1;;
	let asc = true, desc = true, mix = true
	//console.log(asc, desc, mix)

	//배열 입력받기
	//input = prompt()
	//console.log(input[1])

	//if first == 1
	if (input[0] == 1) {
		//desc == false
		desc = false
		//for(1 ~ 8) [i] +1 =? [i+1]
		for (let i = 0; i < 7; i++) {
			//깨진다면 ascen == true를 false로
			//console.log("input[i+1]: "+input[i+1]+", input[i]: "+(Number(input[i])+1))
			if (input[i + 1] != (Number(input[i]) + 1)) {
				asc = false;
				console.log("mixed")
				break;
			}
		}
		if (asc)
			console.log("ascending")
	}
	//else if first == 8
	else if (input[0] == 8) {
		asc = false
		for (let i = 0; i < 7; i++) {
			//깨진다면 ascen == true를 false로
			if (input[i + 1] != (Number(input[i]) - 1)) {
				desc = false;
				console.log("mixed")
				break;
			}
		}
		if (desc)
			console.log("descending")
	}
	//else
	else {
		//"mix"" >> ascen & descen = false , mix = true
		asc = false
		desc = false
		console.log("mixed")
	}
	/*
	//what print?
	//console.log(asc ? "ascending" : (desc ? "descending" : (mix ? "mixed" : "WRONG")))
	if(asc == true && desc == false && mix == false)
		console.log("ascending")
	else if(desc == true && asc == false && mix == false)
		console.log("descending")
	else
		console.log("mixed")
	*/

	process.exit();
});