//완전탐색?
//입력 개수: 2 + N(N: 3 ~ 100)
//모든 경우의 수: 100C3 >> 100 99 98 / 3 2 1 >> 대충 250,000이하

//분석
//1, 2, 3 > 4 > ... > N >> N-1
//1, 3, 4 > 5 > ... > N >> N-2
//...
//1, N-1, N
//2, 3, 4 > 5 > ...
//3중for문
/*
i: 1 ~ N-2
 j: i+1 ~ N-1
  k: j+1 ~ N 
*/
//돌면서 21초과는 다 버리고
//21이하로 제일 큰수를 저장

//입력
const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input.push(line)
  })
  .on('close', function () {
    inputL1 = input[0].split(' ').map((el) => parseInt(el));
    inputL2 = input[1].split(' ').map((el) => parseInt(el));
    //nodejs 콘솔입력받기;;
    const N = Number(inputL1[0])
    const M = Number(inputL1[1])
    const cards = inputL2
    //const 배열!
    let result = 0
    let tempNum = 0
    
    //탐색
    //1~N >> 0~N-1
    for(let i = 0; i < N-2; i++)
    {
        for(let j = i+1; j < N-1; j++)
        {
            for(let k = j+1; k < N; k++)
            {
                tempNum = Number(cards[i]) + Number(cards[j]) + Number(cards[k])
                if((tempNum <= M) && (tempNum > result))
                    result = tempNum
            }
        }
    }

    console.log(result)
    process.exit()
});
