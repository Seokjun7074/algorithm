const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");

let sum = 0;
for (let i = 0; i < parseInt(input[0]); i++) {
  sum += parseInt(input[1][i]);
}
console.log(sum);
