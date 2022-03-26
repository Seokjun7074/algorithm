const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");
const num = Number(input[0]);
for (let i = 1; i <= num; i++) {
  let countO = 0;
  let score = 0;

  for (let j = 0; j < input[i].length; j++) {
    if (input[i][j] === "O") {
      countO += 1;
    } else {
      countO = 0;
    }
    score += countO;
  }
  console.log(score);
}
