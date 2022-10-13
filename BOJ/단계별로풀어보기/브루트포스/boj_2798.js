const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split("\n");

let answer = 0;
const N = parseInt(input[0].split(" ")[0]);
const M = parseInt(input[0].split(" ")[1]);
const arr = input[1].split(" ").map((e) => parseInt(e));

for (let i = 0; i < N; i++) {
  for (let j = i + 1; j < N; j++) {
    for (let k = j + 1; k < N; k++) {
      const sum = arr[i] + arr[j] + arr[k];
      if (sum >= answer && sum <= M) {
        answer = sum;
      }
    }
  }
}
console.log(answer);
