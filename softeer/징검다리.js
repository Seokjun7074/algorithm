const fs = require("fs");
let [N, ...input] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
N = Number(N);
const arr = input
  .toString()
  .split(" ")
  .map((e) => Number(e));

dp = [];
for (let i = 0; i < N + 1; i++) {
  dp.push(1);
}
for (let i = 0; i < N; i++) {
  for (let j = 0; j < i; j++) {
    if (arr[i] > arr[j]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
}
console.log(Math.max(...dp));
