const fs = require("fs");
const input =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().split(" ")
    : fs.readFileSync("./input.txt").toString().split(" ");

const a = parseInt(input[0]);
const b = parseInt(input[1]);

console.log(parseInt(a + b));
console.log(parseInt(a - b));
console.log(parseInt(a * b));
console.log(parseInt(a / b));
console.log(parseInt(a % b));
