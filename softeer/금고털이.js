const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let [W, N] = input
  .shift()
  .split(" ")
  .map((e) => parseInt(e));
const arr = [];
for (let i = 0; i < N; i++) {
  arr.push(input[i].split(" "));
}
arr.sort((a, b) => b[1] - a[1]);
let result = 0;

for (let i = 0; i < N; i++) {
  const weight = arr[i][0];
  const price = arr[i][1];
  if (W > weight) {
    W = W - weight;
    result += weight * price;
  } else {
    result = result + W * price;
  }
}
console.log(result);
