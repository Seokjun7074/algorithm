const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split("\n");

const num = parseInt(input[0]);
let score = input[1].split(" ");
const maxScore = Math.max(...score);

let sum = 0;
for (let i = 0; i < score.length; i++) {
  sum = sum + (score[i] / maxScore) * 100;
}
console.log(sum / num);

//parseInt 남발 금지;;
