const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split("\n");
for (let i = 1; i <= input[0]; i++) {
  let idx = input[i].split(" ");
  let A = parseInt(idx[0]);
  let B = parseInt(idx[1]);
  console.log(`Case #${i}: ${A + B}`);
}
