const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().trim().split("\n");

let arr = []; //나머지가 있는 배열
let same = []; //중복된거 제거된 배열
for (let i = 0; i < input.length; i++) {
  arr.push(parseInt(input[i]) % 42);
}
for (let i = 0; i < arr.length; i++) {
  if (!same.includes(arr[i])) {
    same.push(arr[i]);
  }
}
console.log(same.length);
