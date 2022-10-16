const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString();

let isAnswer = false;
for (let i = 0; i < parseInt(input); i++) {
  const arr = i
    .toString()
    .split("")
    .map((e) => parseInt(e));
  const sum = arr.reduce((a, b) => a + b, 0);
  if (i + sum === parseInt(input)) {
    isAnswer = true;
    console.log(i);
    return;
  }
}
if (!isAnswer) {
  console.log(0);
}
