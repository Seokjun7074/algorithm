const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");

let max = input[0];
let maxIdx = 0;

let newInput = input.map((n, idx) => {
  if (parseInt(max) <= parseInt(n)) {
    max = n;
    maxIdx = idx + 1;
  }
});
console.log(max);
console.log(maxIdx);
