const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split(" ");

const N = Number(input[0]); //18
const big = 5;
const small = 3;
let arr = [];
for (let i = 0; i <= parseInt(N / big); i++) {
  for (let j = 0; j <= parseInt(N / small); j++) {
    if (big * i + small * j === N) {
      arr.push(i + j);
    }
  }
}
const min = Math.min(...arr);
console.log(arr.length === 0 ? -1 : min);
