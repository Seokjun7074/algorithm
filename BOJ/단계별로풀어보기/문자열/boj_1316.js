const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");

const N = Number(input[0]);
let answer = 0;

for (let i = 1; i <= N; i++) {
  const word = input[i];
  const check = [];
  let isGroupWord = true;

  for (let j = 0; j < word.length; j++) {
    if (check.indexOf(word[j]) === -1) {
      check.push(word[j]);
    } else {
      if (check.indexOf(word[j]) !== check.length - 1) {
        isGroupWord = false;
        break;
      }
    }
  }

  if (isGroupWord) {
    answer += 1;
  }
}

console.log(answer);
