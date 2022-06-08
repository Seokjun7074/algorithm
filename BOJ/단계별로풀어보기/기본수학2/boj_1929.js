const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");
input = input[0].split(" ");

const N = parseInt(input[0]);
const M = parseInt(input[1]);

// for (let i = N; i <= M; i++) {
//   let num = false;
//   for (let j = 2; j < i; j++) {
//     if (i % j === 0) {
//       num = true;
//     }
//   }
//   if (num === false) console.log(i);
// }

//시간 복잡도 O(n^2)라서 시간초과;;

let arr = Array(M + 1).fill(true);

arr[0] = arr[1] = false;

for (i = 2; i <= Math.sqrt(M); i++) {
  if (!arr[i]) continue;
  for (j = 2; i * j <= M; j++) {
    arr[i * j] = false;
  }
}

for (i = N; i < arr.length; i++) {
  if (arr[i]) console.log(i);
}

//에라토스테네스의 체 사용
