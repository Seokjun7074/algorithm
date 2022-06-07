const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");

let N = parseInt(input[0]);
let arr = [];
for (let i = 2; i < N; i++) {
  if (N % i === 0) {
    arr.push(i);
    N = N / i;
    i--;
  }
  //   console.log(N);
}
arr.push(N);
// console.log(arr);

if (N === 1) {
  console.log("");
} else {
  arr.forEach((e) => console.log(e));
}
