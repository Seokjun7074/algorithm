const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split(" ");

const a = parseInt(input[0]);
const b = parseInt(input[1]);

console.log(parseInt(a + b));
console.log(parseInt(a - b));
console.log(parseInt(a * b));
console.log(parseInt(a / b));
console.log(parseInt(a % b));
