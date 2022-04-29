const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split(" ");

[A, B, C] = input.map((e) => parseInt(e));
let amount = Math.floor(A / (C - B)) + 1;

if (C - B <= 0) {
  console.log(-1);
} else {
  console.log(amount);
}
