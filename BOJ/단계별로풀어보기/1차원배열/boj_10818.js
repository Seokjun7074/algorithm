const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split(" ");
let setInput = input[0].split("\n");
input.shift();
input.unshift(setInput[1]);

let max = input[0];
let min = input[0];
for (let i = 1; i < input.length; i++) {
  if (parseInt(input[i]) >= parseInt(max)) {
    max = input[i];
  }

  if (parseInt(min) >= parseInt(input[i])) {
    min = input[i];
  }
}
console.log(`${parseInt(min)} ${parseInt(max)}`);
