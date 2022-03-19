const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");
const answer = String(
  parseInt(input[0]) * parseInt(input[1]) * parseInt(input[2])
).split("");
// console.log(answer);

let count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
for (let i = 0; i < answer.length; i++) {
  count[parseInt(answer[i])] = count[parseInt(answer[i])] + 1;
}
for (let i = 0; i < count.length; i++) {
  console.log(count[i]);
}
