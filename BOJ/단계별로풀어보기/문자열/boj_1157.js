const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString();

input = input.toUpperCase();
let arr = [];
let maxString = "";
for (let i = 65; i <= 90; i++) {
  arr.push(String.fromCharCode(i));
}

let idx = new Array(arr.length).fill(0);

for (let i = 0; i < input.length; i++) {
  const index = arr.indexOf(input[i]);
  idx[index]++;
}

let max = Math.max(...idx);
let maxIdx = idx.indexOf(max);

for (let i = 0; i < idx.length; i++) {
  if (max === idx[i] && maxIdx != i) {
    maxString = "?";
    break;
  } else {
    maxString = arr[maxIdx];
  }
}
console.log(maxString);
