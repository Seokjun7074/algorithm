const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split(" ");

let num1 = input[0];
let num2 = input[1];

num1 = parseInt(num1[2] + num1[1] + num1[0]);
num2 = parseInt(num2[2] + num2[1] + num2[0]);

if (num1 > num2) {
  console.log(num1);
} else {
  console.log(num2);
}
