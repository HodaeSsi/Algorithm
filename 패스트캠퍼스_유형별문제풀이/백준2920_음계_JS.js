let input = []
//let asc, desc, mix = true
//console.log(asc, desc, mix)
//미친 출력값 null, null, 1;;
let asc = true, desc = true, mix = true
//console.log(asc, desc, mix)


//배열 입력받기
//input = prompt()
//console.log(input[1])
//X >> 첫 원소에 string으로 들어가버린다.(입력: 0, 1, 2, 3)
for(let i = 0; i < 8; i++)
{
	input[i] = prompt() //내가 원하는 메시지를 띄워주고 싶은데?
}
//>> 8번의 입력 말고 한번의 입력 + 문자열 split으로 받아보자
//야 prompt()는 스트링으로 받는데 >> 바로 '수'로 받는법은???

//if first == 1
if(input[0] == 1)
{
	//desc == false
	desc = false
	//for(1 ~ 8) [i] +1 =? [i+1]
	for(let i = 0; i < 7; i++)
	{
		//깨진다면 ascen == true를 false로
		//console.log("input[i+1]: "+input[i+1]+", input[i]: "+(Number(input[i])+1))
		if(input[i+1] != (Number(input[i]) + 1))
		{
			asc = false;
			console.log("mixed")
			break;
		}
	}
	if(asc)
		console.log("ascending")
}
//else if first == 8
else if(input[0] == 8)
{
	asc = false
	for(let i = 0; i < 7; i++)
	{
		//깨진다면 ascen == true를 false로
		if(input[i+1] != (Number(input[i]) - 1))
		{
			desc = false;
			console.log("mixed")
			break;
		}
	}
	if(desc)
		console.log("descending")
}
//else
else
{
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
