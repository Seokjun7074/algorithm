const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = parseInt(fs.readFileSync(filepath).toString());

let group = 1;
let sum = 1;

while (input > sum) {
  group++;
  sum += group;
}
if (group % 2 === 0) {
  console.log(`${group - sum + input}/${1 + sum - input}`);
} else {
  console.log(`${1 + sum - input}/${group - sum + input}`);
}
