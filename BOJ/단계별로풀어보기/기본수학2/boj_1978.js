const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");

let N = Number(input[0]);
let nums = input[1].split(" ").map((v) => Number(v));
let answer = 0;

for (let i = 0; i < nums.length; i++) {
  if (nums[i] === 1) {
    continue;
  } else {
    let check = 0;
    for (let j = 2; j < nums[i]; j++) {
      if (nums[i] % j === 0) {
        check++;
      }
    }
    if (check === 0) {
      answer++;
    }
  }
}
console.log(answer);
