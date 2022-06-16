const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs
  .readFileSync(filepath)
  .toString()
  .trim()
  .split("\n")
  .map((e) => parseInt(e));

const arr = new Array(10001).fill(true).fill(false, 0, 2);
for (let i = 2; i * i <= arr.length; i++) {
  if (arr[i]) {
    for (let j = i * i; j <= arr.length; j += i) {
      arr[j] = false;
    }
  }
}

for (let i = 1; i < input.length; i++) {
  const num = input[i];
  let answer = [];

  for (let j = 2; j <= num / 2; j++) {
    const restNum = num - j;
    if (arr[restNum] && arr[j]) {
      answer.push([j, restNum]);
    }
  }
  const result = answer.pop();
  console.log(`${result[0]} ${result[1]}`);
}
