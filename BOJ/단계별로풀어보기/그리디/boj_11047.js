const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");
let [N, K] = input
  .shift()
  .split(" ")
  .map((e) => parseInt(e));
input = input.map((e) => parseInt(e));

let count = 0;

for (let i = N - 1; i >= 0; i--) {
  if (K >= input[i]) {
    count += parseInt(K / input[i]);
    K -= parseInt(K / input[i]) * input[i];
  }
}
console.log(count);
